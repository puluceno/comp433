/**
 * 
 */
package edu.luc.comp433.service;

import javax.jws.WebService;

import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Customer;
import edu.luc.comp433.model.Payment;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
@WebService
public interface CustomerService extends BaseService<Short, Customer> {

	public Customer findCustomerByLogin(String login);

	/**
	 * @param customer
	 * @param address
	 * @param payment
	 * @return
	 */
	public Customer createOrUpdateCustomer(Customer customer, Address address,
			Payment payment);
}
