package br.com.sigz.todolist;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @NotNull ToDoElement element) {
//        element.setId(id);
//        repository.save(element);


        return repository.findById(id)
                .map(record -> {
                    record.setNome(element.getNome());
                    record.setDescricao(element.getDescricao());
                    record.setData(element.setData(LocalDateTime.now()));
                    record.setStatus(element.getStatus());
                    ToDoElement updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());


    }

    @GetMapping(value = "{id}")
    public ToDoElement get(@PathVariable Long id) {
        return repository.findById(id).get();



    }


}
