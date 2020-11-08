package com.recruitment.team.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recruitment.team.model.entity.Recruiter;
import com.recruitment.team.model.service.RecruiterService;

@WebServlet(urlPatterns= {"/login","/recruiter-add","/recruiters"},loadOnStartup = 1)
public class RecruiterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private RecruiterService recruiterService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		EntityManagerFactory EMF=null;
		Object obj=getServletContext().getAttribute("emf");
		if(obj==null)
		{
			EMF=Persistence.createEntityManagerFactory("jsp-jpa-recruiter");
			getServletContext().setAttribute("emf", EMF);
			
		}else
		{
			EMF=(EntityManagerFactory) obj;
		}
		recruiterService=new RecruiterService(EMF.createEntityManager());
	}
	
	@Override
	public void destroy() {
		EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf!=null && emf.isOpen())
			emf.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if("/recruiters".equals(path)) {
			List<Recruiter> list=recruiterService.findAll();
			//set to request
			
			req.setAttribute("recruiter",list);
			//forward
			getServletContext().getRequestDispatcher("/recruiter.jsp").forward(req,resp);
		
		}else if("/recruiter-add".equals(path)||"/recruiter-edit".equals(path)) {
			//get data from db
			
			List<Recruiter> list=recruiterService.findAll();
			
			//set data to req
			req.setAttribute("townships",list);
			
		 if("/recruiter-edit".equals(path)) {
			//get id from request 
			String id=req.getParameter("id");
			
			//get data from db
			
			Recruiter t=recruiterService.findById(Integer.parseInt(id));
			
			//set data to req
			
			req.setAttribute("townships", t);
			
		 }
		//forward page
			
		getServletContext().getRequestDispatcher("/recruiter-add.jsp").forward(req, resp);
			
		}else if("/recruiter-delete".equals(path)){
			String id=req.getParameter("id");
			
			recruiterService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath().concat("/recruiters"));
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getServletPath();
		if("/recruiter-add".equals(action))
		{
			//get data from request
			String id=req.getParameter("recruiterid");
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			//create  obj
			Recruiter recruiter=(id==null || id.equals("") ? new Recruiter() : recruiterService.findById(Integer.parseInt(id)));
			
			recruiter.setName(name);
			recruiter.setPhone(phone);
			recruiter.setEmail(email);
			recruiter.setPassword(password);
			
			//insert to db
			RecruiterService.save(recruiter);
			
			//set to request
			req.setAttribute("recruiters", recruiter);
			
			//redirect page
			resp.sendRedirect(req.getContextPath().concat("/recruiters"));
		}
		else if("/login".equals(action))
		{
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			try
			{
				Recruiter recruiter=recruiterService.login(email,password);
				HttpSession session=req.getSession(true);
				session.setAttribute("loginuser", recruiter);
				
				resp.sendRedirect(req.getContextPath().concat("/template.jsp"));
				
			}catch(NoResultException e)
			{
				req.setAttribute("message", "Invalid Login User! ! Please Try Again..");
				getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}
	}

}