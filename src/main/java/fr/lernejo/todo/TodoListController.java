package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {

    private TodoRepository repository;
    public TodoListController(TodoRepository repository){
        this.repository = repository;
    }

    @PostMapping("/api/todo")
    public void add(@RequestBody Todo newElement){
        TodoEntity entity = new TodoEntity();
        entity.message = newElement.message();
        entity.author = newElement.author();
        repository.save(entity);
    }

    @GetMapping("/api/todo")
    public List<Todo> getTodoList() {
        ArrayList<Todo> todos = new ArrayList<>();
         for (TodoEntity todoEntity : repository.findAll()){
             Todo todo = new Todo(todoEntity.message, todoEntity.author);
             todos.add(todo);
         }
         return  todos;
    }

   /* private ArrayList<Todo> list = new ArrayList<>();

    @PostMapping//("/api/todo")
    public void add(@RequestBody Todo newElement){
        list.add(newElement);
    }

    @GetMapping//("/api/todo")
    public ArrayList<Todo> getTodoList(){
        return list;
    }*/
}
