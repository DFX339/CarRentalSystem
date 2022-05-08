package com.prudential.car.carrentalsystem.service;

import com.prudential.car.carrentalsystem.exception.CarRentalException;
import com.prudential.car.carrentalsystem.exception.ErrorCode;
import com.prudential.car.carrentalsystem.model.AbstractCar;
import com.prudential.car.carrentalsystem.model.BMW650Car;
import com.prudential.car.carrentalsystem.model.CarType;
import com.prudential.car.carrentalsystem.model.ToyotaCamryCar;

public class CarRentFactory
{
    // 记录剩余可出租的车辆 默认都为10辆车
    private static int leftBWMCarNumbers = 10;
    private static int leftToyotaCarNumbers = 10;

    public static AbstractCar createCarRentalModel(String carType, int rentNums) throws CarRentalException
    {

        if (carType == null)
        {
            throw new CarRentalException(ErrorCode.CarTypeNotFoundException, "Car type is not found,Please choose correct type.");
        }

        if (CarType.BMW650.name().equals(carType))
        {
            if (leftBWMCarNumbers - rentNums < 0)
            {
                throw new CarRentalException(ErrorCode.CarNumbersNotEnoughException, "Sorry, CarType.BMW650 left numbers is not enough, only " + leftBWMCarNumbers +",Please choose other scheme.");
            }
            leftBWMCarNumbers -= rentNums;
            return new BMW650Car();
        }
        else if (CarType.ToyotaCamry.name().equals(carType))
        {
            if (leftToyotaCarNumbers - rentNums < 0)
            {
                throw new CarRentalException(ErrorCode.CarNumbersNotEnoughException, "Sorry, CarType.ToyotaCamry left numbers is not enough, only " + leftToyotaCarNumbers +",Please choose other scheme.");
            }
            leftToyotaCarNumbers -= rentNums;
            return new ToyotaCamryCar();
        }
        else
        {
            throw new CarRentalException(ErrorCode.CarTypeNotFoundException, "Car type [" + carType + "] is not found,Please choose correct type.");
        }
    }
}
