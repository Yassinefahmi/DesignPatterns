package nl.designpattern.decorator;

public class CreditCard
{
    public void store(Stream stream)
    {
        stream.write("1234-1234-1234-1234");
    }
}
