package org.belon.booktracker.books.api.v1.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtAuthorDto;
import org.belon.booktracker.books.services.impl.BtAuthorServiceImpl;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BtAuthorController.class)
class BtAuthorControllerTest {

	private static final String APIPPATH = "/v1/author/";

	@MockBean
	private BtAuthorServiceImpl authorService;
    
	@Autowired
	private MockMvc mockMvc;
    
	private String authorNotFoundMessage="Author with this id does not exists";
	private String authorAlreadyExistsMessage="This name and surname combination already exists.";
    private List<BtAuthorDto> mockEntities = new ArrayList<BtAuthorDto>();
    private String jsonNew= "{\r\n"
    		+ "    \"name\": \"Giorgio\",\r\n"
    		+ "    \"surname\": \"Faletti\"\r\n"
    		+ "}";
    private String jsonAlreadyInserted= "{\r\n"
    		+ "    \"name\": \"Margaret\",\r\n"
    		+ "    \"surname\": \"Weis\"\r\n"
    		+ "}";
    private String jsonAuthorWithouName= "{\r\n"
    		+ "    \"surname\": \"Weis\"\r\n"
    		+ "}";
    
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
        .andExpect(jsonPath("$.data[1].surname", Matchers.is("Greenwood")));
//		.andDo(print()); print response to console
		
	}

	@Test
	void testGetAuthorListNotEmpty(){
		Mockito.when(authorService.getBtAuthorsList()).thenReturn(mockEntities);
		assertThat(authorService.getBtAuthorsList())
		.isNotEmpty();
	}
	@Test
	void testGetAuthorListEmpty(){
		Mockito.when(authorService.getBtAuthorsList()).thenReturn(new ArrayList<BtAuthorDto>());
		assertThat(authorService.getBtAuthorsList())
		.isEmpty();
	}
	@Test
	void testGetAuthor() throws Exception {
		Mockito.when(authorService.getBtAuthor(Long.valueOf(1))).thenReturn(mockEntities.get(0));
		String id="1";
		mockMvc.perform(get(APIPPATH+id))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.data", Matchers.notNullValue()))
        .andExpect(jsonPath("$.message").value("Author retrieved succesfully"))
        .andExpect(jsonPath("$.status").value("200"))
        .andExpect(jsonPath("$.data.name", Matchers.is("R.A.")))
        .andExpect(jsonPath("$.data.surname", Matchers.is("Salvatore")))
        .andExpect(jsonPath("$.data.id", Matchers.is(1)));
	}
	@Test
	void testGetAuthorWithNoId() throws Exception {
		Mockito.when(authorService.getBtAuthor(Long.valueOf(1))).thenThrow(new ResourceNotFoundException(authorNotFoundMessage));
		String id="1";
		mockMvc.perform(get(APIPPATH+id))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.message").value("Author with this id does not exists"))
        .andExpect(jsonPath("$.status").value("404"));
	}

	@Test
	void testCreateAuthor() throws Exception {
		BtAuthorDto newAuthor= new BtAuthorDto();
        newAuthor.setName("Giorgio");
        newAuthor.setSurname("Faletti");
        BtAuthorDto createdAuthor= new BtAuthorDto();
        createdAuthor.setName("Giorgio");
        createdAuthor.setSurname("Faletti");
        createdAuthor.setId(Long.valueOf(1));
		Mockito.when(authorService.createBtAuthor(newAuthor)).thenReturn(createdAuthor);
		mockMvc.perform(MockMvcRequestBuilders.post(APIPPATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonNew)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.status").value("201"))
				.andExpect(jsonPath("$.message").value("Author created succesfully"))
				.andExpect(jsonPath("$.data.id").value(1))
				.andExpect(jsonPath("$.data.name").value("Giorgio"))
				.andExpect(jsonPath("$.data.surname").value("Faletti"));
//				.andDo(print());
	}

	@Test
	void testCreateAuthorAlreadyInDb() throws Exception {
		BtAuthorDto newAuthor= new BtAuthorDto();
        newAuthor.setName("Margaret");
        newAuthor.setSurname("Weis");
        
		Mockito.when(authorService.createBtAuthor(newAuthor)).thenThrow(new PersistenceViolationException(
				authorAlreadyExistsMessage, mockEntities.get(2)));
		mockMvc.perform(MockMvcRequestBuilders.post(APIPPATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonAlreadyInserted)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isConflict())
				.andExpect(jsonPath("$.status").value("409"))
				.andExpect(jsonPath("$.message").value(authorAlreadyExistsMessage))
				.andExpect(jsonPath("$.data.id").value(3))
				.andExpect(jsonPath("$.data.name").value("Margaret"))
				.andExpect(jsonPath("$.data.surname").value("Weis"));
//				.andDo(print());
		
	}
	@Test
	void testCreateAuthorWithoutName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(APIPPATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonAuthorWithouName)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnprocessableEntity())
				.andExpect(jsonPath("$.status").value("422"))
				.andExpect(jsonPath("$.message").value("Validation error."))
				.andExpect(jsonPath("$.error.name").value("Name can't be empty"));
//				.andDo(print());
	}
//	@Test
//	void testUpdateAuthor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteAuthor() {
//		fail("Not yet implemented");
//	}

}
