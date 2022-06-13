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
        model.addAttribute("todoCount", todoRepository.count());
        return "index";
    }

    @PostMapping
    public String addNewTodoItem(@ModelAttribute("todo") TodoTitle todoTitle) {
        todoRepository.save(new Todo(todoTitle.getTitle(), false));
        return "redirect:/";
    }
}
