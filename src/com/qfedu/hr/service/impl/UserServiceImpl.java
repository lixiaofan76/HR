package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.UserDao;
import com.qfedu.hr.dao.impl.UserDaoImpl;
import com.qfedu.hr.pojo.*;
import com.qfedu.hr.service.UserService;
import com.qfedu.hr.vo.VoUserList;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    11:21
 */
public class UserServiceImpl implements UserService {
    private static UserDao userDao = new UserDaoImpl();
    /**
     * 实现用户登录
     * @param userName  用户名
     */
    @Override
    public User login(String userName,String password) {
      return userDao.login(userName,password);
    }
    /*
    实现应聘者登录
     */
    @Override
    public Applicant applicantLog(String name, String tel) throws SQLException {
        return userDao.applicantLog(name,tel);
    }

    @Override
    public List<VoUserList> ListInfo() {
        return userDao.ListInfo();
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public Applicant findByApplicantId(int id) throws SQLException {
        return userDao.findByApplicantId(id);
    }

    @Override
    public int modifyUserInfo(User user) throws SQLException {
        return userDao.modifyUserInfo(user);
    }

    @Override
    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    @Override
    public void applicantRegister(Applicant applicant) throws SQLException {
        userDao.applicantRegister(applicant);
    }

    @Override
    public void register(User user) throws SQLException {
        userDao.register(user);
    }

    @Override
    public void deleteSelected(String[] uids) {
        if (uids != null && uids.length > 0) {
            //    遍历数组
            for (String id : uids) {
                //    调用dao层方法
                userDao.deleteById(Integer.parseInt(id));

            }
        }
    }

    @Override
    public PageBean<VoUserList> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) throws SQLException {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <=0) {
            currentPage = 1;
        }


        //创建空的pageBean对象
        PageBean<VoUserList> pageBean = new PageBean<VoUserList>();
        //设置参数
        // pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用dao查询总记录数
        int totalCount = userDao.findTotalCount(condition);
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : totalCount/rows + 1;
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        pageBean.setTotalCount(totalCount);

        //调用dao中List集合
        //计算开始的索引
        int start = (currentPage - 1) * rows;
        List<VoUserList> list = userDao.findByPage(start,rows,condition);
        pageBean.setList(list);

        //计算总页码
        // int totalPage = (totalCount % rows) == 0 ? totalCount/rows : totalCount/rows + 1;

        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);


        return pageBean;
    }

    /*@Override
    public PageBean<VoUserList> findUserByPage(String _currentPage, String _rows) throws SQLException {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <=0) {
            currentPage = 1;
        }


        //创建空的pageBean对象
        PageBean<VoUserList> pageBean = new PageBean<VoUserList>();
        //设置参数
        // pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用dao查询总记录数
        int totalCount = userDao.findTotalCount();
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : totalCount/rows + 1;
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        pageBean.setTotalCount(totalCount);

        //调用dao中List集合
        //计算开始的索引
        int start = (currentPage - 1) * rows;
        List<VoUserList> list = userDao.findByPage(start,rows);
        pageBean.setList(list);

        //计算总页码
        // int totalPage = (totalCount % rows) == 0 ? totalCount/rows : totalCount/rows + 1;

        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);


        return pageBean;
    }*/

    @Override
    public void adkForLeave(Qingjia qingjia) throws SQLException {
        userDao.adkForLeave(qingjia);
    }

    @Override
    public List<Qingjia> findOneQingjia(String name) throws SQLException {
        return userDao.findOneQingjia(name);
    }

    @Override
    public List<Qingjia> listAllQingjia() throws SQLException {
        return userDao.listAllQingjia();
    }

    @Override
    public void deleteQjById(int id) throws SQLException {
       userDao.deleteQjById(id);
    }

    @Override
    public Qingjia findOneQjById(int id) throws SQLException {
        return userDao.findOneQjById(id);
    }

    @Override
    public void modifyOneQjById(Qingjia qingjia, int id) throws SQLException {
        userDao.modifyOneQjById(qingjia,id);
    }

    @Override
    public int signCount() throws SQLException {
        return userDao.signCount();
    }

    @Override
    public int signCountByDate(String  date) throws SQLException {
        return userDao.signCountByDate(date);
    }

    @Override
    public Sign signInfoByDate(String name,String date) throws SQLException {
        return userDao.signInfoByDate(name,date);
    }

    @Override
    public void addSignByName(String name) throws SQLException {
        userDao.addSignByName(name);
    }

    @Override
    public List<Sign> findOneAllSigns(String name) throws SQLException {
        return userDao.findOneAllSigns(name);
    }

    @Override
    public void deleteOneSignById(int id) throws SQLException {
        userDao.deleteOneSignById(id);
    }

    @Override
    public void modifyUserBySelf(User user) throws SQLException {
        userDao.modifyUserBySelf(user);
    }

    @Override
    public Applicant findAppByName(String name) throws SQLException {
        return userDao.findAppByName(name);
    }
}
