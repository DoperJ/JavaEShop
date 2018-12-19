package top.doperj.user.Address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.user.service.AddressService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopUserAddressTests {
    @Autowired
    AddressService addressService;

    @Test
    public void addAddress() throws Exception {
        addressService.addAddress(
                "doperj",
                (short) 510641,
                "广东省",
                "广州市",
                "天河区",
                "华南理工大学北区",
                true
        );
    }

    @Test
    public void findAllAddresses() throws Exception {
        System.out.println(addressService.findAllAddress());
    }

    @Test
    public void findAddressesByUserName() throws Exception {
        System.out.println(addressService.findAddressByUserName("doperj"));
    }
}
