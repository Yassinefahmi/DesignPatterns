package nl.hogeschoolutrecht;

import nl.hogeschoolutrecht.adapter.CaramelFilter;
import nl.hogeschoolutrecht.adapter.Image;
import nl.hogeschoolutrecht.adapter.ImageView;
import nl.hogeschoolutrecht.adapter.VividFilter;
import nl.hogeschoolutrecht.adapter.thirdParty.Caramel;
import nl.hogeschoolutrecht.command.editor.*;
import nl.hogeschoolutrecht.composite.Group;
import nl.hogeschoolutrecht.composite.Shape;
import nl.hogeschoolutrecht.iterator.BrowseHistory;
import nl.hogeschoolutrecht.iterator.Iterator;
import nl.hogeschoolutrecht.mediator.ArticleDialogBox;
import nl.hogeschoolutrecht.momento.Editor;
import nl.hogeschoolutrecht.momento.EditorHistory;
import nl.hogeschoolutrecht.observer.Chart;
import nl.hogeschoolutrecht.observer.DataSource;
import nl.hogeschoolutrecht.observer.Spreadsheet;
import nl.hogeschoolutrecht.state.BrushTool;
import nl.hogeschoolutrecht.state.Canvas;
import nl.hogeschoolutrecht.state.SelectionTool;
import nl.hogeschoolutrecht.strategy.BlackAndWhiteFilter;
import nl.hogeschoolutrecht.strategy.ImageStorage;
import nl.hogeschoolutrecht.strategy.PNGCompressor;
import nl.hogeschoolutrecht.template.Task;
import nl.hogeschoolutrecht.template.TransferMoneyTask;

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

        System.out.println("Template Method Pattern \n----------------------------");
        getTemplateMethodPattern();
        System.out.println("----------------------------\n");

        System.out.println("Command Pattern \n----------------------------");
        getCommandPattern();
        System.out.println("----------------------------\n");

        System.out.println("Observer Pattern \n----------------------------");
        getObserverPattern();
        System.out.println("----------------------------\n");

        System.out.println("Mediator Pattern \n----------------------------");
        getMediatorPattern();
        System.out.println("----------------------------\n");

        System.out.println("Composite Pattern \n----------------------------");
        getCompositePattern();
        System.out.println("----------------------------\n");

        System.out.println("Adapter Pattern \n----------------------------");
        getAdapterPattern();
        System.out.println("----------------------------\n");
    }

    private static void getMomentoPattern()
    {
        Editor editor = new Editor();
        EditorHistory history = new EditorHistory();

        editor.setContent("Eerste stukje tekst.");
        history.push(editor.createState());
        System.out.println("State 1: " + editor.getContent());

        editor.setContent("Mijn tweede aangepaste stukje text.");
        System.out.println("State 2: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("Go back to state 1: " + editor.getContent());
    }

    private static void getStatePattern()
    {
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }

    private static void getIteratorPattern()
    {
        BrowseHistory browseHistory = new BrowseHistory();
        browseHistory.push("google.nl");
        browseHistory.push("vraagstudent.nl");
        browseHistory.push("github.com");

        Iterator iterator = browseHistory.createIterator();
        System.out.println("Removed " + browseHistory.pop());

        while (iterator.hasNext())
        {
            System.out.println(iterator.current());
            iterator.next();
        }
    }

    private static void getStrategyPattern()
    {
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("avatar.jpeg", new PNGCompressor(), new BlackAndWhiteFilter());
    }

    private static void getTemplateMethodPattern()
    {
        Task task = new TransferMoneyTask();
        task.execute();
    }

    private static void getCommandPattern()
    {
        CommandHistory commandHistory = new CommandHistory();
        HtmlDocument htmlDocument = new HtmlDocument();
        htmlDocument.setContent("Hello World");

        UndoableCommand boldCommand = new BoldCommand(htmlDocument, commandHistory);

        boldCommand.execute();
        System.out.println(htmlDocument.getContent());

        UndoCommand undoCommand = new UndoCommand(commandHistory);
        undoCommand.execute();
        System.out.println(htmlDocument.getContent());
    }

    private static void getObserverPattern()
    {
        DataSource dataSource = new DataSource();
        Spreadsheet spreadsheet1 = new Spreadsheet(dataSource);
        Spreadsheet spreadsheet2 = new Spreadsheet(dataSource);
        Chart chart = new Chart(dataSource);

        dataSource.addObserver(spreadsheet1);
        dataSource.addObserver(spreadsheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
    }

    private static void getMediatorPattern()
    {
        ArticleDialogBox dialogBox = new ArticleDialogBox();
        dialogBox.simulateUserInteraction();
    }

    private static void getCompositePattern()
    {
        Group parentGroup = new Group();

        Group childGroup1 = new Group();
        Group childGroup2 = new Group();

        childGroup1.add(new Shape()); // Square
        childGroup1.add(new Shape()); // Square

        childGroup2.add(new Shape()); // Circle
        childGroup2.add(new Shape()); // Circle

        parentGroup.add(childGroup1);
        parentGroup.add(childGroup2);
        parentGroup.render();
        parentGroup.move();
    }

    private static void getAdapterPattern()
    {
        ImageView imageView = new ImageView(new Image());
        imageView.apply(new CaramelFilter(new Caramel()));
    }
}
