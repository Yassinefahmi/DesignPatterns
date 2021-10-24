package nl.hogeschoolutrecht.adapter;

import nl.hogeschoolutrecht.adapter.thirdParty.Caramel;

public class CaramelFilter implements Filter
{
    private final Caramel caramel;

    public CaramelFilter(Caramel caramel)
    {
        this.caramel = caramel;
    }

    @Override
    public void apply(Image image)
    {
        caramel.init();
        caramel.render(image);
    }
}
