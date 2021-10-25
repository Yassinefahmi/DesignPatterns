package nl.designpattern;

import nl.designpattern.adapter.CaramelFilter;
import nl.designpattern.adapter.Image;
import nl.designpattern.adapter.ImageView;
import nl.designpattern.adapter.thirdParty.Caramel;
import nl.designpattern.bridge.AdvancedRemoteControl;
import nl.designpattern.bridge.RemoteControl;
import nl.designpattern.bridge.SamsungTV;
import nl.designpattern.bridge.SonyTV;
import nl.designpattern.command.editor.*;
import nl.designpattern.composite.Group;
import nl.designpattern.composite.Shape;
import nl.designpattern.decorator.CloudStream;
import nl.designpattern.decorator.CompressedCloudStream;
import nl.designpattern.decorator.CreditCard;
import nl.designpattern.decorator.EncryptedCloudStream;
import nl.designpattern.facade.*;
import nl.designpattern.flyweight.Point;
import nl.designpattern.flyweight.PointIconFactory;
import nl.designpattern.flyweight.PointService;
import nl.designpattern.iterator.BrowseHistory;
import nl.designpattern.iterator.Iterator;
import nl.designpattern.mediator.ArticleDialogBox;
import nl.designpattern.momento.Editor;
import nl.designpattern.momento.EditorHistory;
import nl.designpattern.observer.Chart;
import nl.designpattern.observer.DataSource;
import nl.designpattern.observer.Spreadsheet;
import nl.designpattern.proxy.EbookProxy;
import nl.designpattern.proxy.Library;
import nl.designpattern.singleton.ConfigManager;
import nl.designpattern.state.BrushTool;
import nl.designpattern.state.Canvas;
import nl.designpattern.state.SelectionTool;
import nl.designpattern.strategy.BlackAndWhiteFilter;
import nl.designpattern.strategy.ImageStorage;
import nl.designpattern.strategy.PNGCompressor;
import nl.designpattern.template.Task;
import nl.designpattern.template.TransferMoneyTask;

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

        System.out.println("Decorator Pattern \n----------------------------");
        getDecoratorPattern();
        System.out.println("----------------------------\n");

        System.out.println("Facade Pattern \n----------------------------");
        getFacadePattern();
        System.out.println("----------------------------\n");

        System.out.println("Flyweight Pattern \n----------------------------");
        getFlyWeightPattern();
        System.out.println("\n----------------------------\n");

        System.out.println("Bridge Pattern \n----------------------------");
        getBridgePattern();
        System.out.println("----------------------------\n");

        System.out.println("Proxy Pattern \n----------------------------");
        getProxyPattern();
        System.out.println("----------------------------\n");

        System.out.println("Singleton Pattern \n----------------------------");
        getSingletonPattern();
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

    private static void getDecoratorPattern()
    {
        CreditCard creditCard = new CreditCard();
        creditCard.store(new EncryptedCloudStream(new CompressedCloudStream(new CloudStream())));
    }

    private static void getFacadePattern()
    {
        NotificationService notificationService = new NotificationService();
        notificationService.send("Hello World", "127.0.0.1");
    }

    private static void getFlyWeightPattern()
    {
        PointService pointService = new PointService(new PointIconFactory());

        for (Point point : pointService.getPoints())
        {
            point.draw();
        }
    }

    private static void getBridgePattern()
    {
        RemoteControl remoteSonyControl = new AdvancedRemoteControl(new SonyTV());
        RemoteControl remoteSamsungControl = new AdvancedRemoteControl(new SamsungTV());

        remoteSonyControl.turnOn();
        remoteSamsungControl.turnOn();
    }

    private static void getProxyPattern()
    {
        Library library = new Library();
        String[] fileNames = { "book1", "book2", "book3" };

        for (String fileName : fileNames)
        {
            library.add(new EbookProxy(fileName));
        }

        library.openEbook("book1");
    }

    private static void getSingletonPattern()
    {
        ConfigManager manager1 = ConfigManager.getConfigManager();
        ConfigManager manager2 = ConfigManager.getConfigManager();

        manager1.set("name", "yassine");
        System.out.println(manager2.get("name"));
    }
}
