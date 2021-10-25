package nl.designpattern.command.editor;

public interface UndoableCommand extends Command
{
    void unExecute();
}
