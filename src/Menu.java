public class Menu {
    private String appTitle;
    private String separator;

    public Menu() {
        this.separator = "---------------------------------";
        this.appTitle = "To-Do List";
    }

    public void showMainMenu() {
        System.out.println(separator);
        System.out.println(appTitle);
        System.out.println();
        System.out.println("Main Menu");
        System.out.println();
        System.out.println("\t1. Add new todo item");
        System.out.println("\t2. View todo list");
        System.out.println("\t3. Delete todo item");
        System.out.println("\t4. Edit todo item");
        System.out.println("\t5. Export list to file");
        System.out.println("\t6. Mark todo item as complete/incomplete");
        System.out.println("\t7. (Add fake item to list)");
        System.out.println("\t8. Quit");
        System.out.println(separator);
    }
}
