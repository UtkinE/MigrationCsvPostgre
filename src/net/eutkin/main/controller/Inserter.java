package net.eutkin.main.controller;

import javenue.csv.Csv;
import net.eutkin.main.entity.AbstractDataTS;
import net.eutkin.main.factory.EntityFactory;
import net.eutkin.main.service.IDataServiceTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


import org.hibernate.JDBCException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inserter{

    private static Integer getNumberFromFileName(File currentFile, Boolean itIsTsNumber){
        String str = currentFile.getName();
        str = str.substring(6);
        Integer number = 0;
        if(itIsTsNumber){
            str = str.substring(0,3);
            number = Integer.parseInt(str);
        } else {
            number = Integer.parseInt(str.substring(3,6));
        }
        return number;
    }
    private static Boolean correctNameFile(File file){
        try {
            if(Pattern.matches(getPropFromProperties("PatternNameFile"),file.getName())) {
                return true;
            } else {
                return false;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    private static Set<File> getSetFiles(String str) {
        LinkedHashSet<File> setFile = new LinkedHashSet<File>();
        File oDirFile = new File(str);
        try {
            for (File currentFile : oDirFile.listFiles()) {
                if (currentFile.isFile()) {
                    setFile.add(currentFile);
                } else if (currentFile.isDirectory()) {
                    getSetFiles(currentFile.getAbsolutePath());
                }
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        return setFile;
    }
    private static String getPropFromProperties(String nameProperty) throws IOException{
        String prop = "";
        Properties property = new Properties();
        File oFileConfig = new File("src/resources/property.properties");
        try {
            property.load(new FileReader(oFileConfig));
            prop = property.getProperty(nameProperty);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
    private static AbstractDataTS fillFieldsDataMens(List<String> list,File file) {
        EntityFactory entityFactory = new EntityFactory(getNumberFromFileName(file,true));
        AbstractDataTS dataTS1 = entityFactory.getEntity();
        if(list != null){
            String[] str = list.get(0).split(" ");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                Date oDate = sdf.parse(str[1]);
                dataTS1.setTimeMensuration(oDate);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                Date oDate = sdf.parse(str[0]);
                dataTS1.setDateMensuration(oDate);
            } catch (Exception e){
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(1));
                dataTS1.setVoltage(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(2));
                dataTS1.setThe_current(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(3));
                dataTS1.setPower(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(4));
                dataTS1.setGiven_energy(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                Double oDouble = Double.parseDouble(list.get(5));
                dataTS1.setAccepted_energy(oDouble);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataTS1.setMeter_id(getNumberFromFileName(file, false));
        } else
            return null;
        return dataTS1;
    }
    public static void main (String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDataServiceTest<AbstractDataTS> dataServiceTest = (IDataServiceTest) ctx.getBean("entityService");
        try {
            LinkedHashSet<File> setFile = new LinkedHashSet<File>(getSetFiles(getPropFromProperties("Path")));
            Iterator<File> iterator = setFile.iterator();
            while (iterator.hasNext()) {
                File currentFile = iterator.next();
                if (!correctNameFile(currentFile)){System.out.println("ERROR: Incorrect file name");continue;}
                Csv.Reader oReader = new Csv.Reader(new FileReader(currentFile)).delimiter(';').ignoreComments(true);
                while(true) try {
                    List<String> lineCSV = oReader.readLine();
                    if (lineCSV != null) {
                        dataServiceTest.save(fillFieldsDataMens(lineCSV, currentFile));
                    } else {
                        break;
                    }
                } catch (JDBCException e) {
                    e.getSQLException().getNextException().printStackTrace();
                }
            }
        }
        catch (JDBCException e){
            e.getSQLException().getNextException().printStackTrace();
        }
        catch (IOException e){
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
        ts1 dataMens = new ts1();
        dataMens.setTs_id(1);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            Date oDate = sdf.parse(lineCSV.get(0));
            dataMens.setTimeMensuration(oDate);
        } catch (Exception e){
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(1));
            dataMens.setVoltage(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(2));
            dataMens.setThe_current(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(3));
            dataMens.setPower(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(4));
            dataMens.setGiven_energy(oDouble);
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            Double oDouble = Double.parseDouble(lineCSV.get(5));
            dataMens.setAccepted_energy(oDouble);
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