package evoteam.ir.sutechcamp2;

/**
 * Created by user on 9/4/2017.
 */

public class Task {
    private String name;
    private String day;

    public Task(String name, String day){
        this.name = name;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 3)
            this.name = name;
        else
            this.name = "no name";
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
