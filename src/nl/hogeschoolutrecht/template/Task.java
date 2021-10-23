package nl.hogeschoolutrecht.template;

public abstract class Task
{
    private final Audit audit;

    public Task()
    {
        audit = new Audit();
    }

    public Task(Audit audit)
    {
        this.audit = audit;
    }

    public void execute()
    {
        audit.record();

        this.doExecute();
    }

    protected abstract void doExecute();
}
