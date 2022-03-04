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
        // Von allen Tasks in diesem Projekt soll der Projektstatus abgeleitet werden (arithmetisches Mittel)

        // Summe von Task-Fortschritten
        double summe = 0.0;
        for(int i = 0; i < this.tasks.size(); i++) {
            Task currentTask = this.tasks.get(i);
            summe += currentTask.getStatus();
        } // Summe ist > 0.0, falls es mehr als einen Task mit Status > 0 % gibt
        
        // Teilen durch Anzahl
        return summe / this.tasks.size();
    }
}
