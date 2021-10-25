package nl.designpattern.factory.matcha;

import java.util.Map;

public class Controller
{
    public void render(String viewName, Map<String, Object> content)
    {
        ViewEngine viewEngine = createViewEngine();
        String html = viewEngine.render(viewName, content);

        System.out.println(html);
    }

    protected ViewEngine createViewEngine()
    {
        return new MatchaViewEngine();
    }
}
