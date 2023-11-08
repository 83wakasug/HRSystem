package com.web.hr.repository;

import com.web.hr.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User information table DAO
 * */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

}
