package org.expensesplanner.expenses;

import org.springframework.stereotype.Service;

@Service
public class ExpensesMapper {
    public ExpenseEntity map(ExpenseDto dto) {
        ExpenseEntity entity = new ExpenseEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        entity.setPerson(dto.getPerson());
        entity.setDate(dto.getDate());
        return entity;
    }
}
