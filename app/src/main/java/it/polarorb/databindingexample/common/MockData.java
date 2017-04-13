package it.polarorb.databindingexample.common;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.polarorb.databindingexample.models.Todo;

public class MockData {
    public static List<Todo> getMockList() {
        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Work Out", new Date(), "Run 9.1 kilometers, followed by light swimming for thirty minutes. Remember to eat a banana and stretch beforehand!"));
        todos.add(new Todo("Work Out", new Date(), "Run 9.1 kilometers, followed by light swimming for thirty minutes. Remember to eat a banana and stretch beforehand!"));
        todos.add(new Todo("Work Out", new Date(), "Run 9.1 kilometers, followed by light swimming for thirty minutes. Remember to eat a banana and stretch beforehand!"));
        todos.add(new Todo("Work Out", new Date(), "Run 9.1 kilometers, followed by light swimming for thirty minutes. Remember to eat a banana and stretch beforehand!"));
        todos.add(new Todo("Work Out", new Date(), "Run 9.1 kilometers, followed by light swimming for thirty minutes. Remember to eat a banana and stretch beforehand!"));
        return todos;
    }
}
