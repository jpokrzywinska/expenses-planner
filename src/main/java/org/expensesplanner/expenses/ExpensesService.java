package org.expensesplanner.expenses;

import org.expensesplanner.category.CategoryRepository;
import org.expensesplanner.category.InMemoryCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    private ExpenseValidator expenseValidator;
    private ExpensesRepository expensesRepository;
    private ExpensesMapper expensesMapper;
    private CategoryRepository categoryRepository;

    public void setExpenseValidator(ExpenseValidator expenseValidator) {
        this.expenseValidator = expenseValidator;
    }

    public void setExpensesRepository(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public void setExpensesMapper(ExpensesMapper expensesMapper) {
        this.expensesMapper = expensesMapper;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ExpensesService(ExpenseValidator expenseValidator, ExpensesRepository expensesRepository, ExpensesMapper expensesMapper) {
        this.expenseValidator = expenseValidator;
        this.expensesRepository = expensesRepository;
        this.expensesMapper = expensesMapper;
        this.categoryRepository = new InMemoryCategoryRepository();
    }

    public void add(ExpenseDto expenseDto) {

        expenseValidator.validate(expenseDto);
        ExpenseEntity expenseEntity = expensesMapper.map(expenseDto);
        expensesRepository.add(expenseEntity);
    }

    public List<ExpenseDto> getExpenses() {
        List<ExpenseEntity> expenseEntities = expensesRepository.getExpenses();
        return expensesMapper.mapList(expenseEntities);
    }

    public void updateExpense(ExpenseDto expenseDto) {
        expenseValidator.validate(expenseDto);
        ExpenseEntity expense = expensesRepository.findById(expenseDto.getId());
        expense.setName(expenseDto.getName());
        expense.setPerson(expenseDto.getPerson());
        expense.setDate(expenseDto.getDate());
        expense.setPrice(expenseDto.getPrice());
        expense.setCategory(categoryRepository.findById(expenseDto.getCategoryId()));
        expensesRepository.update(expense);
    }

    public void deleteExpense(ExpenseDto expenseDto) {
        expensesRepository.delete(expenseDto.getId());
    }
}
