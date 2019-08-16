package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.ApplicantDao;
import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.utils.BaseDao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-05
 * Time:    9:50
 */
public class ApplicantDaoImpl extends BaseDao implements ApplicantDao {
    @Override
    public List<Applicant> listAllApplicant() throws SQLException {
        String sql = "select * from hr.applicant";
        List<Applicant> query = super.query(sql, null, Applicant.class);
        return  query;


    }

    @Override
    public void deleteApplicant(int id) throws SQLException {
        String sql = "delete from hr.applicant where id=?";

        Object[] parameter = {id};
        int update = super.update(sql, parameter);

    }

    @Override
    public void modifyById(int id) throws SQLException {
        String sql = "update hr.applicant set isHiring = ? where id="+id;
        Object[] parameters = {1};
       super.update(sql,parameters);

    }

    @Override
    public void addToUser(Applicant applicant) throws SQLException {
        String sql = "insert into hr.user(userName,password,gender,createTime,content,roleId) values (?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = format.format(applicant.getCreateTime());
        Object[] parameters = {applicant.getName(),123,applicant.isGender(),createTime,applicant.getContent(),0};
        super.update(sql,parameters);
    }
}
