package com.prudential.car.carrentalsystem.model;

/**
 * Toyota Camry 2
 */
public class ToyotaCamryCar extends AbstractCar
{
    private static final int singlePrice = 100;//一辆车单天的价格

    public ToyotaCamryCar()
    {
        super(CarType.ToyotaCamry);
    }

    @Override
    public int calRent(int rentDays)
    {
        return singlePrice * rentDays;
    }
}
