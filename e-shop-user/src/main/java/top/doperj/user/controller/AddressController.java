package top.doperj.user.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.doperj.user.domain.Address;
import top.doperj.user.domain.User;
import top.doperj.user.service.AddressService;
import top.doperj.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.*;

@Controller
@RequestMapping("/api/address")
public class AddressController {
    Logger logger = LoggerFactory.getLogger(Object.class);

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

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

    @PostMapping("")
    @ResponseBody
    public Address createAddress(HttpServletRequest httpServletRequest) {
        try {
            Address address = new Address();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            logger.info("Request Body:" + reqBody);
            JSONObject json = new JSONObject(reqBody);
            String userName = json.getString("userName");
            User user = userService.findUserByName(userName);
            if (user == null) {
                logger.error("No user named: " + userName);
                return null;
            }
            address.setUserId(user.getUserId());
            address.setProvince(json.getString("province"));
            address.setCity(json.getString("city"));
            address.setDistrict(json.getString("district"));
            address.setAddress(json.getString("address"));
            address.setZip(json.getInt("zip"));
            address.setPhoneNum(json.getString("phoneNum"));
            address.setIsDefault(false);

            logger.info("[getRequestPostJson][" + json
                    + "]-- get request body with json success.");
            System.out.println(address);
            addressService.addAddress(address);
            return address;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
        //return orderService.addOrderByViewOrder(viewOrder);
    }
}
