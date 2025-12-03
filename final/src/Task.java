import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String taskName;
    private LocalDate taskDue;
    private boolean taskCompleted;

    public Task(String taskName, LocalDate taskDue){
        this.taskName = taskName;
        this.taskDue = taskDue;
        this.taskCompleted = false;
    }

    public String getTaskName(){
        return taskName;
    }

    public LocalDate getTaskDue() {
        return taskDue;
    }

    public boolean taskCompleted() {
        return taskCompleted;
    }

    public String dueString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");
        return taskDue.format(formatter);
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");
        return taskName +", "+ taskDue.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
        return true;
        if (!(o instanceof Task))
        return false;
        Task that = (Task) o;
        return this.taskName == that.taskName && this.taskDue == that.taskDue;
    }

    
}
