package nl.hogeschoolutrecht.command.editor;

public interface UndoableCommand extends Command
{
    void unExecute();
}
