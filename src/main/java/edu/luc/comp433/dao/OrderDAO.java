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

	public OrderDAO() {
	}

	public OrderDAO(User user, Address address, List<Book> books,
			Payment payment) {
		orders.add(new Orders(user, address, books, payment));
	}

	public void createOrder(Orders newOrder) throws Exception {
		orders.add(newOrder);
	}

}
