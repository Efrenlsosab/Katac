package com.crud.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001/")
public class TodoController {

    @Autowired
    private TodoService service;
@GetMapping(value = "api/todo")
    public  Iterable<Todo> List(){
        return service.List();
    }
    @PostMapping(value = "api/todo")
    public Todo safe(@RequestBody Todo todo){
        return service.safe(todo);
    }
    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
    if(todo.getId() != null) {
        return service.safe(todo);
    }
    throw new RuntimeException("No existe");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public  void delete(@PathVariable("id") Long id){
        service.delete(id);

    }
    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }


}
