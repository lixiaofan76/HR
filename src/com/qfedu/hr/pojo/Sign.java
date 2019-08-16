package com.qfedu.hr.pojo;

import java.util.Date;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-09
 * Time:    16:51
 */
public class Sign {
    private Integer id;
    private String userName;
    private Date signTime;
    private boolean mark;

    public Sign(Integer id, String userName, Date signTime, boolean mark) {
        this.id = id;
        this.userName = userName;
        this.signTime = signTime;
        this.mark = mark;
    }

    public Sign(String userName, Date signTime, boolean mark) {
        this.userName = userName;
        this.signTime = signTime;
        this.mark = mark;
    }

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

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", signTime=" + signTime +
                ", mark=" + mark +
                '}';
    }

    public Sign() {
    }
}
