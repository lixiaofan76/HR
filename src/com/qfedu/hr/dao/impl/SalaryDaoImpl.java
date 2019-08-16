package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.SalaryDao;
import com.qfedu.hr.pojo.Salary;
import com.qfedu.hr.utils.BaseDao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    14:56
 */
public class SalaryDaoImpl extends BaseDao implements SalaryDao {
    @Override
    public List<Salary> listAllSalary() throws SQLException {
        String sql = "select * from hr.salary";
        List<Salary> query = super.query(sql, null, Salary.class);
        return query;
    }

    @Override
    public void addSalary(Salary salary) throws SQLException {
        String sql = "insert into hr.salary values(?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String grantTime = format.format(salary.getGrantTime());
        double total = salary.getBasic() + salary.getEat() + salary.getHouse() + salary.getDuty() + salary.getOther() - salary.getScot() - salary.getPunishment();
        Object[] parameters = {null,salary.getUserId(),salary.getBasic(),salary.getEat(),salary.getHouse(),
            salary.getDuty(),salary.getScot(),salary.getPunishment(),salary.getOther(),grantTime,total};
        super.update(sql,parameters);

    }

    @Override
    public void deleteSalaryById(int id) throws SQLException {
        String sql = "delete from hr.salary where id=?";
        Object[] parameter = {id};
        super.update(sql,parameter);
    }

    @Override
    public Salary findOneSalaryById(int id) throws SQLException {
        String sql = "select * from hr.salary where id=?";
        Object[] parameter = {id};
        List<Salary> salaries = super.query(sql, parameter, Salary.class);
        return salaries != null ? salaries.get(0) : null;
    }

    @Override
    public void midifySalaryById(Salary salary, int id) throws SQLException {
        String sql = "update hr.salary set basic = ?,eat=?,house=?,duty=?,scot=?,punishment=?,other=?,grantTime=?,totalize=? where id=?" ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String grantTime = simpleDateFormat.format(salary.getGrantTime());
        double total = salary.getBasic() + salary.getEat() + salary.getHouse() + salary.getDuty() + salary.getOther() - salary.getScot() - salary.getPunishment();
        Object[] parameters = {salary.getBasic(),salary.getEat(),salary.getHouse(),salary.getDuty(),salary.getScot(),
            salary.getPunishment(),salary.getOther(),grantTime,total,id};
        super.update(sql,parameters);
    }
}
