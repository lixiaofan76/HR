package com.qfedu.hr.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    10:36
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private boolean gender;
    private Date birthday;
    private Date createTime;
    private String content;
    private Integer roleId;
    private String imgPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public User(Integer id, String userName, String password, boolean gender, Date birthday, Date createTime, String content, Integer roleId, String imgPath) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.createTime = createTime;
        this.content = content;
        this.roleId = roleId;
        this.imgPath = imgPath;
    }

    public User(String userName, String password, boolean gender, Date birthday, Date createTime, String content, Integer roleId, String imgPath) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.createTime = createTime;
        this.content = content;
        this.roleId = roleId;
        this.imgPath = imgPath;
    }

    public User() {
    }
}
