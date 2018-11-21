package org.expensesplanner.expenses;

import java.awt.*;

public class ExpensesService {

    private ExpenseValidator expenseValidator;

    public void add(ExpenseDto expenseDto) {
        expenseValidator.validate(expenseDto);
    }
}
