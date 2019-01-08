package top.doperj.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.doperj.product.domain.Category;
import top.doperj.product.service.CategoryService;

import java.util.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "", produces = "application/json")
    public List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping(path = "/{level}", produces = "application/json")
    public List<Category> getCategoriesByLevel(@PathVariable("level") int level) {
        return getCategoriesByLevelHelper(level);
    }

    @GetMapping(path = "/{level}/{sup_category_name}", produces = "application/json")
    public List<Category> getCategoriesByLevelAndSupCategoryName(@PathVariable("level") int level, @PathVariable("sup_category_name") String supCategoryName) {
        List<Category> supcategoryList = getCategoriesByLevelHelper(level);
        Category supCategory = categoryService.findCategoryByName(supCategoryName);
        Set<Category> supCategorySet = new HashSet<Category>(supcategoryList);
        if (!supCategorySet.contains(supCategory)) {
            logger.error("No super category in level " + level + " named: " + supCategoryName + "!");
            return null;
        }
        List<Category> categoryList = getCategoriesByLevelHelper(level + 1);
        List<Category> result = new LinkedList<Category>();
        Iterator<Category> iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getSupCategoryId() == supCategory.getCategoryId()) {
                result.add(category);
            }
        }
        return result;
    }

    private List<Category> getCategoriesByLevelHelper(int level) {
        List<Category> categoryList = categoryService.findAllCategories();
        List<Category> categoryList1 = new LinkedList<Category>();
        List<Category> categoryList2 = new LinkedList<Category>();
        List<Category> categoryList3 = new LinkedList<Category>();
        Iterator<Category> iterator;
        iterator = categoryList.iterator();
        Set<Integer> supCategoryIdSet;
        Set<Integer> categoryIdSet = new HashSet<Integer>();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getSupCategoryId() == null) {
                categoryList1.add(category);
                categoryIdSet.add(category.getCategoryId());
            }
        }
        supCategoryIdSet = categoryIdSet;
        categoryIdSet = new HashSet<Integer>();
        iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (supCategoryIdSet.contains(category.getSupCategoryId())) {
                categoryList2.add(category);
                categoryIdSet.add(category.getCategoryId());
            }
        }
        supCategoryIdSet = categoryIdSet;
        categoryIdSet = new HashSet<Integer>();
        iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (supCategoryIdSet.contains(category.getSupCategoryId())) {
                categoryList3.add(category);
                categoryIdSet.add(category.getCategoryId());
            }
        }
        switch (level) {
            case 1: return categoryList1;
            case 2: return categoryList2;
            case 3: return categoryList3;
            default: return categoryList;
        }
    }
}
