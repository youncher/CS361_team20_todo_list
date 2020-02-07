import java.util.Scanner;

class Manager {

    //private List<Item> todoList;
    private Menu menu;
    private String prompt;
    private Scanner scanner;

    public Manager() {
        menu = new Menu();
        this.prompt = "Select an option: ";
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            menu.showMainMenu();
            int input = getInput();

            switch (input) {
                case 1:
                    System.out.println("Add todo item");
                    //addNewItem();
                    break;
                case 2:
                    System.out.println("View todo list");
                    break;
                case 3:
                    System.out.println("Delete todo item");
                    break;
                case 4:
                    System.out.println("Edit todo item");
                    break;
                case 5:
                    System.out.println("Export list to file");
                    break;
                case 6:
                    System.out.println("Quit");
                    System.exit(0);
                    break;
            }
            System.out.println();
        }
    }

    private int getInput() {
        System.out.print(prompt);
        int input = scanner.nextInt();
        return input;
    }

    /*public List<Item> getTodoList() {
        return todoList;
    }*/

    /*public void setTodoList(List<Item> todoList) {
        this.todoList = todoList;
    }*/


}