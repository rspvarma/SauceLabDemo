import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List <HashMap<String,String>> getjsonData() throws IOException
	{
	String Jcont=FileUtils.readFileToString(System.clearProperty("user.dir")+"\\src\\test\\resources\\DataReader.java",StandardCharsets.UTF_8);
		// String needs to convert to HashMap - for that we need Jackson Databind
				
    ObjectMapper mapper = new objectMapper();
	List<HashMap<String,String>> data = mapper.readValues(Jcont, new TypeReference<List<HashMap><String,String>>()
	{
		return Data;	
	});
			
				
	}

}
