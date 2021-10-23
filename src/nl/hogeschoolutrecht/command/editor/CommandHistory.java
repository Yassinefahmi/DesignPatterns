package nl.hogeschoolutrecht.command.editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory
{
    private final Deque<UndoableCommand> commands;

    public CommandHistory()
    {
        commands = new ArrayDeque<>();
    }

    public void push(UndoableCommand undoableCommand)
    {
        commands.add(undoableCommand);
    }

    public UndoableCommand pop()
    {
        return commands.pop();
    }

    public int size()
    {
        return commands.size();
    }
}
