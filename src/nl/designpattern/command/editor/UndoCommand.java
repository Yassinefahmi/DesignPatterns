package nl.designpattern.command.editor;

public class UndoCommand implements Command
{
    private final CommandHistory history;

    public UndoCommand(CommandHistory history)
    {
        this.history = history;
    }

    @Override
    public void execute()
    {
        if (history.size() > 0)
        {
            history.pop().unExecute();
        }
    }
}
