package org.expensesplanner.expenses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExpenseDto {
    private String name;
    private String thing;
    private Category category;
    private Integer price;
    private String person;
    private LocalDateTime date;
}
