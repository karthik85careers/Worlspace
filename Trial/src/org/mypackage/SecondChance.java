package org.mypackage;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SecondChance {
	
	
	public void configure()
	{
		Configuration c=new Configuration();
		
		//Template t=new Template("", c);
		
		//c.getTemplate("").process(dataModel, out);
		
	}
	
	
	public static void main(String args[])
	{
		
		System.out.println(System.getProperty("user.name"));
		
		System.out.println(System.getProperty("user.dir"));
	}

}
