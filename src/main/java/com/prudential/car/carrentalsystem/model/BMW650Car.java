package com.prudential.car.carrentalsystem.model;

/**
 * BMW 650 2
 */
public class BMW650Car extends AbstractCar
{
    private static final int singlePrice = 200;//一辆车单天的价格

    public BMW650Car()
    {
        super(CarType.BMW650);
    }

    @Override
    public int calRent(int rentDays)
    {
        return singlePrice * rentDays;
    }
}
