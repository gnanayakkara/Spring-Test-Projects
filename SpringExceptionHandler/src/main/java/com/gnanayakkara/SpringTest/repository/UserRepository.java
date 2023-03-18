package com.gnanayakkara.SpringTest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnanayakkara.SpringTest.entity.User;

/*
 * 7 Oct 2022
 */

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserId(int id);

}
