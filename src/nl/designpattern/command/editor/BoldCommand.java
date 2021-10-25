package nl.designpattern.command.editor;

public class BoldCommand implements UndoableCommand
{
    private String prevContent;
    private final HtmlDocument htmlDocument;
    private final CommandHistory history;

    public BoldCommand(HtmlDocument htmlDocument, CommandHistory history)
    {
        this.htmlDocument = htmlDocument;
        this.history = history;
    }

    @Override
    public void execute()
    {
        prevContent = htmlDocument.getContent();
        htmlDocument.makeBold();

        history.push(this);
    }

    @Override
    public void unExecute()
    {
        htmlDocument.setContent(prevContent);
    }
}
