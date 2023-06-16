package ua.lviv.iot.TripadvisorMVC.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.TripadvisorMVC.model.dal.UserRepository;
import ua.lviv.iot.TripadvisorMVC.model.domain.User;

@Service
public class UserService extends AbstractService<User> {


	@Autowired
	public UserService(UserRepository userRepository) {
		super(userRepository);
	}
}
