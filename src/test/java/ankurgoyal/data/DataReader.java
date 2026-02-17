package ankurgoyal.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//this will read/scan the json file and convert into one string variable.
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//ankurgoyal//data//PurchaseOrder.json"),
				StandardCharsets.UTF_8);
		//Convert String to Hashmap using Jackson Data Bind
		
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
		
		
		
	}

}
