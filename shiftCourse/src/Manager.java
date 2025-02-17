public class Manager extends Person{
    private String department;

    public Manager (String position, int id, String name, float salary, String department) {
        super(position, id, name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String value) {
        this.department = value;
    }

}
