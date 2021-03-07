package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {
    // Fields
    private final TodoItemService todoItemService;

    // Constructors
@Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // Model Attributes
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // http://localhost:8080/ToDoListProject/items
    // Retrieve (in CRUD)
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    // http://localhost:8080/ToDoListProject/addItem
    // Create/Update (in CRUD)
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {

        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);

        // Check if the parameter is there, if not create a new item
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    // http://localhost:8080/ToDoListProject/addItem
    // Create (in CRUD)
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);
        // Check if id is 0
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
            // If id isn't 0, updateItem
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    // http://localhost:8080/ToDoListProject/deleteItem
    // Delete (in CRUD)
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with id= {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    // http://localhost:8080/ToDoListProject/viewItem
    // Retrieve (in CRUD)
    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }

}
