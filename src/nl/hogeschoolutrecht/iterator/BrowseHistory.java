package nl.hogeschoolutrecht.iterator;


public class BrowseHistory
{
    private final String[] urls;
    private int count;

    public BrowseHistory()
    {
        this.urls = new String[10];
    }

    public void push(String url)
    {
        this.urls[count++] = url;
    }

    public String pop()
    {
        return this.urls[--count];
    }

    public Iterator createIterator()
    {
        return new ArrayIterator(this);
    }

    public class ArrayIterator implements Iterator
    {
        private final BrowseHistory browseHistory;
        private int index;

        public ArrayIterator(BrowseHistory browseHistory)
        {
            this.browseHistory = browseHistory;
        }

        @Override
        public boolean hasNext()
        {
            return (this.index < this.browseHistory.count);
        }

        @Override
        public String current()
        {
            return this.browseHistory.urls[this.index];
        }

        @Override
        public void next()
        {
            this.index++;
        }
    }

//    public class ListIterator implements Iterator
//    {
//        private BrowseHistory browseHistory;
//        private int index;
//
//        public ListIterator(BrowseHistory browseHistory)
//        {
//            this.browseHistory = browseHistory;
//        }
//
//        @Override
//        public boolean hasNext()
//        {
//            return (this.index < this.browseHistory.urls.size());
//        }
//
//        @Override
//        public String current()
//        {
//            return this.browseHistory.urls.get(this.index);
//        }
//
//        @Override
//        public void next()
//        {
//            this.index++;
//        }
//    }
}
