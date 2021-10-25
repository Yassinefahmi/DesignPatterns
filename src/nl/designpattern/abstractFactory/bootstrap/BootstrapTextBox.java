package nl.designpattern.abstractFactory.bootstrap;

import nl.designpattern.abstractFactory.TextBox;

public class BootstrapTextBox implements TextBox
{
    @Override
    public void render()
    {
        System.out.println("Bootstrap TextBox");
    }
}
