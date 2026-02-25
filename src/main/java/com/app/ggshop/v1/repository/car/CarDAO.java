package com.app.ggshop.v1.repository.car;

import com.app.ggshop.v1.domain.CarVO;
import com.app.ggshop.v1.dto.car.CarDTO;
import com.app.ggshop.v1.mapper.car.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class CarDAO {

    private final CarMapper carMapper;
//    추가
    public void insert(CarVO carVO) {carMapper.insertCar(carVO);}
//    삭제
    public void delete(Long id) {carMapper.deleteCar(id);}
//    조회
    public CarDTO findId(Long id) {return carMapper.selectCarByMemberId(id);}
}
