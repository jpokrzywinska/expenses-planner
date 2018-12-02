package org.expensesplanner.expenses;

import java.util.List;

public interface ExpensesRepository {

    void add(ExpenseEntity expenseEntity);

    List<ExpenseEntity> getExpenses();
}
