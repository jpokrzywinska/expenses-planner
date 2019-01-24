package org.expensesplanner.expenses;

import org.expensesplanner.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpensesMapper {

    private CategoryRepository categoryRepository;

    public ExpensesMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ExpenseEntity map(ExpenseDto dto) {
        ExpenseEntity entity = new ExpenseEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setCategory(categoryRepository.findById(dto.getCategoryId()));
        entity.setPerson(dto.getPerson());
        entity.setDate(dto.getDate());
        return entity;
    }

    public List<ExpenseDto> mapList(List<ExpenseEntity> expenseEntities) {
       return expenseEntities.stream().map(entity->map(entity)).collect(Collectors.toList());
    }

    public ExpenseDto map (ExpenseEntity entity){
        ExpenseDto dto = new ExpenseDto();
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setPerson(entity.getPerson());
        dto.setDate(entity.getDate());
        dto.setCategoryId(entity.getCategory().getId());
        return dto;

    }
}
