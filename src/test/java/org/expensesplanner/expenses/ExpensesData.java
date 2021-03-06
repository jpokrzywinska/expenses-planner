package org.expensesplanner.expenses;

import java.time.LocalDateTime;

public class ExpensesData {

    public static ExpenseDto createDummyExpenseDto() {
        return ExpenseDto.builder()
                .id(1L)
                .name("Pizza")
                .price(40.50)
                .categoryId(1L)
                .date(LocalDateTime.now())
                .person("Justyna")
                .build();
    }
}
