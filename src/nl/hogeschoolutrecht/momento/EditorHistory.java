package nl.hogeschoolutrecht.momento;

import java.util.ArrayList;
import java.util.List;

public class EditorHistory
{
    private final List<EditorState> editorStates;

    public EditorHistory()
    {
        editorStates = new ArrayList<>();
    }

    public void push(EditorState editorState)
    {
        this.editorStates.add(editorState);
    }

    public EditorState pop()
    {
        int lastIndex = editorStates.size() - 1;
        EditorState lastEditorState = editorStates.get(lastIndex);

        editorStates.remove(lastEditorState);

        return lastEditorState;
    }
}
