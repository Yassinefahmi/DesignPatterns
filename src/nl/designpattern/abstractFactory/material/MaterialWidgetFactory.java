package nl.designpattern.abstractFactory.material;

import nl.designpattern.abstractFactory.Button;
import nl.designpattern.abstractFactory.TextBox;
import nl.designpattern.abstractFactory.WidgetFactory;

public class MaterialWidgetFactory implements WidgetFactory
{
    @Override
    public Button createButton()
    {
        return new MaterialButton();
    }

    @Override
    public TextBox createTextBox()
    {
        return new MaterialTextBox();
    }
}