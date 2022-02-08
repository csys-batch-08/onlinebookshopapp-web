package com.onlinebookshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookshop.daoimpl.UserdetailsDao;
import com.onlinebookshop.model.Userdetails;

@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");

		Long phoneno = Long.parseLong(request.getParameter("phoneno"));

		String address = request.getParameter("address");

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		Userdetails user = new Userdetails(name, phoneno, address, email, password, 0);

		UserdetailsDao userdao = new UserdetailsDao();

		userdao.update(user);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyProfileServlet");

		requestDispatcher.forward(request, response);

	}

}
