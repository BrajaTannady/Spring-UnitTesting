package com.example.springswagger.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "List")
public class ListTodo {
    @Id
    private String listName;
    private boolean status;

    public ListTodo(String listName) {
        this.listName = listName;
    }

    public ListTodo(String listName, boolean status) {
        this.listName = listName;
        this.status = status;
    }
}
