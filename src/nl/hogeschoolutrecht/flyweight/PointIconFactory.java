package nl.hogeschoolutrecht.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PointIconFactory
{
    private final Map<PointType, PointIcon> icons;

    public PointIconFactory()
    {
        icons = new HashMap<>();
    }

    public PointIcon getPointIcon(PointType pointType)
    {
        if (!icons.containsKey(pointType))
        {
            PointIcon pointIcon = new PointIcon(pointType, null);
            icons.put(pointType, pointIcon);
        }

        return icons.get(pointType);
    }
}
