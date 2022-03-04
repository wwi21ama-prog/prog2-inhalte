public class Application {
    public static void main(String[] args) {
        // Ein kleines "Testprogramm"
        User u1 = new User();
        u1.username = "User 1";
        User u2 = new User();
        u2.username = "User 2";

        Project p1 = new Project();
        p1.manager = u1;

        Task t1 = new Task(u1, "Task 1");
        /*t1.description = "Task 1";
        t1.processor = u1;*/
        t1.setStatus(29);
        Task t2 = new Task(u2, "Task 2");
        /*t2.description = "Task 2";
        t2.processor = u2;*/ 
        t2.setStatus(100);
        p1.addTask(t1);
        p1.addTask(t2);

        System.out.println(t1.getStatusAsPerc());
        System.out.println(t2.getStatusAsPerc());
    }
}
