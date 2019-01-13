package top.doperj.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.doperj.user.domain.Address;
import top.doperj.user.service.AddressService;

import java.util.List;

@Controller
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping(value = "/{username}", produces = "application/json")
    @ResponseBody
    public List<Address> getAddressByUsername(@PathVariable("username") String username) {
        return addressService.findAddressesByUserName(username);
    }

    @GetMapping(value = "")
    @ResponseBody
    public String getAddressContentById(@RequestParam("addressId") Integer addressId) {
        return addressService.fingAddressContentByAddressId(addressId);
    }
}
