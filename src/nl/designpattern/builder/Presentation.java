package nl.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Presentation
{
    private final List<Slide> slides;

    public Presentation()
    {
        slides = new ArrayList<>();
    }

    public void addSlide(Slide slide)
    {
        slides.add(slide);
    }

    public void export(PresentationBuilder presentationBuilder)
    {
        presentationBuilder.addSlide(new Slide("Copyright"));

        for (Slide slide : slides)
        {
            presentationBuilder.addSlide(slide);
        }
    }
}
