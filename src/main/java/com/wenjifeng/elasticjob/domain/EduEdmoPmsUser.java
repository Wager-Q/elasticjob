package com.wenjifeng.elasticjob.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description TODO
 * @className EduEdmoPmsUser
 * @Author wen_jf@suixingpay
 * @Date 2019/1/19 14:44
 * @Version 1.0
 **/
@Data
@ToString
@NoArgsConstructor
public class EduEdmoPmsUser {
    private String id;
    private int version;
    private Date createDate;
    private String userNo;
    private String userType;
    private String mainUserId;
    private String userPwd;
    private String userName;
    private String mobileNo;
    private String email;
    private int status;
    private Date lastLoginTime;
    private int isChangedPwd;
    private int pwdErrorCount;
    private Date pwdErrorTime;
    private String remark;
}
