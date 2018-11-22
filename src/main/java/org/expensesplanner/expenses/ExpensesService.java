package org.expensesplanner.expenses;

import org.springframework.stereotype.Service;

@Service
public class ExpensesService {

    private ExpenseValidator expenseValidator;
    private ExpensesRepository expensesRepository;
    private ExpensesMapper expensesMapper;


    public ExpensesService(ExpenseValidator expenseValidator, ExpensesRepository expensesRepository, ExpensesMapper expensesMapper) {
        this.expenseValidator = expenseValidator;
        this.expensesRepository = expensesRepository;
        this.expensesMapper = expensesMapper;
    }

    public void add(ExpenseDto expenseDto) {

        expenseValidator.validate(expenseDto);
        ExpenseEntity expenseEntity = expensesMapper.map(expenseDto);
        expensesRepository.add(expenseEntity);
    }
}
