package nl.hogeschoolutrecht;

import nl.hogeschoolutrecht.iterator.BrowseHistory;
import nl.hogeschoolutrecht.iterator.Iterator;
import nl.hogeschoolutrecht.momento.Editor;
import nl.hogeschoolutrecht.momento.History;
import nl.hogeschoolutrecht.state.BrushTool;
import nl.hogeschoolutrecht.state.Canvas;
import nl.hogeschoolutrecht.state.SelectionTool;
import nl.hogeschoolutrecht.strategy.BlackAndWhiteFilter;
import nl.hogeschoolutrecht.strategy.ImageStorage;
import nl.hogeschoolutrecht.strategy.PNGCompressor;

public class Main {

    public static void main(String[] args) {
        System.out.println("Momento Pattern \n----------------------------");
        getMomentoPattern();
        System.out.println("----------------------------\n");

        System.out.println("State Pattern \n----------------------------");
        getStatePattern();
        System.out.println("----------------------------\n");

        System.out.println("Iterator Pattern \n----------------------------");
        getIteratorPattern();
        System.out.println("----------------------------\n");

        System.out.println("Strategy Pattern \n----------------------------");
        getStrategyPattern();
        System.out.println("----------------------------\n");
    }

    public static void getMomentoPattern()
    {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("Eerste stukje tekst.");
        history.push(editor.createState());
        System.out.println("State 1: " + editor.getContent());

        editor.setContent("Mijn tweede aangepaste stukje text.");
        System.out.println("State 2: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("Go back to state 1: " + editor.getContent());
    }

    public static void getStatePattern()
    {
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }

    public static void getIteratorPattern()
    {
        BrowseHistory browseHistory = new BrowseHistory();
        browseHistory.push("google.nl");
        browseHistory.push("vraagstudent.nl");
        browseHistory.push("github.com");

        Iterator iterator = browseHistory.createIterator();
        browseHistory.pop();

        while (iterator.hasNext())
        {
            System.out.println(iterator.current());
            iterator.next();
        }
    }

    public static void getStrategyPattern()
    {
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("avatar.jpeg", new PNGCompressor(), new BlackAndWhiteFilter());
    }
}
