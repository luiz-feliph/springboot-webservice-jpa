package com.luizfelipe.webservice.repositories;

import com.luizfelipe.webservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
