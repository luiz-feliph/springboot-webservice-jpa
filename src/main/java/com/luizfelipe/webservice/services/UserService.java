package com.luizfelipe.webservice.services;

import com.luizfelipe.webservice.entities.User;
import com.luizfelipe.webservice.repositories.UserRepository;
import com.luizfelipe.webservice.services.exceptions.DataBaseException;
import com.luizfelipe.webservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    private void updateData(User entity, User requestData) {
        entity.setName(requestData.getName());
        entity.setEmail(requestData.getEmail());
        entity.setPhone(requestData.getPhone());
    }

    public User update(Long id, User requestData) {
        User entity = repository.getReferenceById(id);
        updateData(entity, requestData);
        return repository.save(entity);
    }
}
