import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArgumentsProcessor {
    private final Map<String, String> parameters;
    public ArgumentsProcessor(String[] args) {
        parameters = new HashMap<>();
        for (String arg : args) {
            if (arg.startsWith("--") || arg.startsWith("-")) {
                String[] pare = arg.split("=", 2);
                String key = pare[0];
                String value = pare.length > 1 ? pare[1] : null;
                parameters.put(key, value);
            }
        }
    }

    public String checkOutput() {
        Scanner in = new Scanner(System.in);
        if((parameters.containsKey("--output") || parameters.containsKey("-o"))
                && parameters.containsKey("--path")) {
            if (!parameters.get("--output").equals("file") || !parameters.get("--output").equals("console")) {
                System.out.println("Введено неверное значение формата вывода. Данные будут выведены " +
                        "в консоль");
                return "console";
            }
        }
        if ((parameters.containsKey("--output") || parameters.containsKey("-o"))
                && !parameters.containsKey("--path")) {
            System.out.println("Путь не указан! Введите путь файла: ");
            return in.nextLine();
        }
        if ((!parameters.containsKey("--output") && !parameters.containsKey("-o"))
                && parameters.containsKey("--path")) {
            System.out.println("Не выбран способ вывода результата. Введите 1 для вывода в консполь" +
                    "или 2 для вывода в файл: ");
            int choice;
            while (true) {
                try {
                    choice = in.nextInt();
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("Введено неверное значение! Попробуйте ещё раз: ");
                }
            }
            if (choice == 1) return "console";
            else return parameters.get("--path");

        }
        return "console";
    }

    public boolean isSorted() {
        return (parameters.containsKey("--sort") || parameters.containsKey("-s"))
                && (parameters.get("--sort") != null || parameters.get("-s") != null);
    }

    public boolean order() {
        Scanner in = new Scanner(System.in);
        String ord = "";
        if (isSorted()) {
            String sortValue = parameters.get("--order");
            if ("asc".equals(sortValue)) {
                return false;
            } else if ("desc".equals(sortValue)) {
                return true;
            } else {
                while (!ord.equals("asc") && !ord.equals("desc")) {
                    System.out.println("Указан неверный порядок сортировки. " +
                            "Введите его заново" +
                            "(asc - прямой, desc - обратный): ");
                    ord = in.nextLine();
                }
                return !ord.equals("asc");
            }
        }  else {
            System.out.println("Параметр сортировки не введён. Сортировка не будет произведена");
            return false;
        }
    }

    public boolean isSalary() {
        Scanner in = new Scanner(System.in);
        String par = "";
        if (isSorted()) {
            String sortValue = parameters.get("--sort");
            if (sortValue == null) {
                sortValue = parameters.get("-s");
            }
            if ("name".equals(sortValue)) {
                return false;
            } else if ("salary".equals(sortValue)) {
                return true;
            } else {
                while (!par.equals("name") && !par.equals("salary")) {
                    System.out.println("Указан неверный параметр сортировки. " +
                            "Введите его заново" +
                            "(name - имя, salary - зарплата): ");
                    par = in.nextLine();
                }
                return !par.equals("name");
            }
        }
        else {
            return false;
        }
    }
}
