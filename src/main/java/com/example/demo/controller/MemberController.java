package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@Controller
//@RequestMapping("/")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("members", memberService.findAll());
		return "index";
	}
	
	@GetMapping("/add")
	public String show(@ModelAttribute Member member, Model model) {
		model.addAttribute("members", memberService.findAll());
		return "form";
	}
	

	@PostMapping("/process")
	public String addMember(@Validated @ModelAttribute Member member, BindingResult result, Model model) {
		model.addAttribute("members", memberService.findAll());
		memberService.save(member);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.findOne(id));
//		memberService.update(member);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		memberService.delete(id);
		return "redirect:/";
	}

}
