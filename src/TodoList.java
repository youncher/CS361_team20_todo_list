import java.util.ArrayList;

public class TodoList {
    public static void main(String[] args) {
        ArrayList<Item> todoList = new ArrayList<Item>();

        //Manager
        Manager manager = new Manager();
        manager.run(todoList);

    }
}
