package com.web.hr.service;

import com.web.hr.entity.UserInfo;
import com.web.hr.form.SignupForm;
import com.web.hr.repository.UserInfoRepository;
import org.dozer.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserInfoRepository repository;
    private final Mapper mapper;
    private final PasswordEncoder passwordEncoder;

    /**
     *
     * @param form input info
     * @return UserEntity , if userID already exist return Empty
     */
    public Optional<UserInfo> resistUserInfo(SignupForm form){
        var userInfoExistedOpt =repository.findById(form.getLoginId());
        if(userInfoExistedOpt.isPresent()){
            return Optional.empty();
        }

        var userInfo = mapper.map(form,UserInfo.class);
        var encodedPassword = passwordEncoder.encode(form.getPassword());
        userInfo.setPassword(encodedPassword);

        return Optional.of(repository.save(userInfo));
    }
}

