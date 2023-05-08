package com.vap.projectM.repository;

import com.vap.projectM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByFirstName(String firstName);

    boolean existsByLastName(String lastName);

    boolean existsByDob(String dob);

    boolean existsByPhone(String phone);


    boolean existsByCity(String city);

}
