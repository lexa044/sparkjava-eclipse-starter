package com.lexa.starter.sparkjava.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lexa.starter.sparkjava.utils.JsonConverter;

public class TodoService {

	private List<Todo> collection = new ArrayList<>();
	
	public TodoService(){
		Date now = new Date();
		collection.add(new Todo("1", "Click Tutorial Link", true, now));
		collection.add(new Todo("2", "Read Tutorial Intro", true, now));
		collection.add(new Todo("3", "Look at Tutorial Screenshot", true, now));
	}
	
	public List<Todo> findAll() {
        return collection;
    }

    public void createNewTodo(String body) {
        Todo todo = JsonConverter.convertFromJson(body, Todo.class);
        collection.add(todo);
    }

    public Todo find(String id) {
    	Todo response = null;
    	
    	for(Todo todo : collection) {
            if(todo.getId().equals(id)){
            	response = todo;
            	break;
            }
        }
    	
        return response;
    }

    public Todo update(String todoId, String body) {
    	Todo todo = JsonConverter.convertFromJson(body, Todo.class);
    	Todo todoToUpdate = this.find(todoId);
        if(null != todoToUpdate){
        	todoToUpdate.setCreatedOn(todo.getCreatedOn());
        	todoToUpdate.setDone(todo.isDone());
        	todoToUpdate.setTitle(todo.getTitle());
        }
        return todoToUpdate;
    }
}
