package kr.ac.jejunu.todo.controller;

import kr.ac.jejunu.todo.TodoTitle;
import kr.ac.jejunu.todo.entity.Todo;
import kr.ac.jejunu.todo.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todo", new TodoTitle());
        model.addAttribute("todos", getTodoItems());
        model.addAttribute("todoCount", todoRepository.count());
        return "index";
    }

    private List<TodoItemDto> getTodoItems() {
        return todoRepository.findAll()
                .stream()
                .map(todo -> new TodoItemDto(todo.getId(),
                        todo.getTitle(),
                        todo.isCompleted()))
                .collect(Collectors.toList());
    }

    public static record TodoItemDto(long id, String title, boolean completed) {
    }

    @PostMapping
    public String addNewTodoItem(@ModelAttribute("todo") TodoTitle todoTitle) {
        todoRepository.save(new Todo(todoTitle.getTitle(), false));
        return "redirect:/";
    }
}
