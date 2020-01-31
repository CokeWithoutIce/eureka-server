package com.kelebujiabing.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

public class GeneratorUtils {

    
    //SCENERECORD

    public static void main(String[] args) {
        shell();
    }

    private static void shell() {
        ArrayList<String> warnings = new ArrayList<>();
        try {
            //String configFilePath = System.getProperty("user.dir").concat("conf/generatorConfig.xml");
          //  System.out.println("加载配置文件===" + configFilePath);
            boolean overwite = true;
            File configfile = new File("G:\\heyueCloud\\user-server\\src\\main\\resources\\generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configfile);
            DefaultShellCallback callback = new DefaultShellCallback(overwite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            VerboseProgressCallback progressCallback = new VerboseProgressCallback();
            myBatisGenerator.generate(progressCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }


}
