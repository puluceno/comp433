package edu.luc.comp433.service;

import javax.jws.WebService;

@WebService
public interface OrderService {

	public String createOrder();

	public String cancelOrder();

	public String checkOrderStatus();

}