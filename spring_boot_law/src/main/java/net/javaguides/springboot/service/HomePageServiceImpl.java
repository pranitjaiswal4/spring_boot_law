package net.javaguides.springboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.HomePage;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.HomePageRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.web.dto.HomePageDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Service
public class HomePageServiceImpl implements HomePageService{

	private HomePageRepository homePageRepository;
	
	public HomePageServiceImpl(HomePageRepository homePageRepository) {
		super();
		this.homePageRepository = homePageRepository;
	}

	@Override
	public HomePage save(HomePageDto homePageDto) {
		HomePage homePage = new HomePage(homePageDto.getFirstName(), 
				homePageDto.getLastName(), homePageDto.getEmail(),
				homePageDto.getQueryText(), homePageDto.getQueryDocUri());
		
		return homePageRepository.save(homePage);
	}


	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
