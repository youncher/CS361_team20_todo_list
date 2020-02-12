public class Item {
    private String title;
    private String dueDate;
    private String priority;

    public Item(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getTitle() + " " + getDueDate() + " " + getPriority();
    }

    public String getTitle(){
        return title;
    }

    public String getDueDate(){
        return dueDate;
    }

    public String getPriority(){
        return priority;
    }
}

