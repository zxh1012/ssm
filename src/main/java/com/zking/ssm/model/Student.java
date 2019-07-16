package com.zking.ssm.model;

import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
public class Student {
    public static interface ValidateGroups {

          interface add {
        }

          interface edit {
        }

    }

    @NotNull(message = "ID不能为空",groups = {ValidateGroups.edit.class})
    private Long userId;

    @NotBlank(message = "用户名不能为空",groups = {ValidateGroups.edit.class,ValidateGroups.add.class})
    @Length(min = 2,max = 10,message = "姓名必须2-10之间字符串",groups = {ValidateGroups.edit.class,ValidateGroups.add.class})
    private String username;

    @NotBlank(message = "密码不能为空",groups = {ValidateGroups.edit.class,ValidateGroups.add.class})
    private String password;

    private String salt;

    private Integer locked;

    private Date createDatetime;

    private Long[] userIds;

    public Student(Long userId, String username, String password, String salt, Integer locked, Date createDatetime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
        this.createDatetime = createDatetime;
    }

    public Student() {
        super();
    }

    public Long[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Long[] userIds) {
        this.userIds = userIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }
}