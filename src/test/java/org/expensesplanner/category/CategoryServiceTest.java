package org.expensesplanner.category;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class CategoryServiceTest {

    private CategoryService sut;
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        this.categoryRepository = new InMemoryCategoryRepository();
        this.sut = new CategoryService(new CategoryMapper(), new CategoryValidator(), categoryRepository);
    }

    @Test
    public void addCategory() {
        //given
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Jedzenie");

        //when
        sut.add(categoryDto);

        //then
        List<CategoryEntity> categories =  categoryRepository.getCategories();
        assertFalse(categories.isEmpty());
        assertThat(categories.size()).isEqualTo(1);
    }
}
