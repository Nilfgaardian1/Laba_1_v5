package model;

public class Convector
{
    private double USD;
    private double UER;

    public Convector() {
        USD = 100;
        UER = 120;
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
