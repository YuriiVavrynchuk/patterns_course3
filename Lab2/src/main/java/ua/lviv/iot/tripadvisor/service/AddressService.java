package ua.lviv.iot.tripadvisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.tripadvisor.dal.AddressRepository;
import ua.lviv.iot.tripadvisor.domain.Address;

@Service
public class AddressService extends AbstractService<Address> {

	@Autowired
	public AddressService(AddressRepository repository) {
		super(repository);
	}

	@Override
	public Address mapCsvToObject(String[] objectCsv) {
		String country = objectCsv[1];
		String city = objectCsv[2];
		String street = objectCsv[3];
		Integer building = Integer.parseInt(objectCsv[4]);

		return new Address(country, city, street, building);
	}
}
