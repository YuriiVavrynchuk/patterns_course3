package ua.lviv.iot.tripadvisor.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.tripadvisor.domain.Address;
import ua.lviv.iot.tripadvisor.service.AddressService;

@RequestMapping("/address")
@RestController
public class AddressController extends AbstractController<Address> {

	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		super(addressService);
		this.addressService = addressService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") Integer addressId, @RequestBody Address address) {
		address.setId(addressId);
		Address updatedAddress = addressService.update(addressId, address, new Address());
		if (updatedAddress != null) {
			return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
		} else {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
	}
}