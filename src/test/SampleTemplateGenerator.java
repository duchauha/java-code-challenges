package test;

import java.util.Map;

public class SampleTemplateGenerator {

	public String getSampleJavaCode(String className,Map<String, String> propsMap) {
		// TODO Auto-generated method stub

		String classTemplate = "package test;\r\n"
				+ "\r\n"
				+ "public class "+ className+ " {\r\n"
				+ "	\r\n";
				
				for (Map.Entry<String, String> entry : propsMap.entrySet()) {
				    classTemplate+="  private " +entry.getValue()+" "+entry.getKey()+";\r\n"+"	\r\n";
				}
				
				for (Map.Entry<String, String> entry : propsMap.entrySet()) {
				    classTemplate+="  public "+entry.getValue()+" get"+capitalize(entry.getKey())+"() {\r\n"
							+ "		return "+entry.getKey()+";\r\n"
							+ "	}\r\n"
							+ "\r\n";
				}
				
				for (Map.Entry<String, String> entry : propsMap.entrySet()) {
				    classTemplate+="  public void "+" set"+capitalize(entry.getKey())+"("+ entry.getKey()+") {\r\n"
							+ "		this."+entry.getKey()+" = "+entry.getKey()+";\r\n"
							+ "	}\r\n"
							+ "\r\n";
				}
				
				classTemplate+="}\r\n"
				+ "";
		
		return classTemplate;

	}
	
	private static String capitalize(String str) {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
