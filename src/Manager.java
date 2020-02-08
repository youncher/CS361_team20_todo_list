import java.util.ArrayList;
import java.util.Scanner;

class Manager {

    //private ArrayList<Item> todoList;
    private Menu menu;
    private String prompt;
    private Scanner scanner;

    public Manager() {
        //ArrayList<Item> todoList = new ArrayList<Item>();       // instantiate todoList here
        menu = new Menu();
        this.prompt = "Select an option: ";
        scanner = new Scanner(System.in);
    }

    public void run(ArrayList<Item> todoList) {
        while (true) {
            menu.showMainMenu();
            int input = getInput();

            switch (input) {
                case 1:
                    String itemTitle;
                    System.out.println("Add todo item");
                    System.out.println("Input Item Title: ");
                    itemTitle = scanner.nextLine();
                    Item item1 = new Item(itemTitle);
                    todoList.add(item1);

                    /*For testing purposes.  Prints the current to do list after a new item is entered.
                    for(int i = 0; i < todoList.size(); i++){
                        todoList.get(i).printItem();
                    }*/
                    //todoList.addItem(item); <-- call the addNewItem() method here
                    break;
                case 2:
                    System.out.println("View todo list");
                    // displayList(); <-- call the displayList() method here
                    break;
                case 3:
                    System.out.println("Delete todo item");
                    // deleteItem(); <-- call the deleteItem() method here
                    break;
                case 4:
                    System.out.println("Edit todo item");
                    // editItem(); <-- call the editItem() method here
                    break;
                case 5:
                    System.out.println("Export list to file");
                    // exportToFile(); <-- call the exportToFile() method here
                    break;
                case 6:
                    System.out.println("Quitting...");
                    System.exit(0);
                    break;
            }
            System.out.println();
        }
    }

    private int getInput() {
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    //Add item function
   /* public void addItem(ArrayList<Item> tList){
        Scanner scanner = new Scanner(System.in);
        int option;

        String title;
        int year;
        float rating;

        option = scanner.nextInt();
        scanner.nextLine();

        if(option == 1){
            System.out.println("Input Title: ");
            title = scanner.nextLine();
            System.out.println("Input Year: ");
            year = scanner.nextInt();
            System.out.println("Input Rating: ");
            rating = scanner.nextFloat();

            Movie mov = new Movie(title, year, rating);

            aList.add(mov);

            for(int i = 0; i < aList.size(); i++){
                aList.get(i).printMovie();
            }
            menu(aList);
        }
        else if (option == 2){
            System.out.println("Goodbye!! ");
        }
    }  */

    /*public List<Item> getTodoList() {
        return todoList;
    }*/

    /*public void setTodoList(List<Item> todoList) {
        this.todoList = todoList;
    }*/


}