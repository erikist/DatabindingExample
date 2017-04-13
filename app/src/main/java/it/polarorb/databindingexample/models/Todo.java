package it.polarorb.databindingexample.models;


import java.util.Date;

public class Todo {
    private String title;
    private Date date;
    private String description;

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Todo(String title, Date date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }
}
