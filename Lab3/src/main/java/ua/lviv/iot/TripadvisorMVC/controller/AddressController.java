package ua.lviv.iot.TripadvisorMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ua.lviv.iot.TripadvisorMVC.model.domain.Address;
import ua.lviv.iot.TripadvisorMVC.model.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/addresses")
	public String getAll(Model model) {
		model.addAttribute("addresses", addressService.findAll());
		return "addresses";
	}

	@GetMapping("/showNewAddressForm")
	public String showNewAddressForm(Model model) {
		Address address = new Address();
		model.addAttribute("address", address);
		return "create_address";
	}

	@GetMapping("/showUpdateAddressForm/{id}")
	public String showUpdateAddressForm(@PathVariable("id") Integer addressId, Model model) {
		Address address = addressService.getById(addressId);
		model.addAttribute("address", address);
		return "update_address";
	}

	@PostMapping("/saveAddress")
	public String saveAddress(@ModelAttribute("address") Address address, Model model) {
		addressService.saveToDatabase(address);
		return "redirect:/addresses";
	}
	
	@GetMapping("/deleteAddress/{id}")
	public String deleteAddress(@PathVariable("id") Integer id) {
		addressService.deleteById(id);
		return "redirect:/addresses";
	}
}