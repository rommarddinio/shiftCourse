import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Sorter {

    public ArrayList<String> sortDepartments (DataContainers containers) {
        HashSet<String> departments = new HashSet<>();
        for (Manager manager: containers.getManagers()) {
            departments.add(manager.getDepartment());
        }
        ArrayList<String> departmentsList = new ArrayList<>(departments);
        Collections.sort(departmentsList);
        return departmentsList;
    }
    public void sortEmployees (DataContainers containers, boolean bySalary, boolean descending) {
        if (!bySalary && !descending) {
            containers.getEmployees().sort(Comparator.comparing(Person::getName));
        }
        if (bySalary && !descending) {
            containers.getEmployees().sort(Comparator.comparing(Person::getSalary));
        }
        if (!bySalary && descending) {
            containers.getEmployees().sort(Comparator.comparing(Person::getName).reversed());
        }
        if (bySalary && descending) {
            containers.getEmployees().sort(Comparator.comparing(Person::getSalary).reversed());
        }
    }
}
