import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Person {
    private String position;
    private int id;
    private String name;
    private float salary;

    public Person(String position, int id, String name, float salary) {
        this.position = position;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setPosition(String value) {
        this.position = value;
    }

    public void setId(int value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setSalary(float value) {
        this.salary = value;
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance(Locale.US));
        String formattedSalary = df.format(getSalary());
        return getPosition() + "," + getId() + "," + getName() + "," + formattedSalary;
    }
}
