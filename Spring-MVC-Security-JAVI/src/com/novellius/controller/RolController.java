package com.novellius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novellius.pojo.Rol;
import com.novellius.pojo.Usuario;
import com.novellius.service.RolService;

@Controller
public class RolController {

	@Autowired
	private RolService rolService;

	@RequestMapping("/rol")
	public String showForm(Model model) {
		model.addAttribute("rol", new Rol());
		model.addAttribute("rols", rolService.findAll());
		return "rol";
	}
	
	@RequestMapping("/rol/save")
	public String register(@ModelAttribute("rol") Rol rolForm,
			Model model) {
		
		rolService.save(rolForm);
		
		return "redirect:/rol";
	}

}
