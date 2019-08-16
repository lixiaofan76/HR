package com.qfedu.hr.pojo;

import java.util.Date;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    10:37
 */
public class Salary {
    private Integer id;
    private String userId;
    private Double basic;
    private Double eat;
    private Double house;
    private Double duty;
    private Double scot;
    private Double punishment;
    private Double other;
    private Date grantTime;
    private Double totalize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public Double getEat() {
        return eat;
    }

    public void setEat(Double eat) {
        this.eat = eat;
    }

    public Double getHouse() {
        return house;
    }

    public void setHouse(Double house) {
        this.house = house;
    }

    public Double getDuty() {
        return duty;
    }

    public void setDuty(Double duty) {
        this.duty = duty;
    }

    public Double getScot() {
        return scot;
    }

    public void setScot(Double scot) {
        this.scot = scot;
    }

    public Double getPunishment() {
        return punishment;
    }

    public void setPunishment(Double punishment) {
        this.punishment = punishment;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Date getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(Date grantTime) {
        this.grantTime = grantTime;
    }

    public Double getTotalize() {
        return totalize;
    }

    public void setTotalize(Double totalize) {
        this.totalize = totalize;
    }

    public Salary(Integer id, String userId, Double basic, Double eat, Double house, Double duty, Double scot, Double punishment, Double other, Date grantTime, Double totalize) {
        this.id = id;
        this.userId = userId;
        this.basic = basic;
        this.eat = eat;
        this.house = house;
        this.duty = duty;
        this.scot = scot;
        this.punishment = punishment;
        this.other = other;
        this.grantTime = grantTime;
        this.totalize = totalize;
    }

    public Salary(String userId, Double basic, Double eat, Double house, Double duty, Double scot, Double punishment, Double other, Date grantTime, Double totalize) {
        this.userId = userId;
        this.basic = basic;
        this.eat = eat;
        this.house = house;
        this.duty = duty;
        this.scot = scot;
        this.punishment = punishment;
        this.other = other;
        this.grantTime = grantTime;
        this.totalize = totalize;
    }

    public Salary() {
    }
}
