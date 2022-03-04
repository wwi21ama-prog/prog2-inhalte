public class Task {
    User processor;
    String description;

    private int status = 0;

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
}
