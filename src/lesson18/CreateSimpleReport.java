package lesson18;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;


public class CreateSimpleReport implements Speaker {

    private Writer writer;

    public void createReport(File destination, List<Recording> logContent) throws IOException {
        writer = new BufferedWriter(new FileWriter(destination));
        int countDays = 1;
        writer.write("День " + countDays + ":\n");

        for (Recording entry : logContent.subList(0, logContent.size() - 1)) {
            if (entry.getDescription().equals("Конец")) {
                countDays++;
                writer.write("\nДень: " + countDays + "\n");
            } else {
                writer.write(entry.toString() + "\n");
            }
        }
        writer.flush();
        writer.close();
        System.out.println("Отчет №1 создан");
    }
}