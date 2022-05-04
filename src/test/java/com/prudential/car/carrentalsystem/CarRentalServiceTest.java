package com.prudential.car.carrentalsystem;

import com.prudential.car.carrentalsystem.exception.CarRentalException;
import com.prudential.car.carrentalsystem.exception.ErrorCode;
import com.prudential.car.carrentalsystem.model.CarType;
import com.prudential.car.carrentalsystem.service.CarRentalService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CarRentalServiceTest
{
    private CarRentalService carRentalService = new CarRentalService();

    @Test
    public void testRentBMWCar()
    {
        boolean result = false; //默认为false
        String carType = CarType.BMW650.name();
        int rentDays = 1;
        int rentNumbers = 1;
        int maxCouldPayMoney = 1000;
        try
        {
            result = carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            result = false;
        }
        assertTrue(result);
    }

    @Test
    public void testRentToyotaCamryCar()
    {
        boolean result = false; //默认为false
        String carType = CarType.ToyotaCamry.name();
        int rentDays = 1;
        int rentNumbers = 1;
        int maxCouldPayMoney = 1000;
        try
        {
            result = carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            result = false;
        }
        assertTrue(result);
    }

    @Test
    public void testRentCarErrorType()
    {
        boolean result = false; //默认为false
        String carType = "errorType";
        int rentDays = 1;
        int rentNumbers = 1;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarTypeNotFoundException)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentBWMCarNotEnoughNumbers()
    {
        boolean result = false; //默认为false
        String carType = CarType.BMW650.name();
        int rentDays = 1;
        int rentNumbers = 11;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarNumbersNotEnoughException)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentToyotaCamryCarNotEnoughNumbers()
    {
        boolean result = false; //默认为false
        String carType = CarType.ToyotaCamry.name();
        int rentDays = 1;
        int rentNumbers = 11;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarNumbersNotEnoughException)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentBWMCarRentDayError()
    {
        boolean result = false; //默认为false
        String carType = CarType.BMW650.name();
        int rentDays = -1;
        int rentNumbers = 1;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarRentDaysError)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentToyotaCamryCarRentDayError()
    {
        boolean result = false; //默认为false
        String carType = CarType.ToyotaCamry.name();
        int rentDays = -1;
        int rentNumbers = 1;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarRentDaysError)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentBWMCarRentNumbersError()
    {
        boolean result = false; //默认为false
        String carType = CarType.BMW650.name();
        int rentDays = 1;
        int rentNumbers = -1;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarRentNumbersError)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentToyotaCamryCarRentNumbersError()
    {
        boolean result = false; //默认为false
        String carType = CarType.ToyotaCamry.name();
        int rentDays = 1;
        int rentNumbers = -1;
        int maxCouldPayMoney = 1000;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.CarRentNumbersError)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentBWMCarLackOfBalance()
    {
        boolean result = false; //默认为false
        String carType = CarType.BMW650.name();
        int rentDays = 2;
        int rentNumbers = 3;
        int maxCouldPayMoney = 599;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.LackOfBalanceException)
            {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRentToyotaCamryCarLackOfBalance()
    {
        boolean result = false; //默认为false
        String carType = CarType.ToyotaCamry.name();
        int rentDays = 2;
        int rentNumbers = 3;
        int maxCouldPayMoney = 599;
        try
        {
            carRentalService.rentCar(carType, rentDays, rentNumbers, maxCouldPayMoney);
        }
        catch(CarRentalException e)
        {
            if (e.getErrorCode() == ErrorCode.LackOfBalanceException)
            {
                result = true;
            }
        }
        assertTrue(result);
    }
}
