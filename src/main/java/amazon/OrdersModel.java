package amazon;

import java.util.*;

public class OrdersModel {
	private UUID orderID;
	private long created;
	private long lastUpdated;
	private char orderSatus;		//[created, pending, In-transit, delivered]
	private List<Integer> orderItemIDs;

	public OrdersModel(){

	}
	public OrdersModel(UUID orderID){
		this.orderID = orderID;
	}

	public OrdersModel(List<Integer> orderItemIDs){
		this.orderID = UUID.randomUUID();
		this.created = System.currentTimeMillis();
		this.lastUpdated = System.currentTimeMillis();
		this.orderSatus = 'C';
	}
	// Setters and Getters

	public UUID getOrderID() {
		return orderID;
	}

	public char getOrderSatus() {
		return orderSatus;
	}

	public void setOrderSatus(char orderSatus) {
		this.orderSatus = orderSatus;
	}

	public List<Integer> getOrderItemIDs() {
		return orderItemIDs;
	}

	public void setOrderItemIDs(List<Integer> orderItemIDs) {
		this.lastUpdated = System.currentTimeMillis();
		this.orderItemIDs = orderItemIDs;
	}

	@Override
	public String toString() {
		return "OrdersModel : { " +
						"orderID=" + orderID +
						", created=" + created +
						", lastUpdated=" + lastUpdated +
						", orderSatus=" + orderSatus +
						", orderItemIDs=" + orderItemIDs +
						" }";
	}
}
