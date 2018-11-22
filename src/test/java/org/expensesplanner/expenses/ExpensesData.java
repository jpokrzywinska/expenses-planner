package org.expensesplanner.expenses;

import java.time.LocalDateTime;

public class ExpensesData {

    public static ExpenseDto createDummyExpenseDto() {
        return ExpenseDto.builder()
                .name("Pizza")
                .price(40.50)
                .category("Jedzenie")
                .date(LocalDateTime.now())
                .person("Justyna")
                .build();
    }
}
