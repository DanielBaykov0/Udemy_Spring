package baykov.daniel.controller;

import baykov.daniel.model.ToDoData;
import baykov.daniel.model.ToDoItem;
import baykov.daniel.service.ToDoItemService;
import baykov.daniel.util.AttributeNames;
import baykov.daniel.util.Mappings;
import baykov.daniel.util.ViewNames;
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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {
        log.info("editing id = {}", id);
        ToDoItem toDoItem = toDoItemService.getItem(id);

        if (toDoItem == null) {
            toDoItem = new ToDoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem) {
        log.info("toDoItem from form = {}", toDoItem);

        if (toDoItem.getId() == 0) {
            toDoItemService.addItem(toDoItem);
        } else {
            toDoItemService.updateItem(toDoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with id= {}", id);
        toDoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        log.info("viewing id = {}", id);
        ToDoItem toDoItem = toDoItemService.getItem(id);

        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.VIEW_ITEM;
    }
}
