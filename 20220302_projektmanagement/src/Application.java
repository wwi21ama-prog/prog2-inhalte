public class Application {
    public static void main(String[] args) {
        // Ein kleines "Testprogramm"
        User u1 = new User();
        User u2 = new User();

        Project p1 = new Project();
        p1.manager = u1;

        Task t1 = new Task();
        t1.description = "Task 1";
        t1.processor = u1;
        t1.setStatus(29);
        Task t2 = new Task();
        t2.description = "Task 2";
        t2.processor = u2;
        t2.setStatus(100);
        p1.addTask(t1);
        p1.addTask(t2);

        System.out.println(t1.getStatusAsPerc());
        System.out.println(t2.getStatusAsPerc());
    }
}
