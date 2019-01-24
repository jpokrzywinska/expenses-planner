package org.expensesplanner.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryValidator categoryValidator;

    private CategoryMapper categoryMapper;

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryValidator categoryValidator, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryValidator = categoryValidator;
        this.categoryRepository = categoryRepository;
    }


    public void add(CategoryDto categoryDto) {
        categoryValidator.validate(categoryDto);
        CategoryEntity categoryEntity = categoryMapper.map(categoryDto);
        categoryRepository.add(categoryEntity);
    }
}
