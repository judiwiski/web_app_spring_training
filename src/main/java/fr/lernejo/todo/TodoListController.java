package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoListController {

    private ArrayList<Todo> list = new ArrayList<>();

    @PostMapping//("/api/todo")
    public void add(@RequestBody Todo newElement){
        list.add(newElement);
    }

    @GetMapping//("/api/todo")
    public ArrayList<Todo> getTodoList(){
        return list;
    }
}
