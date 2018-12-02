package org.expensesplanner.expenses;

import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ExpenseDto> getExpenses() {
        List<ExpenseEntity> expenseEntities = expensesRepository.getExpenses();
        List<ExpenseDto> expenseDtos = expensesMapper.mapList(expenseEntities);
        return  expenseDtos;
    }
}
