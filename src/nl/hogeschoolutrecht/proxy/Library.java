package nl.hogeschoolutrecht.proxy;

import java.util.HashMap;
import java.util.Map;

public class Library
{
    private final Map<String, Ebook> ebooks;

    public Library()
    {
        ebooks = new HashMap<>();
    }

    public void add(Ebook ebook)
    {
        ebooks.put(ebook.getFileName(), ebook);
    }

    public void openEbook(String fileName)
    {
        ebooks.get(fileName).show();
    }
}