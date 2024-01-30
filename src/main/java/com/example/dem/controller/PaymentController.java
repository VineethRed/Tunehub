package com.example.dem.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dem.entities.Users;
import com.example.dem.services.UsersService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	@Autowired
	UsersService u;
	@GetMapping("/pay")
	public String pay() {
		return "pay";
	}
	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(HttpSession session)
	{
		int amount=5000;
		Order order=null;
		try
		{
			RazorpayClient razorpay=new RazorpayClient("rzp_test_d8783Whf4IUlLA","RuhpsNpERzoSPSfJwj6NeDNj");
			JSONObject orderRequest=new JSONObject();
			orderRequest.put("amount", amount * 100);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11"); // Corrected key to "receipt"
			order = razorpay.orders.create(orderRequest);
			
			String mail=(String)session.getAttribute("email");
			Users us=u.getUser(mail);
			us.setPremium(true);
			u.updateUser(us);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			return order.toString();
		}
	}
}
