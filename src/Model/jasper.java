package Model;

import java.util.HashMap;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TUF_Heat_
 */
public class jasper {

    public void viewReport(String name, HashMap parameters, JTable table) throws Exception {
        this.rootPath += name;
        JRTableModelDataSource dataSource = new JRTableModelDataSource(table.getModel());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
    }

    public void viewReport(String name, HashMap parameters) throws Exception {
        this.rootPath += name;
        JREmptyDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
    }

    public void viewReport(String name) throws Exception {
        this.rootPath += name;
        HashMap parameters = new HashMap();
        JREmptyDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
    }

    private String rootPath = "/Reports/";
}
