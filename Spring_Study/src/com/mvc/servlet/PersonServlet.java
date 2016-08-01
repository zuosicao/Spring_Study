package com.mvc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.bean.Person;
import com.mvc.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonServlet {
	@Autowired
	private PersonService personService;
	
	//http://localhost:8080/Spring_MVC_Study/persons/view1?personId=1
	@RequestMapping(value="/view1", method=RequestMethod.GET)
	public String viewPerson1(@RequestParam("personId") Integer personId,Model model) {
		System.out.println("zsdfs");
		Person person = personService.getPersonbyId(personId);
		model.addAttribute(person);
		return "index";
	}
	
	//http://localhost:8080/Spring_MVC_Study/persons/view2/1
	@RequestMapping(value="/view2/{personId}")
	public String viewPerson2(@PathVariable("personId") Integer personId,Map<String, Object> model) {
		Person person = personService.getPersonbyId(personId);
		model.put("person", person);
		return "index";
	}
	
	//传统方式
	//http://localhost:8080/Spring_MVC_Study/persons/view3?personId=1
	@RequestMapping(value="/view3")
	public String viewPerson3(HttpServletRequest request) {
		/*
		 * Integer.valueOf(String str) String - Integer
		 * Integer.paseInt(String str) String - int
		 */
		Integer personId = Integer.valueOf(request.getParameter("personId"));
		Person person = personService.getPersonbyId(personId);
		request.setAttribute("person", person);
		return "index";
	}
	
	//向前端传递一个listmap
	//http://localhost:8080/Spring_MVC_Study/persons/listmap
	@RequestMapping(value="/listmap")
	public String viewListMap(HttpServletRequest request,HttpServletResponse response,Map<String,Object> model) {
		List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("zsc", "11");
		map1.put("sss", "12");
		map1.put("ccc", "13");
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("zsc", "22");
		map2.put("sss", "33");
		map2.put("ccc", "44");
		listmap.add(map1);
		listmap.add(map2);
		//model.addAttribute(listmap);
		model.put("listmap", listmap);
		return "index";
	}
	
	//使用ModelAndView，向前端传递一个listmap，listmap用map包装好
	//http://localhost:8080/Spring_MVC_Study/persons/listmapModelAndView
	@RequestMapping(value="/listmapModelAndView")
	public ModelAndView viewListMapModelAndView() {
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("zsc", "11");
		map1.put("sss", "12");
		map1.put("ccc", "13");
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("zsc", "22");
		map2.put("sss", "33");
		map2.put("ccc", "44");
		listmap.add(map1);
		listmap.add(map2);
		
		//将listmap放到map中，然后新建ModelAndView对象，该对象绑定了视图和返回值
		map.put("listmap", listmap);
		ModelAndView model = new ModelAndView("index", map);
		return model;
	}
	
	//http://localhost:8080/Spring_MVC_Study/persons/admin?add
	//进入编辑页面,页面中的name和对象中的属性名一致
	@RequestMapping(value="/admin",method=RequestMethod.GET,params="add")
	public String createPerson() {
		return "edit";
	}
	
	//保存对象,页面中的name和对象中的属性名一致
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePerson(Person person) {
		//这里主要是展示前端值与对象绑定，跳转后并不会显示输入的值，可以在后台看到输出效果
		person.setId(111);
		System.out.println(person.getName());
		System.out.println(person.getAge());
		
		//页面重定向，注意写对单词redirect.
		//http://localhost:8080/Spring_MVC_Study/persons/view2/111
		return "redirect:view2/"+person.getId();
	}
	
	/*
	 * 文件上传
	 */
	//http://localhost:8080/Spring_MVC_Study/persons/upload
	//进入文件上传页面,页面中的name和对象中的属性名一致
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String showUploadPage() {
		return "edit";
	}
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\io_file\\",System.currentTimeMillis()+file.getOriginalFilename()));
		}
		return "success";
	}
	
	/*
	 * 可以让springmvc将相同的数据呈现成不同的数据表现形式
	 * org.springframework.web.servlet.view.ContentNegotiatingViewResolver
	 * org.springframework.web.servlet.view.json.MappingJackson2JsonView
	 */
	//http://localhost:8080/Spring_Study/persons/1
	@RequestMapping(value="/{personId}", method=RequestMethod.GET)
	public @ResponseBody Person getPersonJson(@PathVariable Integer personId) {
		return personService.getPersonbyId(personId);
	}
	
}
