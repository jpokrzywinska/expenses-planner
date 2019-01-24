package org.expensesplanner.category;

import java.util.List;

public interface CategoryRepository {

    CategoryEntity findById(Long id);

    void add(CategoryEntity categoryEntity);

    List<CategoryEntity> getCategories();
}
