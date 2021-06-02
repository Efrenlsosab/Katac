package com.crud.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public  Iterable<Todo> List(){
        return repository.findAll();
    }
public Todo safe(Todo todo){
        return repository.save(todo);
}
public  void delete(Long id){
        repository.delete(get(id));

}
public Todo get(Long id){
        return repository.findById(id).orElseThrow();
}

}
