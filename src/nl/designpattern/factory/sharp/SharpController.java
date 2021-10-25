package nl.designpattern.factory.sharp;

import nl.designpattern.factory.matcha.Controller;
import nl.designpattern.factory.matcha.ViewEngine;

public class SharpController extends Controller
{
    @Override
    protected ViewEngine createViewEngine()
    {
        return new SharpViewEngine();
    }
}
