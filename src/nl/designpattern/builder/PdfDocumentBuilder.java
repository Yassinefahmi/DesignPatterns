package nl.designpattern.builder;

public class PdfDocumentBuilder implements PresentationBuilder
{
    private final PdfDocument pdfDocument;

    public PdfDocumentBuilder()
    {
        pdfDocument = new PdfDocument();
    }

    @Override
    public void addSlide(Slide slide)
    {
        pdfDocument.addPage(slide.getText());
    }

    public PdfDocument getPdfDocument()
    {
        return pdfDocument;
    }
}
