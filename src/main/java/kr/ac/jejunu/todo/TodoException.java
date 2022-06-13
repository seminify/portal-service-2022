package kr.ac.jejunu.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoException extends RuntimeException {
    public TodoException(Long id) {
        super(String.format("TodoItem with id %s not found", id));
    }
}
