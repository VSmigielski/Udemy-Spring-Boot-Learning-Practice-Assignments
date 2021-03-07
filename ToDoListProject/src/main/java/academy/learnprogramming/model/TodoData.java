package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// Used to simulate an in memory database
public class TodoData {
    // Fields
    private static int idValue = 1;
    // To make this class immutable, no reassignment
    private final List<TodoItem> items = new ArrayList<>();

    // Constructor
    public TodoData() {
        // Dummy data using the addItem method to set the id fields
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth details", LocalDate.now()));
    }

    // Public methods
    public List<TodoItem> getItems() {
        // No modification from other classes, will throw exception elsewhere
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        // Normally to validate data, a programmer would add this:
        // if (toAdd == null) {
        //    throw new NullPointerexception("toAdd is a required parameter.");
        // }

        // Validate null parameter through Lombok in the parameter
        // Set an Id
        toAdd.setId(idValue);
        // Add item
        items.add(toAdd);
        // Increment value
        idValue++;
    }

    public void removeItem(int id) {
        // Creates iterator
        ListIterator<TodoItem> itemIterator = items.listIterator();

        // Checks through the list
        while (itemIterator.hasNext()) {
            // Gets the next item
            TodoItem item = itemIterator.next();
            // If the item id matches the id given
            if (item.getId() == id) {
                // Remove the item from the list
                itemIterator.remove();
                // Break out of the code block
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        // Loops through our list
        for (TodoItem item : items) {
            // Checks for the id of the item
            if (item.getId() == id) {
                // If found, return the item info
                return item;
            }
        }
        // Else
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        // List iterator creation
        ListIterator<TodoItem> itemIterator = items.listIterator();

        // While the iterator has next
        while (itemIterator.hasNext()) {
            // shuffle to the next item to find it
            TodoItem item = itemIterator.next();

            // Check if the item is equal through id
            if (item.equals(toUpdate)) {
                // If equal, set toUpdate
                itemIterator.set(toUpdate);
                // Break out of the code block
                break;
            }
        }
    }

}
