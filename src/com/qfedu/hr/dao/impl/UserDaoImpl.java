package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.UserDao;
import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.pojo.Qingjia;
import com.qfedu.hr.pojo.Sign;
import com.qfedu.hr.pojo.User;
import com.qfedu.hr.utils.BaseDao;
import com.qfedu.hr.utils.JDBCUtils;
import com.qfedu.hr.vo.VoUserList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    10:57
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 实现用户登录功能
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User login(String userName,String password) {
        String sql = "select * from hr.user where userName=? and password=?";
        List<User> query = null;
        Object[] parameters ={userName,password};
        try {
           query = super.query(sql, parameters, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return query != null ? query.get(0):null;
    }

    /**
     * 实现应聘者登录功能
     * @param name
     * @param tel
     * @return
     * @throws SQLException
     */
    @Override
    public Applicant applicantLog(String name, String tel) throws SQLException {
        String sql = "select * from hr.applicant where name=? and tel=?";
        Object[] parameters = {name,tel};

        List<Applicant> query = super.query(sql, parameters, Applicant.class);
        return query != null ? query.get(0):null;
    }

    /**
     * 查询所有用户的信息
     * @return
     */
    @Override
    public List<VoUserList> ListInfo() {
        String sql = "select u.*,o.roleName from user u inner join role_to_privilege r on u.roleId=r.roleId inner join role o on r.privilegeId=o.id";

        List<VoUserList> query = null;

        try {
             query = super.query(sql, null, VoUserList.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * 根据指定id删除用户
     * @param id
     */
    @Override
    public void deleteById(int id) {
        String sql = "delete from hr.user where id=?";
        Object[] parameter = {id};

        try {
            int update = super.update(sql, parameter);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 查找指定id的用户信息
     * @param id
     * @return
     */
    @Override
    public User findById(int id) {
        String sql = "select * from hr.user where id=?";
        Object[] parameter = {id};
        List<User> query = null;
        try {
            query = super.query(sql, parameter, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query != null ? query.get(0):null;
    }

    /**
     * 查找指定id的应聘者信息
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Applicant findByApplicantId(int id) throws SQLException {
        String sql = "select * from hr.applicant where id=?";
        Object[] parameter = {id};

        List<Applicant> query = super.query(sql, parameter, Applicant.class);

        return query != null ? query.get(0) : null;
    }

    /**
     * 修改指定id的用户信息
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int modifyUserInfo(User user) throws SQLException {
        String sql = "update hr.user set userName=?,gender=?,birthday=?,createTime=?,content=?,roleId=?,imgPath=? where id=?";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String birthday = format.format(user.getBirthday());
         String createTime = format.format(user.getCreateTime());

        Object[] parameters = {user.getUserName(),user.isGender(),birthday,createTime,user.getContent(),user.getRoleId(),user.getImgPath(),user.getId()};

        return super.update(sql, parameters);
        }

    /**
     * 管理员添加用户信息
      * @param user
     * @throws SQLException
     */
    @Override
    public void addUser(User user) throws SQLException {
        String sql = "insert into user(userName, password, gender, birthday, createTime, content,roleId) values (?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthday = format.format(user.getBirthday());
        String createTine = format.format(user.getCreateTime());

        Object[] parameters = {user.getUserName(), user.getPassword(), user.isGender(), birthday, createTine, user.getContent(), 0};
         super.update(sql,parameters);
    }

    /**
     * 实现应聘者注册功能
     * @param applicant
     * @throws SQLException
     */
    @Override
    public void applicantRegister(Applicant applicant) throws SQLException {
        String sql = "insert into applicant values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = format.format(applicant.getCreateTime());

        Object[] parameters = {null,applicant.getName(),applicant.isGender(),applicant.getAge(),applicant.getJob(),
            applicant.getSpecialty(),applicant.getExperience(),applicant.getStudyEffort(),applicant.getSchool(),
            applicant.getTel(),applicant.getEmail(),createTime,applicant.getContent(),0};

        super.update(sql,parameters);
    }

    /**
     * 实现user注册功能
     * @param user
     * @throws SQLException
     */
    @Override
    public void register(User user) throws SQLException {
        String sql = "insert into user(userName, password, gender, birthday, createTime, content,roleId) values (?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthday = format.format(user.getBirthday());
        String createTine = format.format(user.getCreateTime());

        Object[] parameters = {user.getUserName(), user.getPassword(), user.isGender(), birthday, createTine, user.getContent(),user.getRoleId()};

        super.update(sql,parameters);

    }

    /**
     * 查询总记录数
     * @return
     * @throws SQLException
     * @param condition
     */
   /* @Override
    public int findTotalCount() throws SQLException {
        String sql = "select count(*) from hr.user ";
        Integer integer = template.queryForObject(sql, Integer.class);
        return integer;
        // return query != null ? query.size() : null  ;

    }*/

    @Override
    public int findTotalCount(Map<String, String[]> condition) throws SQLException {
        //定义模板初始化sql

        String sql = "select count(*) from hr.user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页的条件
            if ("currentPage".equals(key) || "rows".equals(key) || "method".equals(key)) {
                continue;
            }

            String value = condition.get(key)[0];
        //    判断value是否有值
            if (value != null || !"".equals(value)) {
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//添加参数的值
            }

        }
        System.out.println(sb.toString());
        System.out.println(params);

        Integer integer = null;
        try {
            integer = template.queryForObject(sb.toString(),Integer.class, params.toArray());
        } catch (DataAccessException e) {
            System.out.println("error");
        }
        return integer;

        // return query != null ? query.size() : null  ;
    }


    /**
     * 查询每页的数据信息
     * @param start
     * @param rows
     * @param condition
     * @return
     * @throws SQLException
     */
   /* @Override
    public List<VoUserList> findByPage(int start, int rows) throws SQLException {
        String sql = "select u.*,o.roleName from user u inner join role_to_privilege r on u.roleId=r.roleId inner join role o on r.privilegeId=o.id limit ? , ?";
        Object[] parameters  = {start,rows};
        List<VoUserList> users = super.query(sql, parameters, VoUserList.class);
        return users;
    }*/

    @Override
    public List<VoUserList> findByPage(int start, int rows, Map<String, String[]> condition) throws SQLException {
        String sql = "select u.*,o.roleName from user u inner join role_to_privilege r on u.roleId=r.roleId inner join role o on r.privilegeId=o.id where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页的条件
            if ("currentPage".equals(key) || "rows".equals(key) || "method".equals(key)) {
                continue;
            }

            String value = condition.get(key)[0];
            //    判断value是否有值
            if (value != null || !"".equals(value)) {
                sb.append(" and "+key+" like BINARY ? ");
                params.add("%"+value+"%");//添加参数的值
            }

        }
        //添加分页
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        // Object[] parameters  = {start,rows};
        List<VoUserList> users = super.query(sb.toString(), params.toArray(), VoUserList.class);
        return users;
    }

    @Override
    public void adkForLeave(Qingjia qingjia) throws SQLException {
        String sql = "insert into hr.qingjia values (?,?,?,?,?,?,?)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(qingjia.getCreateTime());
        Object[] parameters = {null,qingjia.getUserName(),qingjia.getTotalDay(),qingjia.getContent(),
            "待审核",0,createTime};
        super.update(sql,parameters);
    }

    @Override
    public List<Qingjia> findOneQingjia(String name) throws SQLException {
        String sql = "select * from hr.qingjia where userName=?";
        Object[] parameter = {name};
        List<Qingjia> query = super.query(sql, parameter, Qingjia.class);
        return query;
    }

    @Override
    public List<Qingjia> listAllQingjia() throws SQLException {
        String sql = "select * from hr.qingjia";
        List<Qingjia> qingjias = super.query(sql, null, Qingjia.class);
        return qingjias;
    }

    @Override
    public void deleteQjById(int id) throws SQLException {
        String sql = "delete from hr.qingjia where id=?";
        Object[] parameter = {id};
        super.update(sql,parameter);
    }

    @Override
    public Qingjia findOneQjById(int id) throws SQLException {
        String sql = "select * from hr.qingjia where id=?";
        Object[] parameter = {id};
        List<Qingjia> qingjias = super.query(sql, parameter, Qingjia.class);

        return qingjias != null ? qingjias.get(0) : null;
    }

    @Override
    public void modifyOneQjById(Qingjia qingjia, int id) throws SQLException {
        String sql = "update hr.qingjia set approval =?,cancel=? where id=?";
        Object[] parameters = {qingjia.getApproval(),qingjia.getCancel(),id};
        super.update(sql,parameters);
    }

    @Override
    public int signCount() throws SQLException {
        String sql = "select count(1) from hr.sign";
        // List<Integer> query = super.query(sql, null, Integer.class);
        Integer integer = template.queryForObject(sql, Integer.class, null);
        return integer;
    }

    @Override
    public int signCountByDate(String date) throws SQLException {
        String sql = "select count(1) from hr.sign where signTime=?";
        Object[] parameter = {date};
        // List<Integer> query = super.query(sql, parameter, Integer.class);
        Integer integer = template.queryForObject(sql, Integer.class, parameter);
        return integer;
    }

    @Override
    public Sign signInfoByDate(String name,String date) throws SQLException {
        String sql = "select * from hr.sign where userName=? and Date(signTime) = ?";
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());*/
        Object[] parameter = {name,date};
        List<Sign> signs = super.query(sql,parameter,Sign.class);
        return signs != null ? signs.get(0) : null;
    }

    @Override
    public void addSignByName(String name) throws SQLException {
        String sql = "insert into hr.sign values(?,?,?,?)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        Object[] parameters = {null,name,date,1};
        super.update(sql,parameters);
    }

    @Override
    public List<Sign> findOneAllSigns(String name) throws SQLException {
        String sql = "select * from hr.sign where userName = ?";
        Object[] parameter = {name};
        List<Sign> signs = super.query(sql, parameter, Sign.class);
        return signs;
    }

    @Override
    public void deleteOneSignById(int id) throws SQLException {
        String sql = "delete from hr.sign where id=?";
        Object[] parameter = {id};
        super.update(sql,parameter);
    }

    @Override
    public void modifyUserBySelf(User user) throws SQLException {
        String sql = "update hr.user set userName=?,gender=?,birthday=?,createTime=?,content=?,imgPath=? where id=?";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthday = format.format(user.getBirthday());
        String createTime = format.format(user.getCreateTime());

        Object[] parameters = {user.getUserName(),user.isGender(),birthday,createTime,user.getContent(),user.getImgPath(),user.getId()};

       super.update(sql, parameters);

    }

    @Override
    public Applicant findAppByName(String name) throws SQLException {
        String sql = "select * from hr.applicant where name=?";
        Object[] parameter = {name};
        List<Applicant> applicants = super.query(sql, parameter, Applicant.class);
        return applicants != null ? applicants.get(0) : null;
    }


}
