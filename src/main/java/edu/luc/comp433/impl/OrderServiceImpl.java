package edu.luc.comp433.impl;

import java.util.List;

import edu.luc.comp433.dao.OrderDAO;
import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.model.Order;
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
			return e.getMessage();
		}
		try {
			orderDAO.createOrder(new Order(user, address, books, payment));
			return "Order created!";
		} catch (Exception e) {
			return "System error";
		}
	}

	/**
	 *
	 * @param user
	 * @param address
	 * @param books
	 * @param payment
	 * @throws Exception
	 */
	private void verifyOrder(User user, Address address, List<Book> books,
			Payment payment) throws Exception {
		if (user == null || user.getId() == null)
			throw new Exception("Invalid userID.");
		if (address == null || address.getId() == null)
			throw new Exception("Address invalid.");
		if (books == null || books.isEmpty())
			throw new Exception("Your shopping cart is empty.");
		if (payment == null || payment.getType() == null)
			throw new Exception("Payment method not selected.");
	}

	@Override
	public String cancelOrder(Short orderID) {
		try {
			orderDAO.findOrderByID(orderID).setStatus(OrderStatus.CANCELED);
			return "Order cancelled succesfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String checkOrderStatus(Short orderID) {
		try {
			return orderDAO.findOrderByID(orderID).getStatus();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
