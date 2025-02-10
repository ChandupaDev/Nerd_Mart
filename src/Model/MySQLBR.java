package Model;

import com.smattme.MysqlExportService;
import com.smattme.MysqlImportService;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author TUF_Heat_
 */
public class MySQLBR {

    public static void backup() throws Exception {
        Properties properties = new Properties();
        properties.setProperty(MysqlExportService.DB_NAME, Model.properties.getDatabase());
        properties.setProperty(MysqlExportService.DB_USERNAME, Model.properties.getUsername());
        properties.setProperty(MysqlExportService.DB_PASSWORD, Model.properties.getPassword());
        properties.setProperty(MysqlExportService.PRESERVE_GENERATED_SQL_FILE, "true");
        properties.setProperty(MysqlExportService.TEMP_DIR, new File("external").getPath());
        MysqlExportService mysqlExportService = new MysqlExportService(properties);

        mysqlExportService.export();
        FileUtils.writeStringToFile(new File("database/" + LocalDate.now() + "-" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm")) + "_SuperMarket.sql"), mysqlExportService.getGeneratedSql(), Charset.forName("UTF-8"));

        mysqlExportService.clearTempFiles();
    }

    public static void restore(String file) throws Exception {

        String sql = new String(Files.readAllBytes(Paths.get("database/" + file + "")));
        MysqlImportService res = MysqlImportService.builder();
        res.setDatabase(properties.getDatabase());
        res.setSqlString(sql);
        res.setUsername(properties.getUsername());
        res.setPassword(properties.getPassword());
        res.setDeleteExisting(true);
        res.setDropExisting(true);
        res.importDatabase();

    }
}
