package com.qfedu.hr.pojo;

import java.util.Date;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    10:37
 */
public class Train {
    private Integer id;
    private String name;
    private String purpose;
    private Date beginTime;
    private Date endTime;
    private String datum;
    private String teacher;
    private Integer studentId;
    private Date createTime;
    private boolean educate;
    private String effect;
    private String summarize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isEducate() {
        return educate;
    }

    public void setEducate(boolean educate) {
        this.educate = educate;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public Train(Integer id, String name, String purpose, Date beginTime, Date endTime, String datum, String teacher, Integer studentId, Date createTime, Boolean educate, String effect, String summarize) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.datum = datum;
        this.teacher = teacher;
        this.studentId = studentId;
        this.createTime = createTime;
        this.educate = educate;
        this.effect = effect;
        this.summarize = summarize;
    }

    public Train(String name, String purpose, Date beginTime, Date endTime, String datum, String teacher, Integer studentId, Date createTime, Boolean educate, String effect, String summarize) {
        this.name = name;
        this.purpose = purpose;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.datum = datum;
        this.teacher = teacher;
        this.studentId = studentId;
        this.createTime = createTime;
        this.educate = educate;
        this.effect = effect;
        this.summarize = summarize;
    }

    public Train() {
    }
}
