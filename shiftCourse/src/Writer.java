import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Writer {
    public void printConsole(ArrayList<String> finalList) {
        for (String line:finalList) {
            System.out.println(line);
        }
    }
    public void printFile (ArrayList<String> finalList, String path) {
        String pathFile = path;
        File file = new File(path);
        PrintWriter pw = null;
        while(true)
        {
            try {
                pw = new PrintWriter(file);
                break;
            }
            catch (FileNotFoundException e){
                System.out.print("Файл не найден! Введите другой путь или 0 для выхода: ");
                Scanner in = new Scanner(System.in);
                pathFile = in.nextLine();
                if (pathFile.equals("0")) {
                    return;
                }
                file = new File(pathFile);
            }
        }
        for (String line: finalList) {
            pw.println(line);
        }
        pw.close();
    }
}
