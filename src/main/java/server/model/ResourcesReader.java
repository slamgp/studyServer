package server.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourcesReader {
    private String resourcesPath = "src//main//resources//";
    
    public String getContent(String resorces) {
    	String result = "";
		File file = new File(resourcesPath + resorces);
	    if(file.exists()){
	    	 StringBuilder sb = new StringBuilder();
	    	 try {
				BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			    String s;
		        while ((s = in.readLine()) != null) {
		            sb.append(s);
		            sb.append("\r\n");
		        }
		        result = sb.toString();
			 } catch (IOException e) {
			 }
	    } 
	
    	return result;
    }
    
    public List<String> getAllResources() {
    	List<String> result = new ArrayList<String>();
		File file = new File(resourcesPath );
	    if(file.exists()){
            for(File currentFile: file.listFiles()) {
            	result.add(currentFile.getName());
            }
	    } 
	System.out.println(result.toString());
    	return result;
    }
    
}
