package com.phoenix.controllers;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phoenix.entities.User;
import com.phoenix.exceptions.UserAlreadyExistsException;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//@RequestMapping(path = "/login",method = RequestMethod.POST)
	@PostMapping("/login")
	public String validateUser(User user,ModelMap map,HttpSession session) {
		try {
			User dbUser = userService.findByUsername(user.getUsername());
			if(dbUser.getPassword().equals(user.getPassword())) {
				map.addAttribute("uname", user.getUsername());
				return "welcome.jsp";
			}
			else {
				map.addAttribute("logonerror","Invalid username/password");
				session.setAttribute("logonerror", "Invalid username/password");
				//return "redirect:/login.jsp";
				return "redirect:/login-error";
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.addAttribute("logonerror",e.getMessage());
			return "login.jsp";
		}
	}
	//@RequestMapping(path = "/login-error",method = RequestMethod.GET)
	@GetMapping("/login-error")
	public String loginError() {
		return "login.jsp";
	}
	
	@PostMapping("/signup")
	public String addNewUser(User user,ModelMap map) {
		try {
			userService.add(user);
			map.addAttribute("chaU", "Your account created successfully!");
			return "login.jsp";
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.addAttribute("chaU", e.getMessage());
			return "SignUp.jsp";
		}
		
	}
	
	@PostMapping("/deleteAcc")
	public String deleteUser(User user,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		try {
			if(session != null) {
				String username = (String)session.getAttribute("user");
				User usr = userService.findByUsername(username);
				userService.remove(usr);
				map.addAttribute("chaU", "Your account deleted successfully!");
				return "login.jsp";
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/SessionExpire.jsp";
	}
	
	@PostMapping("/changePass")
	public String changePassword(String newpasswd,String cfmnewpasswd,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		try {
			if(session != null) {
				if(newpasswd.equals(cfmnewpasswd)) {
					String username = (String)session.getAttribute("user");
					User usr = userService.findByUsername(username);
					usr.setPassword(newpasswd);
					userService.edit(usr);
					map.addAttribute("chaU", "Your Password changed successfully!");
					return "login.jsp";
				}
				else {
					map.addAttribute("reenter", "Enter same password in both fields");
					return "change.jsp";
				}
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/SessionExpire.jsp";
	}
	
	@GetMapping("/logout")
	public String SignOut(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null)
			session.invalidate();
		return "redirect:/login.jsp";
	}
	
}
	

