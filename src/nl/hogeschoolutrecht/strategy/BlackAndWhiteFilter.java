package nl.hogeschoolutrecht.strategy;

public class BlackAndWhiteFilter implements Filter
{
    @Override
    public void apply(String fileName)
    {
        System.out.println("Applying Black and White filter on " + fileName);
    }
}
