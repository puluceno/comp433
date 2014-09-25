package edu.luc.comp433.dao;

import java.util.ArrayList;
import java.util.List;

import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.model.Orders;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.model.User;

public class OrderDAO {
	private List<Orders> orders = new ArrayList<Orders>();

	/**
	 *
	 */
	public OrderDAO() {
	}

	/**
	 *
	 * @param user
	 * @param address
	 * @param books
	 * @param payment
	 */
	public OrderDAO(User user, Address address, List<Book> books,
			Payment payment) {
		orders.add(new Orders(user, address, books, payment));
	}

	/**
	 *
	 * @param newOrder
	 * @throws Exception
	 */
	public void createOrder(Orders newOrder) throws Exception {
		orders.add(newOrder);
	}

	public Orders findOrderByID(Short orderID) throws Exception {
		for (Orders order : orders) {
			if (order.getId().equals(orderID))
				return order;
		}
		throw new Exception("Could not find order with ID " + orderID);
	}
}