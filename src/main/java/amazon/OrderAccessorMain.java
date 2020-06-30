package amazon;

import java.util.*;

public class OrderAccessorMain {

	public static void main(String[] args) {
		OrdersModelDao dao =  OrdersModelDao.getSingletonInstance();
		OrdersModelDao dao1 =  OrdersModelDao.getSingletonInstance();

		System.out.println("Hash of both objects are equal? : "+ (dao.hashCode()==dao1.hashCode()));

		Map<UUID, String> order = new LinkedHashMap<>();
		try{
			UUID order2 = dao.add(Arrays.asList(new Integer[]{2,2,3}));
			UUID order4 = dao.add(Arrays.asList(new Integer[]{1,2,3}));
			UUID order6 = dao.add(Arrays.asList(new Integer[]{1,1,1}));

			order.put(dao.add(Arrays.asList(new Integer[]{1,2,3})), "order1");
			order.put(order2, "order2");
			order.put(dao.add(Arrays.asList(new Integer[]{4,2,3})), "order3");
			order.put(order4, "order4");
			order.put(dao.add(Arrays.asList(new Integer[]{1,2,1})), "order5");
			order.put(order6, "order6");
			order.put(dao.add(Arrays.asList(new Integer[]{2,1,1})), "order7");

			System.out.println("Creation Order");
			order.forEach((k,v)-> System.out.println(k+ " => "+ v));
			System.out.println("---------------------");


			System.out.println(dao.update(order2, Arrays.asList(new Integer[]{1,2,3}))+ ", original: "+ order2);
			System.out.println(dao.update(order4, Arrays.asList(new Integer[]{1,3,3}))+ ", original: "+ order4);

			dao.delete(order6);

			System.out.println(dao.get(order2).get().toString());

			System.out.println("---------------------");

			System.out.println("Expected order(Most recent to last): order4 => order2 => order7 => order5 => order3");
			System.out.println("---------------------");
			dao.getLastOrders(6).forEach(x-> System.out.println(order.get(x.getOrderID())+ " =>" + x.toString()));

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
