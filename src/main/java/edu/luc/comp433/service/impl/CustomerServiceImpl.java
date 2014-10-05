/**
 * 
 */
package edu.luc.comp433.service.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.luc.comp433.dao.CustomerDao;
import edu.luc.comp433.dao.impl.CustomerDaoImpl;
import edu.luc.comp433.model.Address;
import edu.luc.comp433.model.Customer;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.service.CustomerService;
import edu.luc.comp433.service.exception.InvalidAddressException;
import edu.luc.comp433.service.exception.InvalidPaymentException;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
@WebService(endpointInterface = "edu.luc.comp433.service.CustomerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();
	
	public Customer findCustomerByLogin(@WebParam(name = "customerLogin") String login) {
		return customerDao.findByLogin(login);
	}

	@Override
	public Customer createOrUpdateCustomer(Customer customer, Address address,
			Payment payment) {

		try {
			customerDao.getEntityManager().getTransaction().begin();
			if (null == address)
				throw new InvalidAddressException();
			
			customer.getAddressList().add(address);
			address.setCustomer(customer);
			
			if (null == payment)
				throw new InvalidPaymentException();
			
			customer.getPaymentList().add(payment);
			payment.setCustomer(customer);
			
			if (null != customer.getId()) {
				customer = customerDao.attach(customer);
				customerDao.merge(customer);
			} else {
				customerDao.persist(customer);
			}
			customerDao.getEntityManager().getTransaction().commit();
			return customerDao.attach(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
			customerDao.getEntityManager().getTransaction().rollback();
			return null;
		}
	}
}

