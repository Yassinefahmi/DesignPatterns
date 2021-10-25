package nl.designpattern.factory;

import nl.designpattern.factory.sharp.SharpController;

import java.util.HashMap;
import java.util.Map;

public class ProductsController extends SharpController
{
    public void listProducts()
    {
        // Get products from a database
        Map<String, Object> content = new HashMap<>();
        // content.put(products)
        render("products.html", content);
    }
}
