package baykov.daniel.service;

import baykov.daniel.model.ToDoData;
import baykov.daniel.model.ToDoItem;

public interface ToDoItemService {

    void addItem(ToDoItem toAdd);

    void removeItem(int id);

    ToDoItem getItem(int id);

    void updateItem(ToDoItem toUpdate);

    ToDoData getData();
}
