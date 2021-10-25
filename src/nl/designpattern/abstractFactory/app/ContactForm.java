package nl.designpattern.abstractFactory.app;

import nl.designpattern.abstractFactory.WidgetFactory;

public class ContactForm
{
    public void render(WidgetFactory widgetFactory)
    {
        widgetFactory.createTextBox().render();
        widgetFactory.createButton().render();
    }
}
