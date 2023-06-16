package ua.lviv.iot.tripadvisor.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.tripadvisor.domain.User;
import ua.lviv.iot.tripadvisor.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController extends AbstractController<User> {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super(userService);
		this.userService = userService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer userId, @RequestBody User user) {
		user.setId(userId);
		User updatedUser = userService.update(userId, user, new User());
		if (updatedUser != null) {
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
}
