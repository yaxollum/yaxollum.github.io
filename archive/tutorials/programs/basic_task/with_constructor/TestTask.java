public class TestTask {
    public static void printTask(Task t) {
        System.out.println("Name: "+t.name);
        System.out.println("Duration: "+t.duration);
        System.out.println("Priority: "+t.priority);
        System.out.printf("%.1f%% complete\n",t.percentageComplete);
    }
    public static void main(String[] args) {
        Task t=new Task();
        System.out.println("Default task ...");

        printTask(t);

        t.extendDuration(50);
        t.bumpPriority();
        t.updateCompletion(45);

        printTask(t);
    }
}
