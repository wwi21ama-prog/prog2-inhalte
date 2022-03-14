import java.util.ArrayList;
import java.util.List;

public class Project {
    User manager;
    List<Task> tasks = new ArrayList<>();
    UserGroup userGroup;

    private User currentUser;

    public boolean reserveProject(User user) {
        if (this.currentUser == null) {
            if(!this.checkAccess(user)) { return false; }
            this.currentUser = user;
            System.out.println("Das Projekt ist für " + user.username + " reserviert.");
            return true;
        } else {
            System.err.println("Das Projekt ist aktuell von einem Benutzer reserviert.");
            return false;
        }
    }

    public void freeProject() {
        this.currentUser = null;
    }

    public void addTask(Task task) {
        if (!this.checkAccess(this.currentUser)) {
            return;
        }
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        if (!this.checkAccess(this.currentUser)) {
            return;
        }
        this.tasks.remove(task);
    }

    public double getProjectStatus() {
        if (!this.checkAccess(this.currentUser)) {
            return 0.0;
        }
        // Von allen Tasks in diesem Projekt soll der Projektstatus abgeleitet werden (arithmetisches Mittel)

        // Summe von Task-Fortschritten
        double summe = 0.0;
        for (int i = 0; i < this.tasks.size(); i++) {
            Task currentTask = this.tasks.get(i);
            summe += currentTask.getStatus();
        } // Summe ist > 0.0, falls es mehr als einen Task mit Status > 0 % gibt

        // Teilen durch Anzahl
        return summe / this.tasks.size();
    }

    private boolean checkAccess(User user) {
        if (userGroup != null && userGroup.users.contains(user)) {
            return true;
        } else {
            System.err.println("Der aktuelle Benutzer hat keinen Zugriff auf das Projekt.");
            return false;
        }
    }
}
