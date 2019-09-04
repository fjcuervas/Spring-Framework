package com.novellius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novellius.pojo.Usuario;
import com.novellius.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;


	@RequestMapping("/usuario")
	public String showForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuario";
	}
	
	
	@RequestMapping("/usuario/save")
	public String register(@ModelAttribute("usuario") Usuario usuarioForm,
			Model model) {
		
		usuarioService.save(usuarioForm);
		
		return "redirect:/usuario";
	}

}
