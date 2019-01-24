package org.expensesplanner.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public CategoryEntity map(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDto.getName());
        return categoryEntity;
    }
}
