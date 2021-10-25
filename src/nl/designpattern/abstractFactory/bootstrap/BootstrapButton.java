package nl.designpattern.abstractFactory.bootstrap;

import nl.designpattern.abstractFactory.Button;

public class BootstrapButton implements Button
{
    @Override
    public void render()
    {
        System.out.println("Bootstrap Button");
    }
}
