package org.expensesplanner.expenses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExpenseEntity {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private String person;
    private LocalDateTime date;
}
