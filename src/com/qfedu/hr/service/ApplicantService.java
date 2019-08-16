package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Applicant;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-05
 * Time:    9:58
 */
public interface ApplicantService {

    /**
     * 查询所有应聘者信息
     * @return
     */
    public List<Applicant> listAllApplicant() throws SQLException;

    /**
     * 删除指定id的应聘者信息
     * @param id
     * @throws SQLException
     */
    public void deleteApplicant(int id) throws SQLException;

    /**
     * 修改指定id的应聘者信息
     * @param id
     */
    public void midifyById(int id) throws SQLException;

    /**
     * 将应聘者信息添加到user表中
     * @param applicant
     */
    public void addToUser(Applicant applicant) throws SQLException;
}
