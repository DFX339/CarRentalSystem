package com.prudential.car.carrentalsystem.controller;

import com.prudential.car.carrentalsystem.exception.CarRentalException;
import com.prudential.car.carrentalsystem.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/car")
@RestController
public class CarRentalController
{

    @Autowired
    private CarRentalService carRentalService;

    /**
     * 租车服务
     * @return
     */
    @PostMapping("/rental")
    public Map<String, Object> rentCar(@RequestBody Map<String, String> param)
    {
        String carType = param.get("carType"); //车的类型
        String rentDays = param.get("rentDays"); // 租的天数
        String rentNumbers = param.get("rentNumbers"); // 车的数量
        String maxCouldPayFee = param.get("maxCouldPayFee");  // 当前可用于支付的最大金额

        Map<String, Object> resultMap = new HashMap<String, Object>(9);
        try
        {
            boolean result = carRentalService.rentCar(carType, Integer.valueOf(rentDays), Integer.valueOf(rentNumbers), Integer.valueOf(maxCouldPayFee));
            resultMap.put("success", result);
            resultMap.put("code", 200);
        }
        catch (Exception e)
        {
            resultMap.put("success", "false");
            if (e instanceof CarRentalException)
            {
                resultMap.put("errorMsg",((CarRentalException) e).getErrorMsg());
            }
            else
            {
                resultMap.put("errorMsg", e.getMessage());
            }

        }
        return resultMap;
    }

    @RequestMapping("/index")
    public String rentCar()
    {
        return "Hello Prudential";
    }
}
