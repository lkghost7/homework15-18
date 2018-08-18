package lesson18.starter;

import lesson18.Recording;
import lesson18.ReportType;
import lesson18.Speaker;
import lesson18.SwitchReport;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) throws IOException, ParseException {
        File directory = new File("src" + File.separator + "lesson18" + File.separator + "folder");
        File logFile = new File(directory, "log_file.txt");
        File reportOne = new File(directory, "reportOne.txt");
        File reportTwo = new File(directory, "reportTwo.txt");

        List<Recording> contentLogFile = readLogFile(logFile);
        Speaker simpleReporter = SwitchReport.createReporter(ReportType.SIMPLE_REPORT);
        simpleReporter.createReport(reportOne, contentLogFile);
        Speaker difficultReporter = SwitchReport.createReporter(ReportType.DIFFICULT_REPORT);
        difficultReporter.createReport(reportTwo, contentLogFile);
    }

    public static List<Recording> readLogFile(File log) throws IOException {
        List<Recording> result = new ArrayList<>();
        Scanner scanner = new Scanner(log);

        Pattern pattern = Pattern.compile("(\\d{2}:\\d{2}) ([а-яА-Я\\pP\\s]+)");
        Matcher matcher = pattern.matcher("");

        String previousName = null;
        LocalTime previousTime = null;
        String currentName;
        LocalTime currentTime;

        while (scanner.hasNextLine()) {
            matcher.reset(scanner.nextLine());

            while (matcher.find()) {
                currentTime = LocalTime.parse(matcher.group(1));
                currentName = matcher.group(2);

                if (previousName != null && !previousName.equals("Конец")) {
                    result.add(new Recording(previousTime, currentTime, previousName));
                } else if (previousName != null) {
                    result.add(new Recording(null, null, previousName));
                }
                previousTime = currentTime;
                previousName = currentName;
            }
        }
        scanner.close();
        result.add(new Recording(null, null, "Конец"));
        return result;
    }
}