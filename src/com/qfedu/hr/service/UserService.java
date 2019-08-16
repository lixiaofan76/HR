package com.qfedu.hr.service;

import com.qfedu.hr.pojo.*;
import com.qfedu.hr.vo.VoUserList;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    11:20
 */
public interface UserService {

    /**
     * 实现用户登录
     */
    public User login(String userName,String password);

    /**
     * 实现应聘者登录
     * @param name
     * @param tel
     * @return
     */
    public Applicant applicantLog(String name,String tel) throws SQLException;

    /**
     * 查询所用用户
     * @return List<User>   返回User类的List集合
     */
    public List<VoUserList> ListInfo();

    /**
     * 删除指定id的用户
     * @param id
     */
    public void deleteById(int id);

    /**
     * 查询指定id用户信息
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     * 通过id查询应聘者信息
     * @param id
     * @return
     */
    public Applicant findByApplicantId(int id) throws SQLException;

    /**
     * 修改用户信息
     * @return
     */
    public int modifyUserInfo(User user) throws SQLException;

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user) throws SQLException;

    /**
     * 应聘者注册
     * @param applicant
     */
    public void applicantRegister(Applicant applicant) throws SQLException;

    /**
     * 注册功能
     * @param user
     */
    public void register(User user) throws SQLException;

    /**
     * 批量删除用户
     * @param uids
     */
    void deleteSelected(String[] uids);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    /*PageBean<VoUserList> findUserByPage(String currentPage, String rows) throws SQLException;*/
    PageBean<VoUserList> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) throws SQLException;

    /**
     * 添加请假信息
     * @param qingjia
     */
    public void adkForLeave(Qingjia qingjia) throws SQLException;

    /**
     * 根据id查询请假信息
     * @param name
     * @return
     */
    public List<Qingjia> findOneQingjia(String name) throws SQLException;

    /**
     * 查看所有请假信息
     * @return
     */
    public List<Qingjia> listAllQingjia() throws SQLException;

    /**
     * 根据id删除请假信息
     * @param id
     */
    public void deleteQjById(int id) throws SQLException;

    /**
     * 根据id查询用户请假信息
     * @param id
     * @return
     */
    public Qingjia findOneQjById(int id) throws SQLException;

    /**
     * 根据id和Qingjia对象修改用户请假内容
     * @param qingjia
     * @param id
     */
    public void modifyOneQjById(Qingjia qingjia,int id) throws SQLException;

    /**
     * 查询签到总记录数
     * @return
     */
    public int signCount() throws SQLException;

    /**
     * 根据时间查询签到总记录数
     * @param date
     * @return
     */
    public int signCountByDate(String date) throws SQLException;

    /**
     * 根据时间查询签到信息
     * @param date
     * @return
     */
    public Sign signInfoByDate(String name,String date) throws SQLException;

    /**
     * 根据姓名添加签到信息
     * @param name
     */
    public void addSignByName(String name) throws SQLException;


    /**
     * 查询一个用户的所有打卡记录
     * @param name
     * @return
     * @throws SQLException
     */
    public List<Sign> findOneAllSigns(String name) throws SQLException;

    /**
     * 根据id删除打卡信息
     * @param id
     */
    public void deleteOneSignById(int id) throws SQLException;

    /**
     * 自己修改信息
     * @param user
     */
    public void modifyUserBySelf(User user) throws SQLException;

    /**
     * 根据姓名查找应聘者信息
     * @param name
     * @return
     */
    public Applicant findAppByName(String name) throws SQLException;
}
