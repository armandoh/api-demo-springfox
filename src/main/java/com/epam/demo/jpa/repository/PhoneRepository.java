package com.epam.demo.jpa.repository;



import com.epam.demo.jpa.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
