public class Menu {
    // private attribute 1
    // private attribute 2
    private String appTitle;
    private String separator;
    // public getter()

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
        System.out.println("\t1. Add new todo item"); // 2. Aisjflsjdf. 3. Sofoisjfdiosf Choose an option: );
        //System.out.println();
        System.out.println(separator);
    }

//    public void showAddItemMenu() {
//        System.out.println(“--------------\nAdd Item Menu 1. Aksdfjasjf. 2. Aisjflsjdf. 3. Sofoisjfdiosf Choose
//        an option: );
//
//    }
}
