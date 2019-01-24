package org.expensesplanner.category;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository {

    private static Map<Long, CategoryEntity> categories = new HashMap<>();
    private static Long id = 0L;

    @Override
    public CategoryEntity findById(Long id) {
        return categories.get(id);
    }

    @Override
    public void add(CategoryEntity categoryEntity) {
        categoryEntity.setId(++id);
        categories.put(id, categoryEntity);
    }

    @Override
    public List<CategoryEntity> getCategories() {
        return new ArrayList<>(categories.values());
    }
}
