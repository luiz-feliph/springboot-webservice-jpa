package com.luizfelipe.webservice.repositories;

import com.luizfelipe.webservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
