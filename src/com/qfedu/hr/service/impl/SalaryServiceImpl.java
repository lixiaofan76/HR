package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.SalaryDao;
import com.qfedu.hr.dao.impl.SalaryDaoImpl;
import com.qfedu.hr.pojo.Salary;
import com.qfedu.hr.service.SalaryService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    14:59
 */
public class SalaryServiceImpl implements SalaryService {
    private static SalaryDao salaryDao = new SalaryDaoImpl();

    @Override
    public List<Salary> listAllSalary() throws SQLException {
        return salaryDao.listAllSalary();
    }

    @Override
    public void addSalary(Salary salary) throws SQLException {
        salaryDao.addSalary(salary);
    }

    @Override
    public void deleteSalaryById(int id) throws SQLException {
        salaryDao.deleteSalaryById(id);
    }

    @Override
    public Salary findOneSalaryById(int id) throws SQLException {
        return salaryDao.findOneSalaryById(id);
    }

    @Override
    public void midifySalaryById(Salary salary, int id) throws SQLException {
        salaryDao.midifySalaryById(salary,id);
    }

}
