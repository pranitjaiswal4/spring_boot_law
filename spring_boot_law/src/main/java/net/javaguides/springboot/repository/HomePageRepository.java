package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.HomePage;

@Repository
public interface HomePageRepository extends JpaRepository<HomePage, Long>{
	HomePage findByEmail(String email);
}
