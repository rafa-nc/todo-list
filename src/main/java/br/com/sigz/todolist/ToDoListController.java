package br.com.sigz.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping(value = "element")
@RestController
public class ToDoListController {
    @Autowired
    private ToDoListRepository repository;

    @GetMapping
    public List<ToDoElement> getList() {
        return repository.findAll();
    }

    @PostMapping
    public void creat(@RequestBody ToDoElement element) {
        element.setData(LocalDateTime.now());
        repository.save(element);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);

    }

    @PutMapping(value = "{id}")

    public void update(@PathVariable Long id, @RequestBody ToDoElement element) {
        element.setId(id);
        repository.save(element);

    }


}
