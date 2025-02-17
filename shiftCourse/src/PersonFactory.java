public class PersonFactory {
    public Person create(String type, int id, String name, String salary, String smth) {
        float salaryF = 0.0f;
        if (salary != null && !salary.isEmpty()) {
            try {
                salaryF = Float.parseFloat(salary);
                if (salaryF <= 0) {
                    return null;
                }

            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (type.equals("Manager")) {
            return new Manager(type, id, name, salaryF , smth);
        }
        if (type.equals("Employee")) {
            return new Employee(type, id, name, salaryF, Integer.parseInt(smth));
        }
        return null;
    }
}
