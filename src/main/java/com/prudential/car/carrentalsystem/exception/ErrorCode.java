package com.prudential.car.carrentalsystem.exception;

public class ErrorCode
{
    private static final int prefix = 100000;

    public static final int CarTypeNotFoundException = prefix + 1;//当前选择的车类型不存在
    public static final int CarNumbersNotEnoughException = prefix + 2;//剩余车的数量不够
    public static final int CarRentDaysError = prefix + 3; //租车天数有误
    public static final int CarRentNumbersError = prefix + 4; //租车数量有误
    public static final int LackOfBalanceException = prefix + 5; //余额不足
}
