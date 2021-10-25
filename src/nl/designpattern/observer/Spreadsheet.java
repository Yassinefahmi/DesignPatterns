package nl.designpattern.observer;

public class Spreadsheet implements Observer
{
    private final DataSource dataSource;

    public Spreadsheet(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public void update()
    {
        System.out.println("Spreadsheet got notified: " + dataSource.getValue());
    }
}
