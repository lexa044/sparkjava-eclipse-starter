package com.lexa.starter.sparkjava.todo;

import java.util.Date;

public class Todo {
	
	private String id;
    private String title;
    private boolean done;
    private Date createdOn = new Date();
    
    public Todo(String id, String title,boolean done, Date createdOn) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }    

    public boolean isDone() {
        return done;
    }
    
    public void setDone(boolean done) {
        this.done = done;
    }    

    public Date getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
