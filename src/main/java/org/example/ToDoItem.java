package org.example;

public class ToDoItem {
    private String description;
    private boolean isDone;

    public ToDoItem (String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone () {
        return isDone;
    }

    public void markDone () {
        isDone = true;
    }

    public void unmarkDone () {
        isDone = false;
    }

    public String getDescription () {
        return description;
    }
}
