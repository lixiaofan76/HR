package com.qfedu.hr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

/**
 * 使用C3P0连接池对象的 JdbcUtil 工具类
 * 1. 自动完成驱动的加载
 * 2. 自动完成必要数据的处理
 * 3. 简化 getConnection方法，提供给开发者使用
 * 4. 完成统一 close方法
 */
public class JdbcUtil {

    private static QueryRunner qr = null;
    /**
     * C3P0连接池对象，加载默认的配置文件，配置文件名字为固定的c3p0-config.xml
     * 存放位置是src目录下
     */
    private static ComboPooledDataSource pool = new ComboPooledDataSource();

    /**
     * 利用单例的思想，完成一个核心工具类对象 QueryRunner的获取和创建
     *
     * @return QueryRunner DBUtils中的核心类型
     */
    public static QueryRunner getQueryRunner() {
        synchronized (JdbcUtil.class) {
           if (null == qr) {
               qr = new QueryRunner();
           }
        }

        return qr;
    }

    /**
     * 简化数据库连接对象java.sql.Connection的获取方式，static修饰的静态成员方法
     * 直接通过类名调用
     *
     * @return java.sql.Connection Java连接数据库的对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关数据库连接对象
     *
     * @param connection 传入的是一个java.sql.Connection 数据库连接对象
     */
    public static void close(Connection connection) {
        close(connection, null, null);
    }

    /**
     * 关闭数据库连接对象和Statement SQL语句搬运工对象
     *
     * @param connection java.sql.Connection 数据库连接对象
     * @param statement  java.sql.Statement SQL搬运工对象
     */
    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    /**
     * 关闭数据库连接对象，Statement SQL语句搬运工对象和ResultSet结果集对象
     *
     * @param connection java.sql.Connection 数据库连接对象
     * @param statement  java.sql.Statement SQL搬运工对象
     * @param resultSet  java.sql.ResultSet 数据库查询结果集对象
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
