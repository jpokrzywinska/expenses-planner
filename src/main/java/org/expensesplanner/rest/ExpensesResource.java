package org.expensesplanner.rest;

import org.expensesplanner.expenses.ExpenseDto;
import org.expensesplanner.expenses.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesResource {

    @Autowired
    ExpensesService expensesService;

    @PostMapping
    public void addExpense(@RequestBody ExpenseDto expenseDto) {
        expensesService.add(expenseDto);
    }

    @GetMapping
    public List<ExpenseDto> getExpenses(){
        return expensesService.getExpenses();
    }
}
