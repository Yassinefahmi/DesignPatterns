package nl.hogeschoolutrecht.command;

import nl.hogeschoolutrecht.command.fx.Command;

public class BlackAndWhiteCommand implements Command
{
    @Override
    public void execute()
    {
        System.out.println("Black and white");
    }
}
