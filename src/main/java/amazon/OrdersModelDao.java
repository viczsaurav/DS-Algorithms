package amazon;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class OrdersModelDao implements Serializable {

	// Since single in-memory store, use singleton class
	// https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
	private static OrdersModelDao ordersModelDao;

	private static Map<UUID, OrdersModel> ordersMap = new ConcurrentHashMap<>();
//	private static List<UUID> mostRecentOrders = Collections.synchronizedList(new ArrayList<>());
	private static List<UUID> mostRecentOrders = new CopyOnWriteArrayList<>();

	// ------------------------ START of SingleTon Class Implementation ----------------------- //

	// Make constructor private
	private OrdersModelDao(){}

	//Not Thread-safe
	public static OrdersModelDao getInstance(){
		if (ordersModelDao==null){
			ordersModelDao = new OrdersModelDao();
		}
		return ordersModelDao;
	}

	// Thread safe but non-performant
	public static synchronized OrdersModelDao getSynchronizedInstance(){
		if(ordersModelDao == null){
			ordersModelDao = new OrdersModelDao();
		}
		return ordersModelDao;
	}

	// Bill Pugh Singleton Implementation using private inner static class
	private static class SingletonHelper {
		private static final OrdersModelDao instance =  new OrdersModelDao();
	}

	public static OrdersModelDao getSingletonInstance(){
		return SingletonHelper.instance;
	}


	// When using `implements Serializable`,the problem with serialized singleton class is that whenever its deserialized,
	// it will create a new instance of the class.
	// to overcome this scenario all we need to do it provide the implementation of readResolve() method.
	protected Object readResolve() {
		return getSingletonInstance();
	}

	// ------------------------ END of SingleTon Class Implementation ----------------------- //


	public UUID add(List<Integer> items) throws Exception {
		OrdersModel o = new OrdersModel(items);
		ordersMap.put(o.getOrderID(), o);
		mostRecentOrders.add(o.getOrderID());
		return o.getOrderID();
	}

	public UUID update(UUID orderID, List<Integer> items) throws Exception {
		// Change only permitted if order is in created/pending state
		OrdersModel o = ordersMap.get(orderID);
		if (o==null) {
			return add(items);
		}
		if (o.getOrderSatus()=='C' || o.getOrderSatus()=='P'){
			o.setOrderItemIDs(items);
			ordersMap.put(orderID, o);
			mostRecentOrders.remove(orderID);		// The previous value needs to be removed. Its not a Set
			mostRecentOrders.add(orderID);
		}
		return orderID;
	}

	public boolean delete(UUID orderID) throws Exception {
		ordersMap.remove(orderID);
		mostRecentOrders.remove(orderID);
		return true;
	}

	public Optional<OrdersModel> get(UUID orderID) throws Exception {
		return Optional.ofNullable(ordersMap.get(orderID));
	}

	public List<OrdersModel> getLastOrders(int n){

		/**
		 * We can also use Doubly linked list to always have sorted Orders in O(1) time
		 * But have to maintain space to get actual object - So space will be O(2n)
		 */
		int size =  mostRecentOrders.size();
		List<UUID> lastOrders= mostRecentOrders.subList(size-n, size);

		Collections.reverse(lastOrders);

		return Collections.unmodifiableList(
						lastOrders.stream()
											.map(ordersMap::get)
											.collect(Collectors.toList()));

//		for (int i=1; i<=n;i++){
//			lastOrders.add(ordersMap.get(mostRecentOrders.get(size-i)));
//		}
//		return Collections.unmodifiableList(lastOrders);
	}
}
