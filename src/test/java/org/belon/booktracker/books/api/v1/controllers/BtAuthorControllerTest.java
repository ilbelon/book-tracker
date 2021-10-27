package org.belon.booktracker.books.api.v1.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtAuthorDto;
import org.belon.booktracker.books.services.impl.BtAuthorServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BtAuthorController.class)
class BtAuthorControllerTest {

	@MockBean
	private BtAuthorServiceImpl authorService;
    
	@Autowired
	private MockMvc mockMvc;
    
    private List<BtAuthorDto> mockEntities = new ArrayList<BtAuthorDto>();
    
    @BeforeEach
    public void setUp(){
        BtAuthorDto author1= new BtAuthorDto();
        author1.setId(Long.valueOf(1));
        author1.setName("R.A.");
        author1.setSurname("Salvatore");
        BtAuthorDto author2= new BtAuthorDto();
        author2.setId(Long.valueOf(2));
        author2.setName("E.D");
        author2.setSurname("Greenwood");
        BtAuthorDto author3= new BtAuthorDto();
        author3.setId(Long.valueOf(3));
        author3.setName("Margaret");
        author3.setSurname("Weis");
        mockEntities.add(author1);
        mockEntities.add(author2);
        mockEntities.add(author3);
    }
	@Test
	void testGetAuthorsList() throws Exception {
		Mockito.when(authorService.getBtAuthorsList()).thenReturn(mockEntities);
		mockMvc.perform(get("/v1/author"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.data", Matchers.hasSize(3)))
        .andExpect(jsonPath("$.message").value("Authors retrieved succesfully"))
        .andExpect(jsonPath("$.status").value("200"))
        .andExpect(jsonPath("$.data[0].name", Matchers.is("R.A.")))
        .andExpect(jsonPath("$.data[1].surname", Matchers.is("Greenwood")))
		.andDo(print());
		
	}

	@Test
	void testGetAuthorListNotEmpty(){
		Mockito.when(authorService.getBtAuthorsList()).thenReturn(mockEntities);
		assertThat(authorService.getBtAuthorsList())
		.isNotEmpty();
	}
	@Test
	void testGetAuthor() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateAuthor() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAuthor() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAuthor() {
		fail("Not yet implemented");
	}

}
