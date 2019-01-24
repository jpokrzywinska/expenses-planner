package org.expensesplanner.category;

import lombok.Data;

@Data
public class CategoryEntity {
    private Long id;
    private String name;
    private Long position;
}
