package com.checkers.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
in this class we will be creating reusable logic
 to read from configuration.properties file
 */
public class ConfigurationReader {

    //create properties object
    //make it private ,so it's not accessible from outside of the class
    //static to make sure its created and loaded before everything else
    private static Properties properties = new Properties();

    static {
        try {
            //2. open file using FIleInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3. load the properties object with the file
            properties.load(file);

            //close file in the memory
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FILE NOT FOUND WITH GIVEN PATH");
        }
    }


    //create a method to use the object to read
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }



}
