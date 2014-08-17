package net.viralpatel;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
public class UserController {
	/**
	 * Static list of users to simulate Database
	 */
	@Autowired
	private FreeMarkerViewResolver viewResolver;
	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;
	
	private static List<User> userList = new ArrayList<User>();

	//Initialize the list with some data for index screen
	static {
		userList.add(new User("Bill", "Gates"));
		userList.add(new User("Steve", "Jobs"));
		userList.add(new User("Larry", "Page"));
		userList.add(new User("Sergey", "Brin"));
		userList.add(new User("Larry", "Ellison"));
	}

	/**
	 * Saves the static list of users in model and renders it 
	 * via freemarker template.
	 * 
	 * @param model 
	 * @return The index view (FTL)
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model,Model m2) {

		model.addAttribute("userList", userList);
		String trial="sucks";
		m2.addAttribute("name",trial);
		m2.addAttribute("userList", userList);
		 Configuration c= new  Configuration();
		 try {
				Template t=freemarkerConfig.getConfiguration().getTemplate("index.ftl");
				 Writer consoleWriter = new OutputStreamWriter(System.out);
		         HashMap rootMap=new  HashMap();	
		         //rootMap.p
		         rootMap.putAll(m2.asMap());
				
				t.process(rootMap, consoleWriter);
				Environment e= t.createProcessingEnvironment(rootMap, consoleWriter);
				t.dump(e.getOut());
			
				//System.out.println( "the content"+e.getOut().toString());
				
				//System.out.println( "the content"+e.getDataModel());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return "index";
	}

	/**
	 * Add a new user into static user lists and display the 
	 * same into FTL via redirect 
	 * 
	 * @param user
	 * @return Redirect to /index page to display user list
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") User user) {

		if (null != user && null != user.getFirstname()
				&& null != user.getLastname() && !user.getFirstname().isEmpty()
				&& !user.getLastname().isEmpty()) {

			synchronized (userList) {
				userList.add(user);
			}

		}
		try {
			Template t=freemarkerConfig.getConfiguration().getTemplate("index.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 /*Configuration c= new  Configuration();
		 try {
			Template t=c.getTemplate("C:\\Users\\Vini\\workspace\\Freemarker_SpringMVC_example\\WebContent\\WEB-INF\\ftl\\index.ftl");
		
		 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "redirect:index.html";
	}

}
