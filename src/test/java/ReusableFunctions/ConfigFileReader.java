package ReusableFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= "configs//Configuration.properties";
	public String getValue(String key){
		BufferedReader reader;
		String propertyvalue=null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				  propertyvalue = properties.getProperty(key);
				reader.close();
				return propertyvalue;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return propertyvalue;		
	}
	
	
	public String getReportConfigPath(){
			String reportConfigPath = properties.getProperty("reportConfigPath");
			if(reportConfigPath!= null) return reportConfigPath;
			else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
}
	
}
