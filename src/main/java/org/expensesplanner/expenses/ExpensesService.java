package org.expensesplanner.expenses;

import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class ExpensesService {

    private ExpenseValidator expenseValidator;

    public ExpensesService(ExpenseValidator expenseValidator) {
        this.expenseValidator = expenseValidator;
    }

    public void add(ExpenseDto expenseDto) {

        expenseValidator.validate(expenseDto);




    }
}
