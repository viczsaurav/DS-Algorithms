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
	// Setters and Getters

	public UUID getOrderID() {
		return orderID;
	}


	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
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
