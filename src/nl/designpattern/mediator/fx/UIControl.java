package nl.designpattern.mediator.fx;

public class UIControl
{
    protected final DialogBox owner;

    public UIControl(DialogBox owner)
    {
        this.owner = owner;
    }
}
