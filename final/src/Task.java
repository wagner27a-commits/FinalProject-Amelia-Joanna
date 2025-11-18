import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String taskName;
    private LocalDate taskDue;

    public Task(String taskName, LocalDate taskDue){
        this.taskName = taskName;
        this.taskDue = taskDue;
    }

    public String getTaskName(){
        return taskName;
    }

    public LocalDate getTaskDue() {
        return taskDue;
    }

    public String dueString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");
        return taskDue.format(formatter);
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");
        return taskName + taskDue.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        // compares to see if same object
        if (o == this)
        return true;
        // compares type
        if (!(o instanceof Task))
        return false;
        Task that = (Task) o;
        // performs actual comparison
        // compare this with that
        return this.taskName == that.taskName && this.taskDue == that.taskDue;
    }

    
}
