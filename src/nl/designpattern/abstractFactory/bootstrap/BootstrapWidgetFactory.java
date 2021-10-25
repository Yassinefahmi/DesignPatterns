package nl.designpattern.abstractFactory.bootstrap;

import nl.designpattern.abstractFactory.Button;
import nl.designpattern.abstractFactory.TextBox;
import nl.designpattern.abstractFactory.WidgetFactory;

public class BootstrapWidgetFactory implements WidgetFactory
{
    @Override
    public Button createButton()
    {
        return new BootstrapButton();
    }

    @Override
    public TextBox createTextBox()
    {
        return new BootstrapTextBox();
    }
}
