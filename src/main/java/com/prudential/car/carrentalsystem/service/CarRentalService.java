package com.prudential.car.carrentalsystem.service;

import com.prudential.car.carrentalsystem.exception.CarRentalException;
import com.prudential.car.carrentalsystem.exception.ErrorCode;
import com.prudential.car.carrentalsystem.model.AbstractCar;
import org.springframework.stereotype.Service;

@Service
public class CarRentalService
{

    /**
     * 租车
     * @param carType 车的类型
     * @param rentDays 租的天数
     * @param rentNums 车的数量
     * @param maxCouldPayFee 当前可用于支付的最大金额
     * @return
     *  true:租车成功
     *  false:租车失败 由于金额不够
     */
    public Boolean rentCar(String carType, int rentDays, int rentNums, int maxCouldPayFee) throws CarRentalException
    {
        if (rentDays <= 0)
        {
            throw new CarRentalException(ErrorCode.CarRentDaysError, "Illegal Car Rent Days,Please input correct days.");
        }

        if (rentNums <= 0)
        {
            throw new CarRentalException(ErrorCode.CarRentNumbersError, "Illegal Car Rent Numbers,Please input correct numbers.");
        }

        AbstractCar car = CarRentFactory.createCarRentalModel(carType, rentNums);
        int singleCarRentFee = car.calRent(rentDays);
        int allCarRentFee = rentNums * singleCarRentFee;
        if (maxCouldPayFee < allCarRentFee)
        {
            //租车费用不足
            throw new CarRentalException(ErrorCode.LackOfBalanceException, "Lack of balance,Please select a new scheme.");
        }

        return true;
    }
}
