package nl.designpattern.factory.sharp;

import nl.designpattern.factory.matcha.ViewEngine;

import java.util.Map;

public class SharpViewEngine implements ViewEngine
{
    @Override
    public String render(String viewName, Map<String, Object> content)
    {
        return "View rendered by Sharp";
    }
}
