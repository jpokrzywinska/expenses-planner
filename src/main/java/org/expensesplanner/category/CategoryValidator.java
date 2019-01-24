package org.expensesplanner.category;

import org.expensesplanner.expenses.InvalidExpenseException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CategoryValidator {


    void validate(CategoryDto categoryDto) {
        if (isEmptyString(categoryDto.getName())) {
            throw new InvalidExpenseException("Name is empty!");
        }
    }

    private boolean isEmptyString(String arg) {
        return isNull(arg) || arg.trim().isEmpty();
    }
}
