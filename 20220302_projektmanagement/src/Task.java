public class Task {
    // Eigenschaften/Attribute
    User processor;
    String description;

    private int status = 0;

    public Task(User processor, String description) {
        System.out.println("Ein neues Task-Objekt wurde erstellt.");
        if(processor == null) {
            System.err.println("Der Verantwortliche für den Task kann nicht null sein");
        }
        this.processor = processor;
        this.description = description;
    }

    // Methoden
    public String getStatusAsPerc() {
        return status + "%";
    }

    public void setStatus(int status) {
        if (status < 0 || status > 100) {
            System.err.println("Der Status " + status + " ist kein valider Prozentsatz (0% - 100%)");
        } else {
            this.status = status;
        }
    }

    public User getProcessor() {
        return processor;
    }

    public void setProcessor(User processor) {
        this.processor = processor;
    }
}
