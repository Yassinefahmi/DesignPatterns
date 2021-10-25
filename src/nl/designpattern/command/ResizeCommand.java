package nl.designpattern.command;

import nl.designpattern.command.fx.Command;

public class ResizeCommand implements Command
{
    @Override
    public void execute()
    {
        System.out.println("Resize");
    }
}
