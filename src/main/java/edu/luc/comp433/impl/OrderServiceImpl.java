package edu.luc.comp433.impl;

import java.util.List;

import edu.luc.comp433.dao.OrderDAO;
import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Book;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelOrder(Short orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus checkOrderStatus(Short orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
