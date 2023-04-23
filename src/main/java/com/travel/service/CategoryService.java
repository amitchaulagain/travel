package com.travel.service;

import com.travel.model.entities.Category;
import com.travel.model.entities.enums.CategoryNameEnum;

import java.util.List;

public interface CategoryService {
    Category findByName(CategoryNameEnum category);

    List<Category> initCategories();
}
