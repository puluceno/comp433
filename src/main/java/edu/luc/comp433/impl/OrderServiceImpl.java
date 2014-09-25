package edu.luc.comp433.impl;

import java.util.List;

import edu.luc.comp433.dao.OrderDAO;
import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.model.Orders;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.model.User;
import edu.luc.comp433.model.enumerator.OrderStatus;
import edu.luc.comp433.service.OrderService;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
public class OrderServiceImpl implements OrderService {

	OrderDAO orderDAO = new OrderDAO();

	@Override
	public String createOrder(User user, Address address, List<Book> books,
			Payment payment) {

		try {
			verifyOrder(user, address, books, payment);
		} catch (Exception e) {

		}
		try {
			orderDAO.createOrder(new Orders(user, address, books, payment));
			return "Order created!";
		} catch (Exception e) {
			return "System error";
		}
	}

	private void verifyOrder(User user, Address address, List<Book> books,
			Payment payment) throws Exception {
		// TODO: validate all parameters
	}

	@Override
	public String cancelOrder(Short orderId) {
		return null;
	}

	@Override
	public OrderStatus checkOrderStatus(Short orderId) {
		return null;
	}

}
