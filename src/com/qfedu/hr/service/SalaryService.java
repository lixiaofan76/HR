package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Salary;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    14:58
 */
public interface SalaryService {

    /**
     * 查询所有员工的工资信息
     * @return
     */
    public List<Salary> listAllSalary() throws SQLException;

    /**
     * 添加员工工资
     * @param salary
     * @throws SQLException
     */
    public void addSalary(Salary salary) throws SQLException;

    /**
     * 删除指定id的工资信息
     * @param id
     * @throws SQLException
     */
    public void deleteSalaryById(int id) throws SQLException;


    /**
     * 根据id查找工资信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Salary findOneSalaryById(int id) throws SQLException;

    /**
     * 根据id修改工资信息
     * @param salary
     * @param id
     */
    public void midifySalaryById(Salary salary,int id) throws SQLException;

}
