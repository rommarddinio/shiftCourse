import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathOut, pathIn;
        boolean sort, order, isSalary;
        ArgumentsProcessor argumentsProcessor = new ArgumentsProcessor(args);
        Scanner in = new Scanner(System.in);
        Reader reader = new Reader();
        DataLoader loader = new DataLoader();
        DataContainers containers = new DataContainers();
        DataProcessor processor = new DataProcessor();
        Writer writer = new Writer();
        System.out.print("Введите путь к файлу с исходными данными: ");
        pathIn = in.nextLine();
        ArrayList<String[]> list = reader.readFromFile(pathIn);
        if (list == null) return;
        loader.fillContainers(list, containers);
        sort = argumentsProcessor.isSorted();
        order = argumentsProcessor.order();
        isSalary = argumentsProcessor.isSalary();
        pathOut = argumentsProcessor.checkOutput();
        ArrayList<String> finalList = processor.getFinalList(containers, sort, isSalary, order);
        if (pathOut.equals("console")) {
            writer.printConsole(finalList);
        }
        else{
            writer.printFile(finalList, pathOut);
        }
    }
}
