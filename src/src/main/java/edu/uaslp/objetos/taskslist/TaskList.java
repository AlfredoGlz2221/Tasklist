package edu.uaslp.objetos.taskslist;

import edu.uaslp.objetos.taskslist.exception.TaskNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskList
{
    List<Task> tasks;
    private String taskTitle;


    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public int getSize()
    {
        return tasks.size();
    }

    public void add(Task task)
    {
        this.tasks.add(task);
    }

    public void remove(Task task)
    {
        tasks.remove(task);
    }

    public Task find(String taskTitle) throws TaskNotFoundException
    {
        for(Task task : tasks)
        {
            if(task.getTitle().equals(taskTitle))
            {
                return task;
            }
        }
        throw new TaskNotFoundException(taskTitle);
    }

    public void markAsDone(String taskTitle)
    {
        for(Task task : tasks)
        {
            if(task.getTitle().equals(taskTitle))
            {
                task.setDone(true);
            }
        }
    }

    public void markAsNotDone(String taskTitle)
    {
        for(Task task : tasks )
        {
            if(task.getTitle().equals(taskTitle))
            {
                task.setDone(false);
            }
        }
    }

    public Task getNextTask()
    {
        Task taskFound = this.tasks.get(0);

        for(Task task : tasks)
        {
            //if(//taskFound == null || (taskFound.getDueDate() != null))

            LocalDateTime FechaAux = task.getDueDate();
            if(!taskFound.getDueDate().isBefore(FechaAux))
            {
                taskFound = task;
            }
        }
        return taskFound;
    }

    public List<Task> getNextTasks()
    {
        List<Task> tasksFound = new ArrayList<>();

        for(Task task : tasks)
        {
            if(!task.isDone())
            {
                tasksFound.add(task);
            }
        }
        tasksFound.sort(Comparator.comparing(Task::getDueDate));

        return tasksFound;
    }

}
