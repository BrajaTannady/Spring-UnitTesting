package com.example.springswagger.api.service;

import com.example.springswagger.api.model.ListTodo;
import com.example.springswagger.api.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {
    @Autowired
    ListRepository repository;

    public String addList(ListTodo listTodo){
        repository.save(listTodo);
        return listTodo.getListName();
    }

    public List<ListTodo> allList(){
        return repository.findAll();
    }

    public List<ListTodo> allListByStatus(boolean status){
        return repository.findAllByStatus(status);
    }

    public String updateList(String listName, ListTodo updatedList){
        Optional<ListTodo> optional = repository.findById(listName);

        if (optional.isPresent()){
            ListTodo temp = optional.get();
            temp.setListName(updatedList.getListName());
            repository.save(temp);
            return "Update list to: " + temp.getListName();
        }else{
            return "Can't find list : " + listName;
        }
    }

    public String updateListStatusToCompleted(String listName){
        Optional<ListTodo> optional = repository.findById(listName);

        if (optional.isPresent()){
            ListTodo temp = optional.get();
            temp.setStatus(true);
            repository.save(temp);
            return "Update list to: true";
        }else{
            return "Can't find list : " + listName;
        }
    }

    public String updateListStatusToActive(String listName){
        Optional<ListTodo> optional = repository.findById(listName);

        if (optional.isPresent()){
            ListTodo temp = optional.get();
            temp.setStatus(false);
            repository.save(temp);
            return "Updated list to: false";
        }else{
            return "Can't find list : " + listName;
        }
    }

    public String updateAllStatus(boolean status){
        List<ListTodo> allTodo = repository.findAll();
        for (ListTodo temp : allTodo) {
            temp.setStatus(status);
            repository.save(temp);
        }
        return "Update All Status to : " + status;
    }

    public void deleteById(String listName){
        repository.deleteById(listName);
    }

    public String deleteByListName(String  listName){
        Optional<ListTodo> optional = repository.findById(listName);
        if (optional.isPresent()){
            repository.deleteById(listName);
            return "Delete List : " + listName;
        }else{
            return "Can't find list : " + listName;
        }
    }

    public String deleteAll(){
        repository.deleteAll();
        return "Deleted all List";
    }
}
