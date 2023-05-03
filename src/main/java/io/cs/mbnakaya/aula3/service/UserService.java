package io.cs.mbnakaya.aula3.service;

import io.cs.mbnakaya.aula3.model.User;
import io.cs.mbnakaya.aula3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return this.repository.save(user);
    }

    public User getById(Long id) {
        return this.repository.getReferenceById(id);
    }

    public List<User> list() {
        return this.repository.findAll();
    }

    public void delete(Long id) {
        User user = this.repository.getReferenceById(id);
        this.repository.delete(user);
    }
}
