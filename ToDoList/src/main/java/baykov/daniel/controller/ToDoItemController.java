package baykov.daniel.controller;

import baykov.daniel.model.ToDoData;
import baykov.daniel.util.Mappings;
import baykov.daniel.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ToDoItemController {

    // == model attributes ==
    @ModelAttribute
    public ToDoData toDoData() {
        return new ToDoData();
    }

    // == handler methods ==
    // http://localhost:8080/ToDoList/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
