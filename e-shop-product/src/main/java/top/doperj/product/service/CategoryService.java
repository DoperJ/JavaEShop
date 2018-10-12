package top.doperj.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.product.dao.CategoryMapper;
import top.doperj.product.domain.Category;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "categoryService")
public class CategoryService {

    @Autowired
    CategoryMapper categoryDAO;

    // Create
    public int addCategory(Category category) {
        return categoryDAO.insert(category);
    }

    public void addCategoryByName(Category category) {

    }
    public void addCategoriesByNameArray(String[] arr) {
        categoryDAO.insertCategoryBatch(Arrays.asList(arr));
    }

    // Read
    public List<Category> findAllCategories() {
        return categoryDAO.selectAllCategories();
    }

    public Category findCategoryByName(String categoryName) {
        return categoryDAO.selectByCategoryName(categoryName);
    }

    // Update
    public Category updateCategoryByName(String name1, String name2) {
        Category category = categoryDAO.selectByCategoryName(name1);
        category.setCategoryName(name2);
        categoryDAO.updateByPrimaryKey(category);
        return category;
    }

    public Category setSupCategory(String name1, String name2) {
        Category category = categoryDAO.selectByCategoryName(name1);
        Category sup_category = categoryDAO.selectByCategoryName(name2);
        if (category == null) {
            System.out.println("No category named: " + name1);
        }
        if (sup_category == null) {
            System.out.println("No category named: " + name2);
        }
        category.setCategoryId(sup_category.getCategoryId());
        categoryDAO.updateByPrimaryKey(category);
        return category;
    }

    public void setSupCategoryBatch(String[] arr, String sup_name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", Arrays.asList(arr));
        Category category = findCategoryByName(sup_name);
        map.put("supCategoryId", category.getCategoryId());
        categoryDAO.setSupCategoryBatch(map);
    }

    // Delete
    public int removeCategory(Category category) {
        return categoryDAO.deleteByPrimaryKey(category.getCategoryId());
    }

    public int removeCategoryByName(String categoryName) {
        return categoryDAO.deleteByCategoryName(categoryName);
    }

}
