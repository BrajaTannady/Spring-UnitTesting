package com.example.springswagger.api.repository;

import com.example.springswagger.api.model.ListTodo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListRepository extends MongoRepository<ListTodo, String> {
    List<ListTodo> findAllByStatus(boolean status);
}
