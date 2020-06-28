package amazon;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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
		UUID uuid =  UUID.randomUUID();
		while (ordersMap.keySet().contains(uuid)){
			uuid = UUID.randomUUID();
		}

		OrdersModel o = new OrdersModel(uuid);
		o.setOrderSatus('C');
		o.setCreated(System.currentTimeMillis());
		o.setLastUpdated(System.currentTimeMillis());
		ordersMap.put(uuid, o);
		mostRecentOrders.add(uuid);
		return uuid;
	}

	public UUID update(UUID orderID, List<Integer> items) throws Exception {
		// Change only permitted if order is in created/pending state
		OrdersModel o = ordersMap.get(orderID);
		if (o==null) {
			return add(items);
		}
		if (o.getOrderSatus()=='C' || o.getOrderSatus()=='P'){
			o.setOrderItemIDs(items);
			o.setLastUpdated(System.currentTimeMillis());
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
		List<OrdersModel> lastOrders= new ArrayList<>();

		int size =  mostRecentOrders.size();

		for (int i=1; i<=n;i++){
			lastOrders.add(ordersMap.get(mostRecentOrders.get(size-i)));
		}
		return lastOrders;
	}
}
