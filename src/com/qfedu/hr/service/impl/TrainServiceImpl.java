package com.qfedu.hr.service.impl;

import com.qfedu.hr.dao.TrainDao;
import com.qfedu.hr.dao.impl.TrainDaoImpl;
import com.qfedu.hr.pojo.Train;
import com.qfedu.hr.service.TrainService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    9:38
 */
public class TrainServiceImpl implements TrainService {
    private static TrainDao trainDao = new TrainDaoImpl();
    @Override
    public void addTrain(Train train) throws SQLException {
        trainDao.addTrain(train);

    }

    @Override
    public Train findTrainById(int id) throws SQLException {
        return trainDao.findTrainById(id);
    }

    @Override
    public List<Train> listAllTrainInfo() throws SQLException {
        return trainDao.listAllTrainInfo();
    }

    @Override
    public void deleteByTrainId(int id) throws SQLException {
        trainDao.deleteByTrainId(id);
    }


}
