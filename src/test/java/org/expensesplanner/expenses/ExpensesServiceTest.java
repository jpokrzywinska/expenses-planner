package org.expensesplanner.expenses;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class ExpensesServiceTest {

    private ExpensesService sut;
    private ExpensesRepository expensesRepository;

    @Before
    public void setUp() {
        expensesRepository = new InMemoryExpensesRepository();

        sut = new ExpensesService(new ExpenseValidator(), expensesRepository, new ExpensesMapper());
    }

    @Test
    public void addExpense() {
        //given
        ExpenseDto expenseDto = ExpensesData.createDummyExpenseDto();

        //when
        sut.add(expenseDto);

        //then
        List<ExpenseEntity> results = expensesRepository.getExpenses();
        assertFalse(results.isEmpty());
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).getName()).isEqualTo(expenseDto.getName());
        assertThat(results.get(0).getPrice()).isEqualTo(expenseDto.getPrice());
        assertThat(results.get(0).getDate()).isEqualTo(expenseDto.getDate());
        assertThat(results.get(0).getPerson()).isEqualTo(expenseDto.getPerson());
        assertThat(results.get(0).getCategory()).isEqualTo(expenseDto.getCategory());
    }

    @Test(expected = InvalidExpenseException.class)
    public void shouldThrowExceptionOnValidationErrorWhenNameIsEmpty() {
        //given
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setName(" ");

        //when
        sut.add(expenseDto);
    }

    @Test(expected = InvalidExpenseException.class)
    public void shouldThrowExceptionOnValidationErrorWhenPriceIsEmpty() {
        //given
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setPrice(null);

        //when
        sut.add(expenseDto);
    }

    @Test
    public void getAllExpenses() {
        //given

        //when
        List<ExpenseDto> result = sut.getExpenses();

        //then
        assertThat(result).hasSize(1);
        assertThat(result.size()).isEqualTo(1);

    }

    @Test
    public void updateExpense() {
        //given
        ExpenseDto expenseDto = new ExpenseDto();

        //when
        sut.updateExpense(expenseDto);

        //then
    }
}
