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
                    addTodoItem(todoList);
                    break;
                case 2:
                    displayList(todoList); //<-- call the displayList() method here
                    break;
                case 3:
                    System.out.println("Delete todo item");
                    // deleteItem(); <-- call the deleteItem() method here
                    break;
                case 4:
                    editItem(todoList);
                    break;
                case 5:
                    System.out.println("Export list to file");
                    // exportToFile(); <-- call the exportToFile() method here
                    break;
                case 6:
                    toggleComplete(todoList);
                    break;
                case 7:
                    addFakeItem(todoList);
                    break;
                case 8:
                    System.out.println("Quitting...");
                    System.exit(0);
                    break;
            }
            System.out.println();
        }
    }

    //        For testing purposes
    private void addFakeItem(ArrayList<Item> todoList) {
        Item item1 = new Item("Play Codename Duet" + todoList.size() + 1);
        item1.addLocation("Home");
        item1.setNumPeople(2);
        item1.addPerson("Larry");
        item1.addPerson("David");
        item1.toggleComplete();
        todoList.add(item1);
    }

    private int getInput() {
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    void addTodoItem(ArrayList<Item> todoList) {
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
    }

    void displayList(ArrayList<Item> todoList)
    {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + 1 + ". " + todoList.get(i).toString());
        }
    }

    void toggleComplete(ArrayList<Item> todoList) {
        displayList(todoList);
        System.out.println("Which item do you want to mark as complete/incomplete?");
        int input = getInput();
        todoList.get(input - 1).toggleComplete();

    }

    private void editItem(ArrayList<Item> todoList) {
        System.out.println("\n\n\n");
        displayList(todoList);
        System.out.println("\nWhich item do you want to edit? ");
        int index = getInput();
        Item selectedItem = todoList.get(index-1);
        ArrayList<String> peopleList = selectedItem.getPeopleList();
        int numPeople = peopleList.size();
        System.out.println("\n\n---------------------------------");
        System.out.println("Edit Menu\n");
        System.out.println("1. Title: " + selectedItem.getTitle());
        System.out.println("2. Location: " + selectedItem.getLocation());
        for (int i = 0; i < numPeople; i++) {
            int itemNum = 3 + i;
            System.out.println(itemNum + ". Person" + (i + 1) + ": " + peopleList.get(i));
        }
        System.out.println((3+numPeople) + ". Completed: " + selectedItem.isCompleted());
        System.out.println((4+numPeople) + ". Due Date: " + selectedItem.getDueDate());
        System.out.println((5+numPeople) + ". Priority: " + selectedItem.getPriority());
        System.out.println((6+numPeople) + ". Back to Main Menu\n\n");
        System.out.println("---------------------------------");
        int input = getInput();

        if(input == 1) {
            editTitle(todoList, index);
        } else if (input == 2) {
            editLocation(todoList, index);
        } else {
            if (numPeople == 0) {

                switch (input) {
                    case 3:
                        editCompleted(todoList, index);
                        break;
                    case 4:
                        System.out.println("TODO editDueDate");
                        //editDueDate(todoList, index);
                        break;
                    case 5:
                        System.out.println("TODO editPriority");
                        //editPriority(todoList, index);
                        break;
                    default:
                }
            } else {
                if (input > 2 &&  input <= (2 + numPeople)) {
                    editPerson(input, todoList, index);
                    // do something
                } else if(input == (3 + numPeople)) {
                    editCompleted(todoList, index);
                } else if(input == (4 + numPeople)) {
                    System.out.println("TODO editDueDate");
                    //editDueDate(todoList, index);
                } else if(input == (5 + numPeople)) {
                    System.out.println("TODO editPriority");
                    //editPriority(todoList, index);
                }
            }
        }
    }

    private void editTitle(ArrayList<Item> todoList, int index) {
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        todoList.get(index - 1).setTitle(newTitle);
    }

    private void editLocation(ArrayList<Item> todoList, int index) {
        System.out.print("Enter new location: ");
        String newLocation = scanner.nextLine();
        todoList.get(index - 1).setLocation(newLocation);
    }

    private void editPerson(int personIndex, ArrayList<Item> todoList, int itemIndex) {
        System.out.print("Enter new person: ");
        String newPerson = scanner.nextLine();
        // Item index gets the correct item. Person index gets the correct person in that item's people list
        todoList.get(itemIndex - 1).getPeopleList().set(personIndex - 3, newPerson);

    }

    private void editCompleted(ArrayList<Item> todoList, int index) {
        if(todoList.get(index - 1).isCompleted()) {
            todoList.get(index - 1).setIncomplete();
        } else {
            todoList.get(index - 1).toggleComplete();
        }
    }

    private void editDueDate(ArrayList<Item> todoList, int index) {
        // TODO
    }

    private void editPriority(ArrayList<Item> todoList, int index) {
        // TODO
    }
}