import java.util.ArrayList;

public class DataLoader {
    private final PersonFactory personFactory;
    public DataLoader() {
        this.personFactory = new PersonFactory();
    }
    public void fillContainers(ArrayList<String[]> list, DataContainers containers) {
        for (String[] line:list) {
            if(line.length == 5) {
                try {
                    Person person = personFactory.create(line[0], Integer.parseInt(line[1]), line[2], line[3], line[4]);
                    if (person instanceof Manager) {
                        containers.addManager((Manager) person);
                    } else if (person instanceof Employee) {
                        containers.addEmployee((Employee) person);
                    }
                    else {
                        containers.addInvalidData(String.join(",", line));
                    }
                }
                catch (NumberFormatException e) {
                    containers.addInvalidData(String.join(",", line));
                }
            }
            else {
                containers.addInvalidData(String.join(",", line));
            }

        }
    }
}
