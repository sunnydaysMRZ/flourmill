package com.goku.coreui.sys.util;



import java.io.File;  
import java.io.IOException;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
import org.mybatis.generator.api.MyBatisGenerator;  
import org.mybatis.generator.config.Configuration;  
import org.mybatis.generator.config.xml.ConfigurationParser;  
import org.mybatis.generator.exception.InvalidConfigurationException;  
import org.mybatis.generator.exception.XMLParserException;  
import org.mybatis.generator.internal.DefaultShellCallback; 
public class GenMainUtil {
	public static void main(String[] args) throws Exception {
		   generator();
	}

	private static void generator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File(GenMainUtil.class.getResource("/generatorConfig.xml").getPath());
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
		   
		   System.out.println("代码生成完毕>>>>>>>>>>>>");
	}
  
}
