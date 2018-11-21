package org.expensesplanner.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    private String name;
    private Category category;
    private Double price;
    private String person;
    private LocalDateTime date;
}
