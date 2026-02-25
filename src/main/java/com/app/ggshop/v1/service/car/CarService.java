package com.app.ggshop.v1.service.car;

import com.app.ggshop.v1.domain.CarVO;
import com.app.ggshop.v1.dto.car.CarDTO;
import com.app.ggshop.v1.repository.car.CarDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CarService {
    private final CarDAO carDAO;
//  차량
//    조회
    public CarDTO getCar(Long id) {return carDAO.findId(id);}
//    등록
    public void registerCar(CarVO carVO) {carDAO.insert(carVO);}
//    삭제
    public void deleteCar(Long id) {carDAO.delete(id);}
}
