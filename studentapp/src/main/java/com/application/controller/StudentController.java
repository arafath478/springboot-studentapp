package com.application.controller;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.application.model.Student;
import com.application.repository.StudentRepo;

@RestController
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static String stdid1;
	public static String stdname1;
	public static String stdbranch1;
	public static String stdaddress1;
	public static String stdmobile1;
	@Autowired
	StudentRepo ob;

	@RequestMapping("/register")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		stdid1 = req.getParameter("stdid");
		stdname1 = req.getParameter("stdname");
		stdbranch1 = req.getParameter("stdbranch");
		stdaddress1 = req.getParameter("stdaddress");
		stdmobile1 = req.getParameter("stdmobile");

		Student stdobj = new Student(stdid1, stdname1, stdbranch1, stdaddress1, stdmobile1);
		ob.save(stdobj);

		resp.sendRedirect("successregister.html");
	}

	@RequestMapping("/display")
	public ModelAndView showUserList(Model model) {
		model.addAttribute("students", ob.findAll());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		return modelAndView;
	}

	@RequestMapping("/delete")
	protected void doGet1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stddelid = req.getParameter("stdid");
		Optional<Student> std = ob.findById(stddelid);

		if (std.isEmpty()) {
			resp.sendRedirect("idnotfound.html");
		} else {
			Student std1 = ob.findById(stddelid)
					.orElseThrow(() -> new IllegalArgumentException("Invalid Student Id:" + stddelid));
			ob.delete(std1);
			resp.sendRedirect("successdelete.html");
		}
	}
}
