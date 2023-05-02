package onpierTestHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigRead {
	
	public static String browserName;
	public static String url;
	public static String objectWaittime;
	public static String filenameToUpload1;
	public static String filenameToUpload2;
	
	Properties runTimeProperties = null;
	
	public ConfigRead() {

		runTimeProperties = new Properties();
		
		// Code to read .properties file and put key value pairs into RunTime Property file
		try
		{
			String parametersPath = System.getProperty("user.dir") + File.separator + "Parameters" + File.separator;
			FileInputStream fileInputStream = new FileInputStream(parametersPath + "config.properties");
			runTimeProperties.load(fileInputStream);
			fileInputStream.close();
		}
		catch (Exception e)
		{
			
			System.out.println("Error in reading the file");
		}
		
		browserName = getRunTimeProperty("Browser");
		url=getRunTimeProperty("url");
		objectWaittime=getRunTimeProperty("objectWaittime");
		filenameToUpload1=getRunTimeProperty("filename1");
		filenameToUpload2=getRunTimeProperty("filename2");
		
		
	}
	
	/**
	 * @author Sanjaya
	 * Get the Run Time Property value
	 * @param key name whose value is needed
	 * @return value of the specified key
	 */
	public String getRunTimeProperty(String key)
	{
		String keyName = key.toLowerCase();
		String value = "";
		try
		{
			value = runTimeProperties.get(keyName).toString();
			}
		catch (Exception e)
		{
						return null;
		}
		return value;
	}
	
	/**
	 * @author Sanjaya
	 * Add the given key value pair in the Run Time Properties
	 * @param key
	 * @param value
	 */
	public void putRunTimeProperty(String key, Object value)
	{
		String keyName = key.toLowerCase();
		runTimeProperties.put(keyName, value);
		
	}


}
