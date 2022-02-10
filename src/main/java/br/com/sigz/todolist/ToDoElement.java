package br.com.sigz.todolist;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ToDoElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    @NotNull
    private LocalDateTime data;
    private ToDoElementStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public LocalDateTime setData(LocalDateTime data) {
        this.data = data;
        return data;
    }

    public ToDoElementStatus getStatus() {
        return status;
    }

    public void setStatus(ToDoElementStatus status) {
        this.status = status;
    }


}
