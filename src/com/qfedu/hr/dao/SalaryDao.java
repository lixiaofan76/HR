package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.Salary;
import org.springframework.jdbc.object.SqlCall;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    14:55
 */
public interface SalaryDao {

    /**
     * 查询所有员工的工资信息
     * @return List<Salary> 工资对象集合
     */
    public List<Salary> listAllSalary() throws SQLException;

    /**
     * 添加工资
     * @throws SQLException
     */
    public void addSalary(Salary salary) throws SQLException;

    /**
     * 通过id删除工资信息
     * @param id
     * @throws SQLException
     */
    public void deleteSalaryById(int id) throws SQLException;

    /**
     * 根据id查询工资信息
     * @param id
     * @return
     */
    public Salary findOneSalaryById(int id) throws SQLException;

    /**
     * 根据id修改工资信息
     * @param salary
     * @param id
     */
    public void midifySalaryById(Salary salary,int id) throws SQLException;
}
