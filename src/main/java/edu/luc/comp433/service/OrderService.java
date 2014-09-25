package edu.luc.comp433.service;

import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.model.User;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
@WebService
public interface OrderService {

	/**
	 * Creates an order for the given user.
	 *
	 * @param user
	 *            User who created the order
	 * @param address
	 *            Address to delivery
	 * @param books
	 *            Books in the order
	 * @param payment
	 *            Payment information
	 * @return Message to the user informing whether the order has been created
	 *         successfully or not.
	 */
	public String createOrder(User user, Address address, List<Book> books,
			Payment payment);

	/**
	 * Cancel an order
	 *
	 * @param orderId
	 *            Order ID used to find the order an then cancel it.
	 * @return Message to the user informing whether the order has been
	 *         cancelled succesfully or not.
	 */
	public String cancelOrder(Short orderId);

	/**
	 * Check the order status for a given order id
	 *
	 * @param orderId
	 *            Order ID used to find the order an display its current status.
	 * @return Current order status.
	 */
	public String checkOrderStatus(Short orderId);

}