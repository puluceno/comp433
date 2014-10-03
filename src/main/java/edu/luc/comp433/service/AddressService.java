/**
 * 
 */
package edu.luc.comp433.service;

import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Address;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
@WebService
public interface AddressService extends BaseService<Short, Address> {

	public Address findAddressById(Short id);
	public List<Address> findAddressByCustomerId(Short customerId);
	
}
