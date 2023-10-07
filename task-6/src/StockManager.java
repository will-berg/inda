package projects.chapter04.products;

import java.util.ArrayList;

import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StockManager {
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager() {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item) {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    // 4.59
    public void delivery(int id, int amount) {
        Product product = findProduct(id);
        product.increaseQuantity(amount);
        System.out.println("The quantity has been increased by " + amount + "");
    }


    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    // 4.57
    public Product findProduct(int id) {
        Iterator<Product> it = stock.iterator();
        while (it.hasNext()) {
            Product product1 = it.next();
            if(id == product1.getID()) {
            	return product1;
        	}
    	}
    	return null;
	}

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    // 4.58
    public int numberInStock(int id) {
        Product product = findProduct(id);
        if (findProduct(id) != null) {
        	return product.getQuantity();
      	}
        return 0;
    }

    /**
     * Print details of all the products.
     */
    // 4.56
    public void printProductDetails() {
        for (Product product : stock)
        System.out.println(product.toString());
    }
}
