package nl.designpattern.strategy;

public class JPEGCompressor implements Compressor
{
    @Override
    public void compress(String fileName)
    {
        System.out.println("Compressing using JPEG on " + fileName);
    }
}
