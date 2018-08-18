package lesson18;

public class SwitchReport {

    public static Speaker createReporter(ReportType type) {
        switch (type) {
            case SIMPLE_REPORT:
                return new CreateSimpleReport();
            case DIFFICULT_REPORT:
                return new CreateHardReport();
        }
        return null;
    }
}