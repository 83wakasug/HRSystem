package com.web.hr.form;

import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class SignupForm {

    /**  signup id*/
    @Length(min = 8,max = 20)
    String loginId;
    /**  password */
    @Length(min = 8,max = 20)
    String password;
}
