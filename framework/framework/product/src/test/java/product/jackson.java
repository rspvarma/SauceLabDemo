package product;

import java.io.File;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jackson {  
    // main() method start 
	@Test
    public static void main(String args[]) {  
        // create instance of the ObjectMapper class to map JSON data  
        ObjectMapper mapper = new ObjectMapper();  
        // create instance of the File class   
        File fileObj = new File("C:\\Users\\rspva\\eclipse-workspace\\framework\\framework\\product\\src\\test\\resources\\Inputfile.json");  
        // use try-catch block to convert JSON data into Map  
        try {  
            // read JSON data from file using fileObj and map it using ObjectMapper and TypeReference classes  
            Map<String, String> userData = mapper.readValue(  
                    fileObj, new TypeReference<Map<String, String>>() {  
            });   
            // print all key-value pairs   
            System.out.println("username : " + userData.get("uname"));  
            System.out.println("password : " + userData.get("password"));  
                 } catch (Exception e) {  
            // show error message  
            e.printStackTrace();  
        }   
    }  
}  