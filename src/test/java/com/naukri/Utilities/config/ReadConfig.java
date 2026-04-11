package com.naukri.Utilities.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config/config.properties");
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e){
            e.printStackTrace();
    }
    }

    public String getUrl()
    {
        return pro.getProperty("url");
    }

    public String getEmail()
    {
        return pro.getProperty("email");
    }

    public String getPassword()
    {
        return pro.getProperty("pass");
    }

    public String getResumeHeadline()
    {
        return pro.getProperty("resumeHeadline");
    }
}
