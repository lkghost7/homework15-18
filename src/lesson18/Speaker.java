package lesson18;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Speaker {

    void createReport(File destination, List<Recording> logContent) throws IOException;
}