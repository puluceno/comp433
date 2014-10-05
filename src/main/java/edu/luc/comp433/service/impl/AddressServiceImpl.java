/**
 * 
 */
package edu.luc.comp433.service.impl;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.luc.comp433.dao.AddressDao;
import edu.luc.comp433.dao.impl.AddressDaoImpl;
import edu.luc.comp433.model.Address;
import edu.luc.comp433.service.AddressService;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
@WebService(endpointInterface = "edu.luc.comp433.service.AddressService")
public class AddressServiceImpl implements AddressService {

	private AddressDao addressDao = new AddressDaoImpl();
	
	@Override
	public List<Address> findAddressByCustomerId(@WebParam(name="customerId") Short customerId) {
		return addressDao.findAddressByCustomerId(customerId);
	}

	@Override
	public Address findAddressById(@WebParam(name="id") Short id) {
		return addressDao.findById(id);
	}

}
