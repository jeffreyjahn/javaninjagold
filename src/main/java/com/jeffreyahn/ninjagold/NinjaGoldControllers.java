package com.jeffreyahn.ninjagold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NinjaGoldControllers {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			ArrayList<String> log = new ArrayList<String>();
			session.setAttribute("gold", 0);
			session.setAttribute("log", log);
			model.addAttribute("gold", 0);
			return "index.jsp";
		} else {
			model.addAttribute("gold", session.getAttribute("gold"));
			@SuppressWarnings("unchecked")
			ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
			model.addAttribute("currLog", log);
			return "index.jsp";
		}
	}
	
	@RequestMapping(value="/gold/{action}", method=RequestMethod.POST)
	public String action(HttpSession session, @PathVariable(value="action") String action) {
		int gold = (int) session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
		
		if(action.equals("farm")) {
			Random r = new Random();
			int newGold = r.nextInt(4)+2;
			gold = gold + newGold;
			String newLog = "You have got $" + newGold + " from the farm!";
//			String gain = "green";
//			ArrayList<String> addLog = new ArrayList<String>();
//			addLog.add(newLog);
//			addLog.add(gain);
			log.add(0, newLog);
		} else if(action.equals("cave")) {
			Random r = new Random();
			int newGold = r.nextInt(6)+5;
			gold = gold + newGold;
			String newLog = "You have got $" + newGold + " from the cave!";
//			String gain = "green";
//			ArrayList<String> addLog = new ArrayList<String>();
//			addLog.add(newLog);
//			addLog.add(gain);
			log.add(0, newLog);
			
		} else if(action.equals("house")) {
			Random r = new Random();
			int newGold = r.nextInt(9)+7;
			gold = gold + newGold;
			String newLog = "You have got $" + newGold + " from the house!";
//			String gain = "green";
//			ArrayList<String> addLog = new ArrayList<String>();
//			addLog.add(newLog);
//			addLog.add(gain);
			log.add(0, newLog);
			
		} else if(action.equals("casino")) {
			Random r = new Random();
			int newGold = r.nextInt(201)-100;
			String newLog;
//			String gain;
			if(newGold < 0) {
				gold = gold + newGold;
				newLog = "You have lost " + newGold + " gold from the casino!";
//				gain = "red";
			} else {
				gold = gold + newGold;
				newLog = "You have won " + newGold + " gold from the casino!";
//				gain = "green";
			}
//			ArrayList<String> addLog = new ArrayList<String>();
//			addLog.add(newLog);
//			addLog.add(gain);
			log.add(0, newLog);
		} else {
			System.out.println("what");
		}
		session.setAttribute("gold", gold);
		session.setAttribute("log", log);
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
}
