package com.app.ggshop.v1.mybatis.handler;

import com.app.ggshop.v1.common.enumeration.CarFilter;
import com.app.ggshop.v1.common.enumeration.FileContentType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(CarFilter.class)
public class CarFilterHandler implements TypeHandler<CarFilter> {

    @Override
    public void setParameter(PreparedStatement ps, int i, CarFilter parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public CarFilter getResult(ResultSet rs, String columnName) throws SQLException {
        return CarFilter.getCarFilter(rs.getString(columnName));
    }

    @Override
    public CarFilter getResult(ResultSet rs, int columnIndex) throws SQLException {
        return CarFilter.getCarFilter(rs.getString(columnIndex));
    }

    @Override
    public CarFilter getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return CarFilter.getCarFilter(cs.getString(columnIndex));
    }
}