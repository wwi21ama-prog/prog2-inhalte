import java.util.ArrayList;
import java.util.List;

public class Project {
    User manager;
    List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public double getProjectStatus() {
        // TODO: Von allen Tasks in diesem Projekt soll der Projektstatus abgeleitet werden (arithmetisches Mittel)
        return 0.0;
    }
}
