package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController {

    private ArrayList<Todo> list = new ArrayList<>();

    @PostMapping
    public void add(Todo newElement){
        list.add(newElement);
    }

    @GetMapping
    public ArrayList<Todo> getTodoList(){
        return list;
    }
}
