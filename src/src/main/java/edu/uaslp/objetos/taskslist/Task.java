package edu.uaslp.objetos.taskslist;

import edu.uaslp.objetos.taskslist.exception.TaskListException;

import java.time.LocalDateTime;

public class Task
{
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;

    public Task() {
    }

    public Task(String title, String description, LocalDateTime dueDate, boolean done)
    {
        this.title = title;
        this.description = description;
        this.done = done;

        setDueDate(dueDate);
    }

    void setDueDate(LocalDateTime dueDate) throws TaskListException
    {
        LocalDateTime today = LocalDateTime.now();

        if(today.isBefore(dueDate)){
            this.dueDate = dueDate;
        }else{
            throw new TaskListException();
        }

    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public LocalDateTime getDueDate()
    {
        return this.dueDate;
    }


    public void setDone(boolean b)
    {
        this.done = b;
    }
//
    public boolean isDone() {
        return this.done;
    }
}

