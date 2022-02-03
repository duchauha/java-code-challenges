package test;


import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class TestCodeGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className ="MyBean";
		Map<String, String> propsMap = new HashMap<>();
		propsMap.put("age","int");
		propsMap.put("name","String");
		/*
		 * This we will read from mapping xml.
		 */
		
		
		try {
		      String classTemplate = new SampleTemplateGenerator().getSampleJavaCode(className,propsMap);
			  FileWriter myWriter = new FileWriter(className+".java");
		      myWriter.write(classTemplate);
		      
		      myWriter.close();
		     
		      System.out.println("Successfully wrote to the file.");
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}
	
	
}
