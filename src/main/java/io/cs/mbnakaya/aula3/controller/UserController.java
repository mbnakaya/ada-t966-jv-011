package io.cs.mbnakaya.aula3.controller;

import io.cs.mbnakaya.aula3.model.User;
import io.cs.mbnakaya.aula3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @NotNull User body) {
        var result = this.service.create(body);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable @NotNull Long id) {
        var result = this.service.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        var result = this.service.list();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestParam @NotNull Long id) {
        this.service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
