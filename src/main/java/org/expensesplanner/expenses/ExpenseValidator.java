package org.expensesplanner.expenses;

import java.util.Objects;

public class ExpenseValidator {
    public void validate(ExpenseDto expenseDto) {
        if( Objects.isNull(expenseDto) || expenseDto.getName().trim().isEmpty()){
            throw new InvalidExpenseException("Name is empty!");
        }

    }
}
