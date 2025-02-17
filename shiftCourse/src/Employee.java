public class Employee extends Person {
    private int managerId;

    public Employee (String position, int id, String name, float salary, int managerId) {
        super(position, id, name, salary);
        this.managerId = managerId;
    }
    public int getManagerId() {
        return this.managerId;
    }

    public void setManagerId(int value) {
        this.managerId = value;
    }

}
