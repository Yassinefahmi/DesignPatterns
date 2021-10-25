package nl.designpattern.abstractFactory.material;

import nl.designpattern.abstractFactory.TextBox;

public class MaterialTextBox implements TextBox
{
    @Override
    public void render()
    {
        System.out.println("Material TextBox");
    }
}
