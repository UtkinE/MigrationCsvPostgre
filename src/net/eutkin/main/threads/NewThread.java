package net.eutkin.main.threads;

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

public class NewThread implements Runnable {
    private String path;

    private IDataServiceTest dataServiceTest;

    /**
     * Constructor
     * @param path
     * @param dataServiceTest
     */
    public NewThread(String path, IDataServiceTest dataServiceTest){
        this.path = path;
        this.dataServiceTest = dataServiceTest;
    }

    @Override
    /**
     * parse csv file and insert new record in database
     */
    public void run() {

        try {
            File currentFile  = new File(path);
            System.out.println("new Thread run "+ currentFile.getName());
            if (!validateFileName(currentFile)) {
                throw new Exception("ERROR: Incorrect file name");
            }
            Csv.Reader oReader = new Csv.Reader(new FileReader(currentFile)).delimiter(';').ignoreComments(true);
            while (true) try {
                List<String> lineCSV = oReader.readLine();
                if (lineCSV != null) {
                    try {
                        dataServiceTest.save(fillFieldsDataMens(lineCSV, currentFile));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            System.err.println("File not found");
        }

    }
    /**
     * get a row csv file, parse
     * and fill fields entity (table)
     * @param   list  row csv file
     * @param   file  current csv file
     * @return  entity
     */

    private static AbstractDataTS fillFieldsDataMens(List<String> list,File file) throws NumberFormatException{
        EntityFactory entityFactory = new EntityFactory();
        AbstractDataTS dataTS1 = entityFactory.getEntity(getIdFromFileName(file, true));
        if(list != null){
            String[] str = list.get(0).split(" ");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                Date oDate = sdf.parse(str[1]);
                if(oDate == null) return null;
                dataTS1.setTimeMensuration(oDate);
            } catch (Exception e) {
                e.printStackTrace();
            } try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                Date oDate = sdf.parse(str[0]);
                if(oDate == null) return null;
                dataTS1.setDateMensuration(oDate);
            } catch (Exception e){
                throw new NumberFormatException();
            } try {
                Double oDouble = Double.parseDouble(list.get(1));
                dataTS1.setVoltage(oDouble);
            } catch (Exception e) {
                throw new NumberFormatException();
            } try {
                Double oDouble = Double.parseDouble(list.get(2));
                dataTS1.setThe_current(oDouble);
            } catch (Exception e) {
                throw new NumberFormatException();
            } try {
                Double oDouble = Double.parseDouble(list.get(3));
                dataTS1.setPower(oDouble);
            } catch (Exception e) {
                throw new NumberFormatException();
            } try {
                Double oDouble = Double.parseDouble(list.get(4));
                dataTS1.setGiven_energy(oDouble);
            } catch (Exception e) {
                throw new NumberFormatException();
            } try {
                Double oDouble = Double.parseDouble(list.get(5));
                dataTS1.setAccepted_energy(oDouble);
            } catch (Exception e) {
                throw new NumberFormatException();
            }
            dataTS1.setMeter_id(getIdFromFileName(file, false));
        } else
            return null;
        return dataTS1;
    }
    /**
     * validate filename
     * @param   file  current csv file
     * @return  true, if filename is valid
     */
    private Boolean validateFileName(File file){
        try {
            return Pattern.matches(getPropFromProperties("PatternNameFile"), file.getName());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * get id of traction substation
     * or id meter
     * @param   currentFile   current csv file
     * @param   itIsTsNumber  flag, id TS or meter
     * @return  id TS or meter
     */
    private static Integer getIdFromFileName(File currentFile, Boolean itIsTsNumber){
        String str = currentFile.getName();
        str = str.substring(6);
        Integer number;
        if(itIsTsNumber){
            str = str.substring(0,3);
            number = Integer.parseInt(str);
        } else {
            number = Integer.parseInt(str.substring(3,6));
        }
        return number;
    }

    /**
     * get list of csv file
     * @param   path   path on csv file
     * @return  set csv files
     */
    @Deprecated
    private Set<File> getListFiles(String path) throws Exception {
        LinkedHashSet<File> setFile = new LinkedHashSet<File>();
        File oDirFile = new File(path);
        try {
            for (File currentFile : oDirFile.listFiles()) {
                if (currentFile.isFile()) {
                    setFile.add(currentFile);
                } else if (currentFile.isDirectory()) {
                    getListFiles(currentFile.getAbsolutePath());
                }
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return setFile;
    }
    /**
     * get property from file with properties
     * @param   nameProperty    name of property in properties file
     * @return  property value
     * @throws  IOException
     */
    private String getPropFromProperties(String nameProperty) throws IOException{
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
}