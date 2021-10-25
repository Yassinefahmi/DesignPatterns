package nl.designpattern.builder;

public class MovieBuilder implements PresentationBuilder
{
    private final Movie movie;

    public MovieBuilder()
    {
        movie = new Movie();
    }

    @Override
    public void addSlide(Slide slide)
    {
        movie.addFrame(slide.getText(), 1000);
    }

    public Movie getMovie()
    {
        return movie;
    }
}
