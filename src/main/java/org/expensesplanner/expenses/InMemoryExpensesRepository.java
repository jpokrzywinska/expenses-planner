package org.expensesplanner.expenses;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryExpensesRepository implements ExpensesRepository{

   private static Map<Long, ExpenseEntity> expenses = new HashMap<>();
   private static Long id = 0L;

    @Override
    public void add(ExpenseEntity expenseEntity) {
        expenseEntity.setId(++id);
        expenses.put(id, expenseEntity);
    }

    @Override
    public List<ExpenseEntity> getExpenses() {
        return new ArrayList<>(expenses.values());
    }

    @Override
    public ExpenseEntity findById(Long id) {
        return expenses.get(id);
    }

    @Override
    public void update(ExpenseEntity expenseEntity) {
        expenses.put(expenseEntity.getId(), expenseEntity);
    }

    @Override
    public void delete(Long id) {
        expenses.remove(id);
    }

}
