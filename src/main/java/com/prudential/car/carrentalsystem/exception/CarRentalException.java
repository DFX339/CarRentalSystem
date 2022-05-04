package com.prudential.car.carrentalsystem.exception;

public class CarRentalException extends Exception
{
    private int errorCode;
    private String errorMsg;

    public CarRentalException(int errorCode, String errorMsg)
    {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CarRentalException(int errorCode, String errorMsg, Throwable e)
    {
        super(e);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
}
