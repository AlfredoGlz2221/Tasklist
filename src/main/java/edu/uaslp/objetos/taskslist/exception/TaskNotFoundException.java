package edu.uaslp.objetos.taskslist.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String taskTitle)
    {
        super("Task with title '" + taskTitle + "' not found");
    }
}
