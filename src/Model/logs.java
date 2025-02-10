/*
* RESTRICTED FILE
* DO NOT CHANGE ANYTHING
 */
package Model;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;

public class logs {

    public static Logger logger = Logger.getLogger(logs.class.getName());
    private static FileHandler fileHandler = null;

    private static void generateLogs() throws Exception {

        new File("logs").mkdir();
        fileHandler = new FileHandler("logs/pos_" + LocalDate.now() + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm")) + "_log.log", false);

        Logger log = Logger.getLogger("");
        fileHandler.setFormatter(new SimpleFormatter());
        log.addHandler(fileHandler);
    }

    public static void startLogger() throws Exception {
        generateLogs();
    }
}
