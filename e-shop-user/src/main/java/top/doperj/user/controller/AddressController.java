package top.doperj.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import top.doperj.user.domain.Address;
import top.doperj.user.service.AddressService;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/api/address/{username}")
    @ResponseBody
    public List<Address> getAddressByUsername(@PathVariable("username") String username) {
        return addressService.findAddressesByUserName(username);
    }
}
