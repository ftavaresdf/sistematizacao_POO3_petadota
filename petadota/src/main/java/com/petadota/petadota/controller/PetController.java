package com.petadota.petadota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petadota.petadota.entity.Pet;
import com.petadota.petadota.service.PetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService service;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("pets", service.listarTodos());
		return "index";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("pet", new Pet());
		return "form";
	}

	@PostMapping
	public String salvar(@ModelAttribute @Valid Pet pet, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		service.salvar(pet);
		return "redirect:/pets";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("pet", service.buscarPorId(id));
		return "form";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/pets";
	}

	@GetMapping("/{id}")
	public String detalhes(@PathVariable Long id, Model model) {
		model.addAttribute("pet", service.buscarPorId(id));
		return "detalhes";
	}
}
