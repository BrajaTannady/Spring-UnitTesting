package com.example.springswagger.api;

import com.example.springswagger.api.model.ListTodo;
import com.example.springswagger.api.repository.ListRepository;
import com.example.springswagger.api.service.ListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


//before and after
@SpringBootTest
class SpringSwaggerApplicationTests {

	@Autowired
	private ListService service;

	@MockBean
	private ListRepository repository;

	@Test
	public void addListTest(){
		ListTodo listT = new ListTodo("Learn Z", false);
		when(repository.save(listT)).thenReturn(listT);
		assertEquals(listT.getListName(), service.addList(listT));
	}

	@Test
	public void findAllTest(){
		when(repository.findAll()).thenReturn(Stream.of(new ListTodo("learn A"),
				new ListTodo("Learn B")).collect(Collectors.toList()));
		assertEquals(2, service.allList().size());
	}

	@Test
	public void findAllByStatusTest(){
		when(repository.findAllByStatus(false)).thenReturn(Stream.of(new ListTodo ("Learn A"),
				new ListTodo("Learn B")).collect(Collectors.toList()));
		assertEquals(2, service.allListByStatus(false).size());
		verify(repository, times(1)).findAllByStatus(false);
	}

	@Test
	public void deleteByIdTest(){
		ListTodo listT = new ListTodo("learn X");
		service.deleteById(listT.getListName());
		verify(repository, times(1)).deleteById(listT.getListName());
	}

// verify no more interaction
}
