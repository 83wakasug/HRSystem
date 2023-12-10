package com.web.hr.Constatnt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SignupMessage {

    SUCCEED(MessageConst.SIGNUP_RESIST_SUCCEED,false),
    EXISTED_LOGIN_ID(MessageConst.SIGNUP_EXISTED_LOGIN,true);

    private String messageID;
    private boolean isError;

}
