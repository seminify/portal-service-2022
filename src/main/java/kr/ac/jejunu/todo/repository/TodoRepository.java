package kr.ac.jejunu.todo.repository;

import kr.ac.jejunu.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    int countAllByCompleted(boolean completed);
}
