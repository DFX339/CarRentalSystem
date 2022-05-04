package com.prudential.car.carrentalsystem.model;

public abstract class AbstractCar
{
    private CarType carType; //类型 ToyotaCamry or BMW650

    public AbstractCar(){}

    public AbstractCar(CarType carType)
    {
        this.carType = carType;
    }

    /**
     * 计算租车费用
     * @param rentDays 租车的天数
     * @return
     */
    public abstract int calRent(int rentDays);
}
