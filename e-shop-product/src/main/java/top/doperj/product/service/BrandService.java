package top.doperj.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.BrandMapper;
import top.doperj.product.domain.Brand;

import java.util.List;

@Service(value = "brandService")
public class BrandService {
    @Autowired
    BrandMapper brandDAO;

    // Create
    public int addBrand(Brand brand) {
        return brandDAO.insertSelective(brand);
    }

    // Read
    public List<Brand> findAllBrands() {
        return brandDAO.selectAllBrands();
    }

    public Brand findBrandByName(String brandName) {
        return brandDAO.selectByBrandName(brandName);
    }

    // Update
    public Brand updateBrandByName(String name1, String name2) {
        Brand brand = brandDAO.selectByBrandName(name1);
        brand.setBrandName(name2);
        brandDAO.updateByPrimaryKey(brand);
        return brand;
    }

    // Delete
    public int removeBrand(Brand brand) {
        return brandDAO.deleteByPrimaryKey(brand.getBrandId());
    }

    public void removeBrandByName(String brandName) {
        brandDAO.deleteByBrandName(brandName);
    }

}