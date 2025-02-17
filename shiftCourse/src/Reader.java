import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public ArrayList<String[]> readFromFile(String path) {
        String pathFile = path;
        Scanner scannerFile = null;
        File file = new File(pathFile);
        while(true)
        {
            try {
                scannerFile = new Scanner(file);
                break;
            }
            catch (FileNotFoundException e){
                System.out.print("Файл не найден! Введите другой путь или 0 для выхода: ");
                Scanner in = new Scanner(System.in);
                pathFile = in.nextLine();
                if (pathFile.equals("0")) {
                    System.out.println("Выход из программы");
                    return null;
                }
                file = new File(pathFile);
            }
        }
        String[] properties;
        ArrayList<String[]> listOfProperties = new ArrayList<>();
        while(scannerFile.hasNextLine()) {
            String line = scannerFile.nextLine();
            properties = line.split(",");
            listOfProperties.add(properties);
        }
        scannerFile.close();
        return listOfProperties;
    }
}
