package kr.ac.jejunu.todo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

    public Todo() {

    }

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
