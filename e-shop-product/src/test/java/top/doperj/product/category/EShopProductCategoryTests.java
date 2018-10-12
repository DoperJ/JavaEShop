package top.doperj.product.category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.doperj.product.domain.Category;
import top.doperj.product.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShopProductCategoryTests {
/*    String[] categories_sub = {"男装", "女装"};
    String[] categories_sub_man = {"男士外套", "休闲裤", "T恤", "牛仔裤", "衬衫", "男士裤装", "特色男装"};
    String[] categories_sub_woman = {"外套", "裙装", "裙装", "打底毛衣", "卫衣", "裤装", "特色类目"};*/

    String[] categories_sub = {"手机数码", "电脑办公"};
    String[] categories_sub_phone = {"手机", "手机配件", "摄影摄像", "影音娱乐", "数码配件", "智能设备", "电子教育"};
    String[] categories_sub_PC = {"电脑", "平板电脑", "电脑配件", "外设产品", "网络产品", "游戏设备", "办公设备", "文具", "耗材"};

    @Autowired
    CategoryService categoryService;

    @Test
    public void showAllCategories() {
        System.out.println(categoryService.findAllCategories());
    }

    @Test
    public void addCategory() {
        Category category = new Category();
        //category.setCategoryName("服装");
        //category.setCategoryName("电子产品");
        categoryService.addCategory(category);
        System.out.println(categoryService.findAllCategories());
    }

    @Test
    public void addCategories() throws Exception {
        //categoryService.addCategoriesByNameArray(categories_sub);
        //categoryService.addCategoriesByNameArray(categories_sub_man);

        //categoryService.addCategoriesByNameArray(categories_sub);
        categoryService.addCategoriesByNameArray(categories_sub_phone);
        categoryService.addCategoriesByNameArray(categories_sub_PC);
    }

    @Test
    public void setCategoriesSupCategory() throws Exception {
        //categoryService.setSupCategoryBatch(categories_sub_man, "男装");
        //categoryService.setSupCategoryBatch(categories_sub_woman, "女装");

        //categoryService.setSupCategoryBatch(categories_sub, "电子产品");
        categoryService.setSupCategoryBatch(categories_sub_phone, "手机数码");
        categoryService.setSupCategoryBatch(categories_sub_PC, "电脑办公");
        System.out.println(categoryService.findAllCategories());
    }

    @Test
    public void removeCategory() throws Exception {
        int i = categoryService.removeCategoryByName("服装");
        System.out.println(categoryService.findAllCategories());
    }
}
