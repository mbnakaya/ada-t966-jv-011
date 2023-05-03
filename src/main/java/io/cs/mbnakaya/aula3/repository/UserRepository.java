package io.cs.mbnakaya.aula3.repository;

import io.cs.mbnakaya.aula3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
