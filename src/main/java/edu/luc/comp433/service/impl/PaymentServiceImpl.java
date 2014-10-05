/**
 * 
 */
package edu.luc.comp433.service.impl;

import java.util.Collections;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.luc.comp433.dao.PaymentDao;
import edu.luc.comp433.dao.impl.PaymentDaoImpl;
import edu.luc.comp433.model.Payment;
import edu.luc.comp433.service.PaymentService;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
@WebService(endpointInterface = "edu.luc.comp433.service.PaymentService")
public class PaymentServiceImpl implements PaymentService {

	private PaymentDao paymentDao = new PaymentDaoImpl();
	
	@Override
	public List<Payment> findPaymentByCustomerId(
			@WebParam(name = "customerId") Short customerId) {
		return Collections.emptyList();
	}

	@Override
	public Payment findPaymentById(@WebParam(name = "id") Short id) {
		return paymentDao.findById(id);
	}

}

