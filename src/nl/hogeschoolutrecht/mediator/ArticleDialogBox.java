package nl.hogeschoolutrecht.mediator;

import nl.hogeschoolutrecht.mediator.fx.*;

public class ArticleDialogBox extends DialogBox
{
    private final ListBox articleListBox;
    private final TextBox titleTextBox;
    private final Button saveButton;

    public ArticleDialogBox()
    {
        articleListBox = new ListBox(this);
        titleTextBox = new TextBox(this);
        saveButton = new Button(this);
    }

    @Override
    public void changed(UIControl uiControl)
    {
        if (uiControl == articleListBox)
        {
            articleSelected();
        }
        else if (uiControl == titleTextBox)
        {
            titleChanged();
        }
    }

    public void simulateUserInteraction()
    {
        articleListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        titleTextBox.setContent("Article 2");
        System.out.println("Textbox: " + titleTextBox.getContent());
        System.out.println("Button: " + saveButton.isEnabled());
    }

    private void titleChanged()
    {
        String content = titleTextBox.getContent();
        boolean isEmpty = content == null || content.isEmpty();

        saveButton.setEnabled(!isEmpty);
    }

    private void articleSelected()
    {
        titleTextBox.setContent(articleListBox.getSelection());
        saveButton.setEnabled(true);
    }
}
