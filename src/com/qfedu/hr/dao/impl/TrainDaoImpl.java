package com.qfedu.hr.dao.impl;

import com.qfedu.hr.dao.TrainDao;
import com.qfedu.hr.pojo.Train;
import com.qfedu.hr.utils.BaseDao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    9:29
 */
public class TrainDaoImpl extends BaseDao implements TrainDao {

    @Override
    public void addTrain(Train train) throws SQLException {
        String sql = "insert into hr.train values(?,?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String begin = format.format(train.getBeginTime());
        String end = format.format(train.getEndTime());
        String create = format.format(train.getCreateTime());

        Object[] parameters = {null,train.getName(),train.getPurpose(),begin,end,train.getDatum(),train.getTeacher(),
            train.getStudentId(),create,train.isEducate(),train.getEffect(),train.getSummarize()};

        super.update(sql,parameters);

    }

    @Override
    public Train findTrainById(int id) throws SQLException {
        String sql = "select * from hr.train where id=?";
        Object[] parameter = {id};
        List<Train> query = super.query(sql, parameter, Train.class);
        return query != null ? query.get(0) : null;
    }

    @Override
    public List<Train> listAllTrainInfo() throws SQLException {
        String sql = "select * from hr.train";
        List<Train> query = super.query(sql, null, Train.class);


        return query;
    }

    @Override
    public void deleteByTrainId(int id) throws SQLException {
        String sql = "delete from hr.train where id=?";
        Object[] parameter = {id};
        super.update(sql,parameter);
    }
}
