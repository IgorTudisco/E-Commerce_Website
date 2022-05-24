package com.luv2codestudent.Ecommerce.dao;

import com.luv2codestudent.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200") // passing the Angular address
public interface ProductRepository extends JpaRepository<Product, Long> {
}
