package baykov.daniel.controller;

import baykov.daniel.model.ToDoData;
import baykov.daniel.service.ToDoItemService;
import baykov.daniel.util.Mappings;
import baykov.daniel.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ToDoItemController {

    // == fields ==
    private final ToDoItemService toDoItemService;

    // == constructors ==
    @Autowired
    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public ToDoData toDoData() {
        return toDoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/ToDoList/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
