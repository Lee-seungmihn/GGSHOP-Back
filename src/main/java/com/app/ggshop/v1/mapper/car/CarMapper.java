package com.app.ggshop.v1.mapper.car;


import com.app.ggshop.v1.domain.CarVO;
import com.app.ggshop.v1.dto.car.CarDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {

    public void insertCar(CarVO carVO);

    public void deleteCar(Long id);

    public CarDTO selectCarByMemberId(Long memberId);
}

