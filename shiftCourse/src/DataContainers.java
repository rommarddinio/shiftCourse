import java.util.ArrayList;

public class DataContainers {
    private final ArrayList<Manager> managers;
    private final ArrayList<Employee> employees;
    private final ArrayList<String> invalidData;
    private final ArrayList<Person> temp;

    public DataContainers() {
        this.managers = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.invalidData = new ArrayList<>();
        this.temp = new ArrayList<>();
    }

    public void addManager(Manager manager) {
        this.managers.add(manager);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addInvalidData(String data) {
        this.invalidData.add(data);
    }

    public void addTemp(Person employee) {
        this.temp.add(employee);
    }

    public void clearTemp() {
        this.temp.clear();
    }

    public ArrayList<Manager> getManagers() {
        return this.managers;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public ArrayList<String> getInvalidData() {
        return this.invalidData;
    }

    public ArrayList<Person> getTemp() {
        return this.temp;
    }
}
