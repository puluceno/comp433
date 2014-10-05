package edu.luc.comp433.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.luc.comp433.dao.OrderDao;
import edu.luc.comp433.dao.impl.OrderDaoImpl;
import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.model.Customer;
import edu.luc.comp433.model.Order;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.model.enumerator.OrderStatus;
import edu.luc.comp433.service.CustomerService;
import edu.luc.comp433.service.OrderService;
import edu.luc.comp433.service.exception.OrderNotFoundException;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
@WebService(endpointInterface = "edu.luc.comp433.service.OrderService")
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private CustomerService customerService = new CustomerServiceImpl();

	@Override
	public Short createOrder(@WebParam(name = "customer") Customer customer,
			@WebParam(name = "address") Address address,
			@WebParam(name = "bookList") List<Book> books,
			@WebParam(name = "payment") Payment payment) {

		try {
			if (null == books)
				books = Collections.emptyList();
				
			Order order = new Order();
			order.getBookList().addAll(books);
				
			BigDecimal amount = new BigDecimal(0);
			
			for (Book book: books) {
				amount = amount.add(book.getPrice());
				book.getOrderList().add(order);
			}
				
			payment.setAmount(amount);
			order.setCustomer(customer);
			order.setAddress(address);
			order.setPayment(payment);
			order.setStatus(OrderStatus.PROCESSING);
		
			customer = customerService.createOrUpdateCustomer(customer, address, payment);
			orderDao.getEntityManager().getTransaction().begin();
			order = orderDao.merge(order);
			orderDao.getEntityManager().getTransaction().commit();
			
			return order.getId();
		
		} catch (Exception e) {
			e.printStackTrace();
			orderDao.getEntityManager().getTransaction().rollback();
			return null;
		}
	}

	@Override
	public Boolean cancelOrder(@WebParam(name = "orderId") Short orderId) {
		try {
			if (null != orderId) {
				Order toCancel = orderDao.findById(orderId);
				if (null != toCancel
						&& toCancel.getStatus().equals(OrderStatus.PROCESSING)) {
					toCancel.setStatus(OrderStatus.CANCELED);
					orderDao.getEntityManager().getTransaction().begin();
					orderDao.merge(toCancel);
					orderDao.getEntityManager().getTransaction().commit();

					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public OrderStatus checkOrderStatus(@WebParam(name = "orderId") Short orderId) {
		if (null != orderId) {
			Order toCheck = orderDao.findById(orderId);
			if (null != toCheck)
				return toCheck.getStatus();
		}
		
		throw new OrderNotFoundException(orderId);
	}

	@Override
	public List<Order> findOrderByCustomerLogin(String login) {
		return orderDao.findOrderByCustomerLogin(login);
	}

}
