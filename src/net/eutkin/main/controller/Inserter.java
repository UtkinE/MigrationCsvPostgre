package net.eutkin.main.controller;

import net.eutkin.main.service.IDataServiceTest;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import net.eutkin.main.threads.NewThread;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Responsibility:
 * Insert new record in database
 * from csv files
 */
public class Inserter{

    /**
     * get config Spring Framework,
     * call method for getting list file,
     *
     * @param args external parametrs, don't used
     */
    public static void main (String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDataServiceTest dataServiceTest = (IDataServiceTest) ctx.getBean("entityService");
        try {
            String path = getPropFromProperties("Path");
            File dirTs = new File(path);
            for(File dirMeters : dirTs.listFiles()) {
                for(File dirCsv : dirMeters.listFiles()) {
                    for(File csvFile :dirCsv.listFiles()) {
                        Thread thread = new Thread(new NewThread(path + "\\" + dirMeters.getName() + "\\" + dirCsv.getName() + "\\" + csvFile.getName(),dataServiceTest));
                        thread.start();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    /**
     * get property from file with properties
     * @param   nameProperty    name of property in properties file
     * @return  property value
     * @throws  IOException
     */
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
}
