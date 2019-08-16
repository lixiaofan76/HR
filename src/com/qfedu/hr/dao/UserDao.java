package com.qfedu.hr.dao;

import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.pojo.Qingjia;
import com.qfedu.hr.pojo.Sign;
import com.qfedu.hr.pojo.User;
import com.qfedu.hr.vo.VoUserList;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    10:54
 */
public interface UserDao {

    /**
     * 登录功能
     */
    public User login(String userName,String password);

    /**
     * 应聘者登录
     * @param name
     * @param tel
     * @return
     */
    public Applicant applicantLog(String name,String tel) throws SQLException;

    /**
     * 查询所用用户信息
     * @return List<User>   返回User类的List集合
     */
    public List<VoUserList> ListInfo();

    /**
     * 删除指定id的用户
     * @param id
     */
    public void deleteById(int id);

    /**
     * 查询指定id的用户信息
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
     * @param user
     * @return
     */
    public int modifyUserInfo(User user) throws SQLException;

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user) throws SQLException;

    /**
     * 应聘者注册功能
     * @param applicant
     */
    public void applicantRegister(Applicant applicant) throws SQLException;

    /**
     * 实现用户注册功能
     * @param user
     */
    public void register(User user) throws SQLException;


    /**
     * 查询总记录数
     * @return
     * @param condition
     */
   /* int findTotalCount() throws SQLException;*/
    int findTotalCount(Map<String, String[]> condition) throws SQLException;

    /**
     * 查询每页中的数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    /*List<VoUserList> findByPage(int start, int rows) throws SQLException;*/
    List<VoUserList> findByPage(int start, int rows, Map<String, String[]> condition) throws SQLException;

    /**
     * 添加请假内容
     * @param qingjia
     */
    public void adkForLeave(Qingjia qingjia) throws SQLException;

    /**
     * 根据id查看请假信息
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
     * 通过id和Qingjia对象实现修改请假信息
     * @param qingjia
     * @param id
     */
    public void modifyOneQjById(Qingjia qingjia,int id) throws SQLException;


    /**
     * 查询打卡总记录数
     * @return
     */
    public int signCount() throws SQLException;

    /**
     * 根据时间查询总记录数
     * @param date
     * @return
     */
    public int signCountByDate(String date) throws SQLException;

    /**
     * 根据时间查询打卡信息
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
     * 根据name查询该用户的打卡记录信息
     * @param name
     * @return
     */
    public List<Sign> findOneAllSigns(String name) throws SQLException;

    /**
     * 根据id删除指定打卡记录
     * @param id
     */
    public void deleteOneSignById(int id) throws SQLException;

    /**
     * 自己修改信息
     * @param user
     */
    public void modifyUserBySelf(User user) throws SQLException;

    /**
     * 根据名字查找应聘者信息
     * @param name
     * @return
     */
    public Applicant findAppByName(String name) throws SQLException;


}
