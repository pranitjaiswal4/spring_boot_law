package net.javaguides.springboot.service;

import net.javaguides.springboot.model.HomePage;
import net.javaguides.springboot.web.dto.HomePageDto;

public interface HomePageService {
	HomePage save(HomePageDto homePageDto);
}
