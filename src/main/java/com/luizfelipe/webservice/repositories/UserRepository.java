package com.luizfelipe.webservice.repositories;

import com.luizfelipe.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
