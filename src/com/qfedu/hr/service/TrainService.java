package com.qfedu.hr.service;

import com.qfedu.hr.pojo.Train;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-06
 * Time:    9:37
 */
public interface TrainService {

    /**
     * 添加培训信息
     * @param train
     */
    public void addTrain(Train train) throws SQLException;

    /**
     * 根据id查询培训信息
     * @param id
     * @return
     */
    public Train findTrainById(int id) throws SQLException;

    /**
     * 查询所有培训信息
     * @return
     */
    public List<Train> listAllTrainInfo() throws SQLException;

    /**
     * 根据id删除培训信息
     * @param id
     * @throws SQLException
     */
    public void deleteByTrainId(int id) throws SQLException;
}
