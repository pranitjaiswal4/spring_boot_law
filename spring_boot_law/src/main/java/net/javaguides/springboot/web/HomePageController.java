package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.HomePageService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.HomePageDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/index")
public class HomePageController {

	private HomePageService homePageService;

	public HomePageController(HomePageService homePageService) {
		super();
		this.homePageService = homePageService;
	}
	
	@ModelAttribute("homepage")
    public HomePageDto homePageDto() {
        return new HomePageDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "index";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("homepage") HomePageDto homePageDto) {
		homePageService.save(homePageDto);
		return "redirect:/index?success";
	}
}
