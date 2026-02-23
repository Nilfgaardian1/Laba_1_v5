package model;

public class Convector
{
    private double USD;
    private double UER;

    public double getUSD() {
        return USD;
    }

    public double getUER() {
        return UER;
    }

    public void setUSD(double USD)
    {
        this.USD = USD;
    }

    public void setUER(double UER)
    {
        this.UER = UER;
    }

    public double ConvectorUSD(double rus)
    {
        return rus /= USD;
    }

    public double ConvectorUER(double rus)
    {
        return rus /= UER;
    }
}