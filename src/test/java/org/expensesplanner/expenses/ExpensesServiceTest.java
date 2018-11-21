package org.expensesplanner.expenses;

import org.junit.Test;

public class ExpensesServiceTest {

    private ExpensesService sut;

    @Test
    public void addExpense(){
        //given
        ExpenseDto expenseDto = new ExpenseDto();

        //when
        sut.add(expenseDto);
    }

    @Test(expected = InvalidExpenseException.class)
    public void shouldThrowExceptionOnValidationError(){
        //given
        ExpenseDto expenseDto = new ExpenseDto();

        //when
        sut.add(expenseDto);
    }
}
