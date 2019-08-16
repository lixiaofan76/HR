package com.qfedu.hr.utils;

import com.qfedu.hr.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * 基于元数据，BeanUtils还有反射思想，完成的一个统一的 Query和 Update方法
 * Update方法用于处理针对于数据库修改的方法
 * insert，update，delete，create，drop
 * <p>
 * Query方法用于处理查询语句
 * select
 *
 * @author Anonymous
 */
public class BaseDao {

    /**
     * 统一的修改方法，用于处理 insert，update，delete，create，drop等SQL语句
     *
     * @param sql        需要执行的 SQL语句
     * @param parameters 对应 SQL 语句的参数数组，为 Object类型
     * @return 返回当前SQL语句执行 数据库受影响行数 rows affected
     * @throws SQLException SQL语句为 null
     */
    public int update(String sql, Object[] parameters) throws SQLException {
        if (null == sql) {
            throw new SQLException("SQL is null");
        }

        // 1. 获取数据库连接
        Connection connection = JdbcUtil.getConnection();

        // 2. 获取DBUtils核心类对象 QueryRunner
        QueryRunner queryRunner = JdbcUtil.getQueryRunner();

        // 3. 执行语句
        int i = queryRunner.update(connection, sql, parameters);

        // 4. 关闭资源
        JdbcUtil.close(connection);

        // 5. 返回受影响行数
        return i;
    }

    /**
     * 通用的查询数据库的方法，可以查询指定的任意类对象类型
     *
     * @param sql        指定的SQL语句，这里需要的是 select语句 DQL语句
     * @param parameters 对应 SQL语句的参数数组
     * @param cls        当前查询指定类对象类型的 Class类对象
     * @param <T>        当前方法中使用的泛型
     * @return 返回包含指定类对象类型的 List集合，没有任何有效元素，返回 null
     * @throws SQLException SQL异常
     */
    public <T> List<T> query(String sql, Object[] parameters, Class<T> cls)
            throws SQLException {
        if (null == sql || null == cls) {
            throw new NullPointerException();
        }
        // 1. 获取数据库连接对象
        Connection connection = JdbcUtil.getConnection();

        // 2. 获取QueryRunner类对象
        QueryRunner queryRunner = JdbcUtil.getQueryRunner();

        /*
         3. 执行SQL语句
         QueryRunner 如果处理方式是BeanListHandler 那么返回的数据类型是List集合对象，不会返回null，没有数据返回空list
        */
        List<T> query = queryRunner.query(connection, sql, new BeanListHandler<T>(cls), parameters);

        // 15. 如果 List集合中的有效元素个数为 0 ，返回 null，其他返回 List对象
        return query.size() > 0 ? query : null;
    }

    public List<Object[]> query(String sql,  Object[] parameters) throws SQLException {
        if (null == sql) {
            throw new NullPointerException();
        }
        // 1. 获取数据库连接对象
        Connection connection = JdbcUtil.getConnection();

        // 2. 获取QueryRunner类对象
        QueryRunner queryRunner = JdbcUtil.getQueryRunner();

        /*
         3. 执行SQL语句
         QueryRunner 如果处理方式是BeanListHandler 那么返回的数据类型是List集合对象，不会返回null，没有数据返回空list
        */
        List<Object[]> query = queryRunner.query(connection, sql, new ArrayListHandler());

        // 15. 如果 List集合中的有效元素个数为 0 ，返回 null，其他返回 List对象
        return query.size() > 0 ? query : null;
    }






}
