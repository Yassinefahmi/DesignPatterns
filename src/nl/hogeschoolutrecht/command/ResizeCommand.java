package nl.hogeschoolutrecht.command;

import nl.hogeschoolutrecht.command.fx.Command;

public class ResizeCommand implements Command
{
    @Override
    public void execute()
    {
        System.out.println("Resize");
    }
}
