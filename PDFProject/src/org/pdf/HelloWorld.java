package org.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerFactory;

import org.apache.xalan.processor.TransformerFactoryImpl;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	 
	  private String message;
	 
	  public void init() throws ServletException
	  {
	      // Do required initialization
	      message = "Hellos World";
	  }
	 
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
	      // Set response content type
		  response.setContentType("text/html");
	 
	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");
	      
	      
	      //System.out.println(response.getWriter());
	      
	      StringWriter stringWriter = new StringWriter();
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      //PrintWriter writer = new PrintWriter(stringWriter);  
	      // ...code where you write to writer...  
	      
	     // System.out.println(response.getOutputStream().toString());
	      
	      request.setAttribute("user","fred");
	      
	    // response.sendRedirect("trial.ftl");
	     response.setContentType("application/pdf");
	     response.setContentLength(baos.size());

	      ServletOutputStream out2 = response.getOutputStream();
	      baos.writeTo(out2);
	      out2.flush();
	     
	      try {
	    	  FileTemplateLoader ftl1 = new FileTemplateLoader(new File("C:\\Users\\Vini\\workspace\\PDFProject\\WebContent\\"));
	    	  TemplateLoader[] loaders = new TemplateLoader[] { ftl1 };
	    	 Configuration c= new  Configuration();
	    	 c.setTemplateLoader(ftl1);
	    	 
	    	 Template tpl = c.getTemplate("trial.ftl");
	    	 
	    	// tpl.getConfiguration().get
	    	 TransformerFactoryImpl t=new TransformerFactoryImpl();
	    	 t.newTransformer();
	    	
	          /*Configuration cfg = new Configuration();
	          File f=new File("");
	    	  cfg.setServletContextForTemplateLoading(getServletContext(),"WEB-INF");
	          Template tpl = cfg.getTemplate("trial.ftl");
	          OutputStreamWriter output = new OutputStreamWriter(System.out);

	          Map testHashMap = new HashMap();
	          testHashMap.put("test", "testValue");

	          tpl.process(testHashMap, output);
*/
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      // out.toString();
	  }
	  
	  public void destroy()
	  {
	      // do nothing.
	  }
	}
