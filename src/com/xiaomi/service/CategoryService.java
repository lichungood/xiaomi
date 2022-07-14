package com.xiaomi.service;

import com.xiaomi.bean.Category;
import com.xiaomi.dao.CategoryDao;
import com.xiaomi.utils.PageTool;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
     CategoryDao dao=new CategoryDao();

    public PageTool<Category> findAllCategory(String currentPage) {
        int totalSize=dao.findCategoryCount();
        PageTool<Category>categories=new PageTool<>(currentPage,totalSize);
        List<Category>list=dao.findAllCategory(categories.getStartIndex(),categories.getPageSize());
        categories.setResult(list);
        return categories;
    }


    public boolean addCategory(Category category)  {
        int row=dao.addCategory(category);
        return row>0;
    }


    public boolean deleteCategoryById(String ids) {
        int row=dao.deleteCategoryById(ids);
        return row>0;
    }

    public Category findCategoryById(String cid) {
        Category category=dao.findCategoryById(cid);
        return category;
    }

    public boolean updateCategory(Category category) {
        int row=dao.updateCategory(category);
        return row>0;
    }

    public List<Category> findAllCategory() {
        List<Category>categories=dao.findAllCategory();
        return categories;
    }
    public List<Category> findAllCategory(int count) {
        List<Category>categories=dao.findAllCategory(count);
        return categories;
    }
}
