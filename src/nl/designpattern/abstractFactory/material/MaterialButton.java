package nl.designpattern.abstractFactory.material;

import nl.designpattern.abstractFactory.Button;

public class MaterialButton implements Button
{
    @Override
    public void render()
    {
        System.out.println("Material button");
    }
}
