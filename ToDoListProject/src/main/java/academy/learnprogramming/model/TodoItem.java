package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

// All the generated methods have been commented out since we can get them with one annotation
// through lombok
@Data
// For these, you can specify which fields you want to use like this
// To include more than one field: (of = {"id", "title", "details"})
// For this one, we only want to use the id for equality checking and hashcode
@EqualsAndHashCode(of = "id")
public class TodoItem {
    // Fields
    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    // Constructor
    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

    // Getters and Setters
//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

//    public String getTitle() {
//        return title;
//    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

//    public String getDetails() {
//        return details;
//    }

//    public void setDetails(String details) {
//        this.details = details;
//    }

//    public LocalDate getDeadline() {
//        return deadline;
//    }

//    public void setDeadline(LocalDate deadline) {
//        this.deadline = deadline;
//    }

    // // Right click -> Generate -> Equals to Method
    // Equals Method
    // If the IDs are the same for multiple items
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ToDoItem)) return false;

//        ToDoItem toDoItem = (ToDoItem) o;

//        return id == toDoItem.id;
//    }

    // Right click -> Generate -> Hashcode
    // Hashcode method
//    @Override
//    public int hashCode() {
//        return id;
//    }

    // Right click -> Generate -> ToString Method
    // toString method
//    @Override
//    public String toString() {
//        return "ToDoItem{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", details='" + details + '\'' +
//                ", deadline=" + deadline +
//                '}';
//    }
}
