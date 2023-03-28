package com.gnanayakkara.springsecuritylatest.reposotory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnanayakkara.springsecuritylatest.entity.UserInfo;

/*
 * 28 Mar 2023
 */

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByName(String username);

}
