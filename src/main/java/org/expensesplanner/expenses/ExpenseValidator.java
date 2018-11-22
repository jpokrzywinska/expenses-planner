package org.expensesplanner.expenses;

import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ExpenseValidator {

    void validate(ExpenseDto expenseDto) {
        if (isEmptyString(expenseDto.getName())) {
            throw new InvalidExpenseException("Name is empty!");
        }
        if (isEmptyString(expenseDto.getPrice().toString())) {
            throw new InvalidExpenseException("Price is empty!");
        }
        if (isEmptyString(expenseDto.getPerson())) {
            throw new InvalidExpenseException("Person is empty!");
        }
    }

    private boolean isEmptyString(String arg) {
        return isNull(arg) || arg.trim().isEmpty();
    }
}
