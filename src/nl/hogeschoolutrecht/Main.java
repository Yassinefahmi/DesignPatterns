package nl.hogeschoolutrecht;

import nl.hogeschoolutrecht.momento.Editor;
import nl.hogeschoolutrecht.momento.History;

public class Main {

    public static void main(String[] args) {
        getMomentoPattern();
    }

    public static void getMomentoPattern()
    {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("Eerste stukje tekst.");
        history.push(editor.createState());

        editor.setContent("Mijn tweede aangepaste stukje text.");
        editor.restore(history.pop());

        System.out.println(editor.getContent());
    }
}
