package ua.lviv.iot.TripadvisorMVC.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.TripadvisorMVC.model.dal.AddressRepository;
import ua.lviv.iot.TripadvisorMVC.model.domain.Address;

@Service
public class AddressService extends AbstractService<Address> {

	@Autowired
	public AddressService(AddressRepository repository) {
		super(repository);
	}
}
