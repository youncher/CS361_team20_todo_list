import java.util.ArrayList;

public class Item {
    private String title;

    //Matt Edits 2.11.20
    private String location;
    private int numPeople;
    private ArrayList<String> peopleList;

    private String dueDate;
    private String priority;

    private boolean completed;

    public Item(String title) {
        this.title = title;
        peopleList = new ArrayList<String>();
    }

    public void addLocation(String str){
        location = str;
    }

    public void setNumPeople(int num){
        numPeople = num;
    }
    public void addPerson(String str){
        peopleList.add(str);
    }
    public ArrayList<String> getPeopleList() { return peopleList; }

    @Override
    public String toString() {
        String todoItem = getTitle() + " " + getLocation() + " " + getPeople() + " " + getDueDate() + " " + getPriority();

        if (this.completed) {
            todoItem = "(Completed) " + todoItem;
        }

        return todoItem;
    }

    public String getLocation(){
        return location;
    }

    public void printItem(){
        System.out.println(title);
    }
    public String getPeople() {
        StringBuffer sb = new StringBuffer();

        //For every string in people list
        for (String s : peopleList) {
            sb.append(s);
            sb.append(" ");
        }

        String str = sb.toString();
        return str;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public void setIncomplete() { this.completed = false; }
}
