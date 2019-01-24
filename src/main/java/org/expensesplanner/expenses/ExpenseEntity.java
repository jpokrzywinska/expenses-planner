package org.expensesplanner.expenses;

import lombok.Data;
import org.expensesplanner.category.CategoryEntity;

import java.time.LocalDateTime;

@Data
public class ExpenseEntity {

    private Long id;
    private String name;
    private CategoryEntity category;
    private Double price;
    private String person;
    private LocalDateTime date;
}
