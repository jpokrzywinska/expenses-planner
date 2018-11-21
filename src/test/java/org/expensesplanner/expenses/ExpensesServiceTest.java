package org.expensesplanner.expenses;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExpensesServiceTest {

    private ExpensesService sut;
    private ExpensesRepository expensesRepo;


    @Before
    public void setUp(){
        sut = new ExpensesService(new ExpenseValidator());
    }

    @Test
    public void addExpense(){
        //given
        ExpenseDto expenseDto = new ExpenseDto();
        ArgumentCaptor<ExpenseEntity> entityCaptor = ArgumentCaptor.forClass(ExpenseEntity.class);

        //when
        sut.add(expenseDto);

        //then
        verify(expensesRepo).add(entityCaptor.capture());
        ExpenseEntity result = entityCaptor.getValue();
        assertThat(result.getName()).isEqualTo(expenseDto.getName());
        assertThat(result.getPrice()).isEqualTo(expenseDto.getPrice());
        assertThat(result.getDate()).isEqualTo(expenseDto.getDate());
        assertThat(result.getPerson()).isEqualTo(expenseDto.getPerson());
        assertThat(result.getCategory().getName()).isEqualTo(expenseDto.getCategory().getName());

    }

    @Test(expected = InvalidExpenseException.class)
    public void shouldThrowExceptionOnValidationErrorWhenNameIsEmpty(){
        //given
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setName(" ");

        //when
        sut.add(expenseDto);
    }

    @Test(expected = InvalidExpenseException.class)
    public void shouldThrowExceptionOnValidationErrorWhenPriceIsEmpty(){
        //given
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setPrice(null);

        //when
        sut.add(expenseDto);
    }
}
