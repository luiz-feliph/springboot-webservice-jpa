package com.luizfelipe.webservice.repositories;

import com.luizfelipe.webservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
