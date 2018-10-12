package top.doperj.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.domain.Brand;
import top.doperj.product.service.BrandService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void showAllBrands() {
        System.out.println(brandService.findAllBrands());
    }

	@Test
	public void addBrand() {
        System.out.println(brandService.findAllBrands());
        Brand brand = new Brand();
/*        brand.setBrandName("Nike");
        brand.setIntroduction("Just do it.");
        brand.setLogoUrl("/img/Nike.png");*/
/*        brand.setBrandName("Apple");
        brand.setIntroduction("Welcome to the big screens.");
        brand.setLogoUrl("img/Apple.png");*/
/*        brand.setBrandName("Uniqlo");
        brand.setIntroduction("UNIQLO is a clothing apparel company, which was originally founded in Yamaguchi, Japan in 1949 as a textiles manufacturer. Now it is a global brand with over 1000 stores around the world. Redefining clothing, with a focus on quality and textiles which has been unwavered since the company’s origins in 1949.");
        brand.setLogoUrl("img/Uniqlo.png");*/
/*        brand.setBrandName("Samsung");
        brand.setIntroduction("三星集团（全球知名综合性企业）成立于1938年，创办人为李秉喆，公司最初主要出口朝鲜南半岛的鱼干、蔬菜和水果。1950年代逐步扩展为制糖、制药、纺织等制造业，并确立为家族制企业。1969年成立三星电子。1980年代三星电子以卖冰箱为主，1986年时李秉喆成立三星经济研究所。旗下子公司包含：三星电子、三星SDI、三星SDS、三星电机、三星康宁、三星网络、三星火灾、三星证券、三星物产、三星重工、三星工程、三星航空和三星生命等，并由家族内的李氏成员管理，其中三星电子公司被美国《财富》杂志评选为世界500强企业，三星在中国主要经营产品包括：三星手机、电视、数码影音、电脑办公及BSV液晶拼接屏等产品。");
        brand.setLogoUrl("img/Samsung.png");
        brandService.addBrand(brand);*/
/*        brand.setBrandName("Addidas");
        brand.setIntroduction("阿迪达斯 (Adidas) 是德国运动用品制造商，是 Adidas AG 集团公司的成员公司。阿迪达斯 (Adidas) 品牌的前身在1920 年于德国赫佐格奥拉赫(Herzogenaurach)开始生产鞋类产品。1948 年，阿迪达斯 (Adidas) 的创办人阿道夫·阿迪达斯勒 (Adolf Adi Dassler) 先生用他的中间名adi 和姓氏Dassler的头三个字母组成，合成\"adidas\"作为商品品牌并申请注册；1949年8月18日以 adidas AG 名字注册公司，adidas 的Logo，著名的呈三角形的3三条线商标问世。");
        brand.setLogoUrl("img/Addidas.png");
		brandService.addBrand(brand);*/
        System.out.println(brandService.findAllBrands());
	}

    @Test
    public void removeBrand() {
        System.out.println(brandService.findAllBrands());
        Brand brand = brandService.findBrandByName("Nike");
        brandService.removeBrand(brand);
        System.out.println(brandService.findAllBrands());
    }

    @Test
    public void updateBrand() {
        //System.out.println(brandService.findBrandByName("Addidas"));
        //brandService.updateBrandByName("Addidas", "Nike");
        //System.out.println(brandService.findBrandByName("Nike"));
        System.out.println(brandService.findBrandByName("Nike"));
        brandService.updateBrandByName("Nike", "Addidas");
        System.out.println(brandService.findBrandByName("Addidas"));
    }
}
