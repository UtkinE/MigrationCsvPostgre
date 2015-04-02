package net.eutkin.main.controller;

import javenue.csv.Csv;
import net.eutkin.main.entity.DataMens;
import net.eutkin.main.service.IDataServiceTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inserter{

    private static Set<File> getSetFiles(String str) {
        LinkedHashSet<File> setFile = new LinkedHashSet<File>();
        File oDirFile = new File(str);
        for (File currentFile : oDirFile.listFiles()) {
            if (currentFile.isFile()) {
                setFile.add(currentFile);
            } else if (currentFile.isDirectory()) {
                getSetFiles(currentFile.getAbsolutePath());
            }
        }
        return setFile;
    }
    private static String returnPathFromProperties() throws IOException{
        String path = "";
        Properties property = new Properties();
        File oFileConfig = new File("src/resources/property.properties");
        try {
            property.load(new FileReader(oFileConfig));
            path = property.getProperty("Path");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
    private static DataMens fillFieldsDataMens(List<String> list) throws Exception {
        DataMens dataMens = new DataMens();
        if(list != null){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                Date oDate = sdf.parse(list.get(0));
                dataMens.setTimeMensuration(oDate);
            } catch (Exception e){
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(1));
                dataMens.setColumn1(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(2));
                dataMens.setColumn2(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(3));
                dataMens.setColumn3(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(4));
                dataMens.setColumn4(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(5));
                dataMens.setColumn5(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            return null;
        return dataMens;
    }
    public static void main (String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDataServiceTest dataServiceTest = (IDataServiceTest) ctx.getBean("entityService");
        try {
            LinkedHashSet<File> setFile = new LinkedHashSet<File>(getSetFiles(returnPathFromProperties()));
            Iterator<File> iterator = setFile.iterator();
            while (iterator.hasNext()) {
                Csv.Reader oReader = new Csv.Reader(new FileReader(iterator.next())).delimiter(';').ignoreComments(true);
                while(true) {
                    try {
                        List<String> lineCSV = oReader.readLine();
                        if(lineCSV != null) {
                            dataServiceTest.save(fillFieldsDataMens(lineCSV));
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



        System.out.println("end");
    }


}

/*
@Controller
public class Inserter {

    //@Autowired
    //private IDataMensService dataMensService;

    public void parseLine(List<String> line) throws Exception {
        IDataMensService dataMensService = new DataMensServiceImpl();
        List<String> lineCSV = new LinkedList<String>(line);
        DataMens dataMens = new DataMens();
        dataMens.setId(1);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            Date oDate = sdf.parse(lineCSV.get(0));
            dataMens.setTimeMensuration(oDate);
        } catch (Exception e){
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(1));
            dataMens.setColumn1(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(2));
            dataMens.setColumn2(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(3));
            dataMens.setColumn3(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(4));
            dataMens.setColumn4(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(5));
            dataMens.setColumn5(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            dataMensService.insertNewLine(dataMens);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) throws Exception {
        String path = "E:\\1.csv";
        Inserter inserter = new Inserter();
        File oFile = new File(path);
        try {
            Csv.Reader oReader = new Csv.Reader(new FileReader(oFile))
                    .delimiter(';').ignoreComments(true);

            //while (true) {
            List<String> oListLine = oReader.readLine();
            if (oListLine != null) {
                System.out.println(oListLine);
                inserter.parseLine(oListLine);
            }
            else {
                //break;
            }
            //}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/