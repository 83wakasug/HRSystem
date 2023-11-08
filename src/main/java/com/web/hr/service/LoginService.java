package com.web.hr.service;

import com.web.hr.entity.UserInfo;
import com.web.hr.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Login screen service
 */
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserInfoRepository repository;

    /**
     * User table Key search
     * @param loginID login ID
     * @return result for main key search
     */
    public Optional<UserInfo> searchUserByID(String loginID){
        return repository.findById(loginID);
    }


}
