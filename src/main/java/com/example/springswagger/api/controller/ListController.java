package com.example.springswagger.api.controller;

import com.example.springswagger.api.model.ListTodo;
import com.example.springswagger.api.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController {
    @Autowired
    ListService service;

    @PostMapping("/insertList")
    public String insertList(@RequestBody ListTodo listTodo){
        return service.addList(listTodo);
    }

    @GetMapping("/findAllList")
    public List<ListTodo> findAllList(){
        return service.allList();
    }
    @GetMapping("/findAllListByStatus/{status}")
    public List<ListTodo> findAllListByStatus(@PathVariable boolean status){
        return service.allListByStatus(status);
    }

    @PutMapping("/updateListName/{listName}")
    public String updateList(@PathVariable String listName, @RequestBody ListTodo updatedList){
        return service.updateList(listName, updatedList);
    }

    @PutMapping("/updateCompleted/{listName}")
    public String updateListStatusToCompleted(@PathVariable String listName){
       return service.updateListStatusToCompleted(listName);
    }

    @PutMapping("/updateActive/{listName}")
    public String updateListStatusToActive(@PathVariable String listName){
        return service.updateListStatusToActive(listName);
    }

    @PutMapping("/updateAllStatus/{status}")
    public String updateAllStatus(@PathVariable boolean status){
        return service.updateAllStatus(status);
    }

    @DeleteMapping("/deleteList/{listName}")
    public String deleteByListName(@PathVariable String  listName){
        return service.deleteByListName(listName);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        return service.deleteAll();
    }
}
