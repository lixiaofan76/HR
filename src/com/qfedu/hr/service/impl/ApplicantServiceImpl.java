package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.ApplicantDao;
import com.qfedu.hr.dao.impl.ApplicantDaoImpl;
import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.service.ApplicantService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-05
 * Time:    10:00
 */
public class ApplicantServiceImpl implements ApplicantService {
    private static ApplicantDao applicantDao = new ApplicantDaoImpl();
    @Override
    public List<Applicant> listAllApplicant() throws SQLException {
        return applicantDao.listAllApplicant();
    }

    @Override
    public void deleteApplicant(int id) throws SQLException {
        applicantDao.deleteApplicant(id);
    }

    @Override
    public void midifyById(int id) throws SQLException {
        applicantDao.modifyById(id);
    }

    @Override
    public void addToUser(Applicant applicant) throws SQLException {
        applicantDao.addToUser(applicant);
    }
}
