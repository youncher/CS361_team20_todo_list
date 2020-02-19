import java.util.ArrayList;
import java.util.Scanner;

class Manager {

    private Menu menu;
    private String prompt;
    private Scanner scanner;

    public Manager(ArrayList<Item> todoList) {
        menu = new Menu();
        this.prompt = "Select an option: ";
        scanner = new Scanner(System.in);
        run(todoList);
    }

    public void run(ArrayList<Item> todoList) {
        while (true) {
            menu.showMainMenu();
            int input = getInput();

            switch (input) {
                case 1:
                    String itemTitle;
                    String itemLocation;
                    int itemNumPeople;

                    System.out.println("Add todo item");
                    System.out.println("Input Item Title (Required): ");
                    itemTitle = scanner.nextLine();

                    Item item1 = new Item(itemTitle);
                    todoList.add(item1);

                    //Edit Matt 2.11.2020
                    System.out.println("Input Item Location: ");
                    itemLocation = scanner.nextLine();
                    item1.addLocation(itemLocation);

                    System.out.println("How Many People would you like to add to this item? ");
                    itemNumPeople = scanner.nextInt();
                    item1.setNumPeople(itemNumPeople);
                    for(int i = 0; i < itemNumPeople; i++){
                        scanner = new Scanner(System.in);
                        System.out.println("Enter Name of Person " + (i + 1) + ":");
                        String person = scanner.nextLine();
                        item1.addPerson(person);
                    }


                    /*For testing purposes.  Prints the current to do list after a new item is entered.
                    for(int i = 0; i < todoList.size(); i++){
                        todoList.get(i).printItem();
                    }*/
                    //todoList.addItem(item); <-- call the addNewItem() method here
                    break;
                case 2:
                    System.out.println("View todo list");
                    // displayList(); <-- call the displayList() method here
                    displayList(todoList); //<-- call the displayList() method here
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
                    System.out.println("Mark as completed");
                    markComplete(todoList);
                    break;
                case 7:
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

    void displayList(ArrayList<Item> todoList)
    {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + 1 + ". " + todoList.get(i).toString());
        }
    }

    void markComplete(ArrayList<Item> todoList) {
        displayList(todoList);
        System.out.println("Which item do you want to mark as complete?");
        int input = getInput();
        todoList.get(input - 1).setCompleted();
    }
}