package com.qfedu.hr.pojo;

import java.util.Date;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-08
 * Time:    19:09
 */
public class Qingjia {

    private Integer id;
    private String userName;
    private Integer totalDay;
    private String content;
    private String approval;
    private Boolean cancel;
    private Date createTime;

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

    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Qingjia(Integer id, String userName, Integer totalDay, String content, String approval, Boolean cancel, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.totalDay = totalDay;
        this.content = content;
        this.approval = approval;
        this.cancel = cancel;
        this.createTime = createTime;
    }

    public Qingjia(String userName, Integer totalDay, String content, String approval, Boolean cancel, Date createTime) {
        this.userName = userName;
        this.totalDay = totalDay;
        this.content = content;
        this.approval = approval;
        this.cancel = cancel;
        this.createTime = createTime;
    }

    public Qingjia() {
    }

    @Override
    public String toString() {
        return "Qingjia{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", totalDay=" + totalDay +
                ", content='" + content + '\'' +
                ", approval='" + approval + '\'' +
                ", cancel=" + cancel +
                ", createTime=" + createTime +
                '}';
    }
}
