package it.polarorb.databindingexample.common;


import java.util.ArrayList;
import java.util.List;

import it.polarorb.databindingexample.models.Todo;

public class MockData {
    public static List<Todo> getMockList() {
        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(new Todo());
        return todos;
    }
}
