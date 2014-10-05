package edu.luc.comp433.service;

import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.model.Customer;
import edu.luc.comp433.model.Order;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.model.enumerator.OrderStatus;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
@WebService
public interface OrderService extends BaseService<Short, Order> {

	/**
	 * Creates an order for the given customer.
	 *
	 * @param customer
	 *            Customer who created the order
	 * @param address
	 *            Address to delivery
	 * @param books
	 *            Books in the order
	 * @param payment
	 *            Payment information
	 * @return Message to the customer informing whether the order has been created
	 *         successfully or not.
	 */
	public Short createOrder(Customer customer, Address address, List<Book> books,
			Payment payment);

	/**
	 * Cancel an order
	 *
	 * @param orderId
	 *            Order ID used to find the order an then cancel it.
	 * @return true if order is cancelled, otherwise false.
	 */
	public Boolean cancelOrder(Short orderId);

	/**
	 * Check the order status for a given order id
	 *
	 * @param orderId
	 *            Order ID used to find the order an display its current status.
	 * @return Current order status.
	 */
	public OrderStatus checkOrderStatus(Short orderId);
	
	/**
	 * Locate orders from specific customer
	 * 
	 * @param login
	 * 			Login of the customer
	 * @return List of orders sorted by Status.
	 */
	List<Order> findOrderByCustomerLogin(String login);

}