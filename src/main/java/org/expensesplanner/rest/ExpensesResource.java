package org.expensesplanner.rest;

import org.expensesplanner.expenses.ExpenseDto;
import org.expensesplanner.expenses.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpensesResource {

    @Autowired
    ExpensesService expensesService;

    @PostMapping
    public void addExpense(@RequestBody ExpenseDto expenseDto) {
        expensesService.add(expenseDto);
    }
}
