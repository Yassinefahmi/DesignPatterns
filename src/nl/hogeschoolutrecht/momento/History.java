package nl.hogeschoolutrecht.momento;

import java.util.ArrayList;
import java.util.List;

public class History
{
    private List<EditorState> editorStates;

    public History()
    {
        this.editorStates = new ArrayList<>();
    }

    public void push(EditorState editorState)
    {
        this.editorStates.add(editorState);
    }

    public EditorState pop()
    {
        int lastIndex = this.editorStates.size() - 1;
        EditorState lastEditorState = editorStates.get(lastIndex);

        this.editorStates.remove(lastEditorState);

        return lastEditorState;
    }
}
