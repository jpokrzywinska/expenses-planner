package org.expensesplanner.expenses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDto {
    private Long id;
    private String name;
    private Long categoryId;
    private Double price;
    private String person;
    private LocalDateTime date;
}
