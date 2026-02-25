package com.app.ggshop.v1.mybatis.handler;

import com.app.ggshop.v1.common.enumeration.AlarmStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(AlarmStatus.class)
public class AlarmStatusHandler implements TypeHandler<AlarmStatus> {

    @Override
    public void setParameter(PreparedStatement ps, int i, AlarmStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public AlarmStatus getResult(ResultSet rs, String columnName) throws SQLException {
        switch (rs.getString(columnName)) {
            case "read":
                return AlarmStatus.READ;
            case "unread":
                return AlarmStatus.UNREAD;
        }
        return null;
    }

    @Override
    public AlarmStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        switch (rs.getString(columnIndex)) {
            case "read":
                return AlarmStatus.READ;
            case "unread":
                return AlarmStatus.UNREAD;
        }
        return null;
    }

    @Override
    public AlarmStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        switch (cs.getString(columnIndex)) {
            case "read":
                return AlarmStatus.READ;
            case "unread":
                return AlarmStatus.UNREAD;
        }
        return null;
    }
}
