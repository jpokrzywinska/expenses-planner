package org.expensesplanner.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpensesResource {

    @PostMapping("/add")
    public void addExpense(){
        
    }
}
