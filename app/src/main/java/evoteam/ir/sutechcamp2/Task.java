package evoteam.ir.sutechcamp2;

/**
 * Created by user on 9/5/2017.
 */

public class Task {
    private String name;
    private String day;

    //constructor
    public Task(String name, String day){
        this.name = name;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
