/**
 * 
 */
package edu.luc.comp433.service;

import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Payment;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
@WebService
public interface PaymentService extends BaseService<Short, Payment> {

	public Payment findPaymentById(Short id);
	
	public List<Payment> findPaymentByCustomerId(Short customerId);
	
}
