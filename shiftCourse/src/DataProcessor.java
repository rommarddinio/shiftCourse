import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
public class DataProcessor {
    private final Sorter sorter;
    private final Finder finder;

    public DataProcessor() {
        this.sorter = new Sorter();
        this.finder = new Finder();
    }

    public ArrayList<String> getFinalList(DataContainers containers, boolean isSorted, boolean isBySalary, boolean isDescending) {
        ArrayList<String> departments = sorter.sortDepartments(containers);
        ArrayList<String> finalList = new ArrayList<>();
        if (isSorted) {
            sorter.sortEmployees(containers, isBySalary, isDescending);
        }
        for (String department: departments)
        {
            finalList.add(department);
            for (int i =0; i<containers.getManagers().size(); i++) {
                finder.findWorkers(containers, department, i);
                int amount = containers.getTemp().size();
                if (amount==0) continue;
                float averageSalary = 0;
                for (Person worker : containers.getTemp()) {
                    finalList.add(worker.toString());
                    averageSalary += worker.getSalary();
                }
                averageSalary /= amount;
                DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance(Locale.US));
                String formattedSalary = df.format(averageSalary);
                finalList.add(amount + "," + formattedSalary);
                containers.clearTemp();
            }
        }
        finalList.add("Некорректные данные: ");
        for (Employee employee: containers.getEmployees()) {
            if (employee.getManagerId() > containers.getManagers().size()) {
                finalList.add(String.join(",", employee.toString()) + "," + employee.getManagerId());
            }
        }
        finalList.addAll(containers.getInvalidData());
        return finalList;
    }
}
