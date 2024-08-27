package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    List<UserAccount> findByNameContaining(String name);

    Optional<UserAccount> findByUsername(String username);

    void deleteByUsername(String username);
}
