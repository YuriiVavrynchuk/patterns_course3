package ua.lviv.iot.tripadvisor.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.tripadvisor.dal.UserRepository;
import ua.lviv.iot.tripadvisor.domain.Address;
import ua.lviv.iot.tripadvisor.domain.User;

@Service
public class UserService extends AbstractService<User> {

	private final AddressService addressService;

	@Autowired
	public UserService(UserRepository userRepository, AddressService addressService) {
		super(userRepository);
		this.addressService = addressService;
	}

	@Override
	public User mapCsvToObject(String[] objectCsv) {
		String username = objectCsv[1];
		String password = objectCsv[2];
		String avatarUrl = objectCsv[3];
		LocalDate dateOfAccession = LocalDate.parse(objectCsv[4]);
		String description = objectCsv[5];
		Address address = addressService.getById(Integer.parseInt(objectCsv[6]));

		return new User(username, password, avatarUrl, dateOfAccession, description, address);
	}
}
