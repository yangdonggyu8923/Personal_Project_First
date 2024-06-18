package com.lawmate.personalproject.user.repository;

import com.lawmate.personalproject.lawyer.model.Lawyer;
import com.lawmate.personalproject.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByIdDesc();
    Optional<User> findByUsername(String username);
    Optional<User> findByName(String name);
    Boolean existsByUsername(String username);
    @Modifying
    @Query("update users set token=:token where id = :id")
    void modifyTokenById(@Param("id") Long id, @Param("token") String token);

    @Query("SELECT a FROM users a ORDER BY a.id DESC")
    List<User> getUsersById();
}
