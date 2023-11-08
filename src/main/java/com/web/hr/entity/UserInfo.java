package com.web.hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/** User Table Entity
 *
 *
 */
@Entity
@Table(name="user_info")
@Data
public class UserInfo {

     /** loginID */
     @Id
     @Column(name="login_id")
     private String loginId;

     /** password*/
     private String password;


}
