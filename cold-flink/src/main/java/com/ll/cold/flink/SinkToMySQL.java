package com.ll.cold.flink;

import com.ll.cold.common.netty.entity.MessageEntity;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SinkToMySQL extends RichSinkFunction<MessageEntity> {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private String userName = "root";
    private String password = "root";
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String DBUrl = "jdbc:mysql://192.168.56.101:3306/cold_admin?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
    private StringBuffer sql = new StringBuffer();

    public SinkToMySQL() {
        this.getSQL();
    }

    /**
     * @param parameters
     * @throws Exception
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        Class.forName(driverName);
        connection = DriverManager.getConnection(DBUrl, userName, password);
        preparedStatement = connection.prepareStatement(sql.toString());
        super.open(parameters);
    }

    /**
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        super.close();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        super.close();
    }

    /**
     * @param value
     * @param context
     */
    @Override
    public void invoke(MessageEntity value, Context context) {
        try {
            this.setStatement(value);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private void getSQL() {
        sql.append("replace into cz_message_realtime(");
        sql.append("meterCode, meterId, meterName, ");
        sql.append("hostId, hostCode, hostName, ");
        sql.append("houseId, houseCode, houseName, ");
        sql.append("companyId, companyName, ");
        sql.append("tem, maxTem, minTem, ");
        sql.append("hum, maxHum, minHum, ");
        sql.append("temAlert, humAlert, state, ");
        sql.append("lon, lat, curtime) ");
        sql.append("values(");
        sql.append("?, ?, ?, ");
        sql.append("?, ?, ?, ");
        sql.append("?, ?, ?, ");
        sql.append("?, ?, ");
        sql.append("?, ?, ?, ");
        sql.append("?, ?, ?, ");
        sql.append("?, ?, ?, ");
        sql.append("?, ?, ?)");
    }

    /**
     * @param value
     * @throws Exception
     */
    private void setStatement(MessageEntity value) throws Exception {
        preparedStatement.setString(1, value.getMetercode());
        preparedStatement.setString(2, value.getMeterid());
        preparedStatement.setString(3, value.getMetername());
        preparedStatement.setString(4, value.getHostid());
        preparedStatement.setString(5, value.getHostcode());
        preparedStatement.setString(6, value.getHostname());
        preparedStatement.setString(7, value.getHouseid());
        preparedStatement.setString(8, value.getHousecode());
        preparedStatement.setString(9, value.getHousename());
        preparedStatement.setString(10, value.getCompanyid());
        preparedStatement.setString(11, value.getCompanyname());

        preparedStatement.setInt(12, value.getTem());
        preparedStatement.setInt(13, value.getMaxtem());
        preparedStatement.setInt(14, value.getMintem());
        preparedStatement.setInt(15, value.getHum());
        preparedStatement.setInt(16, value.getMaxhum());
        preparedStatement.setInt(17, value.getMinhum());

        preparedStatement.setInt(18, value.getTemalert());
        preparedStatement.setInt(19, value.getHumalert());
        preparedStatement.setInt(20, value.getState());
        preparedStatement.setString(21, value.getLon());
        preparedStatement.setString(22, value.getLat());
        preparedStatement.setString(23, value.getCurtime());
//      preparedStatement.toString();
    }
}
