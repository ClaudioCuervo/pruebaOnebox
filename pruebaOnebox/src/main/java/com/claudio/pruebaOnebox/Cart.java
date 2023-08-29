package com.claudio.pruebaOnebox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Cart {

	DecimalFormat df = new DecimalFormat("####0.00");
	public String cartId;
	public List<Product> products;
	public Date lastActivity;

	public static Map<String, Cart> carts = new ConcurrentHashMap<>();

    public Cart() {
        this.cartId = generateCartId();
        this.products = new ArrayList<>();
        this.lastActivity = new Date();

        carts.put(cartId, this);
    }
    
    public String getCartId() {
		return cartId;
	}

    public void addProduct(Product product) {
        products.add(product);
        lastActivity = new Date();
    }
    
    public String getProductsInCart(){
    	String productString = "";
     	for (int i=0; i<products.size(); i++) {
    		Product product = new Product();
    		product = products.get(i);
    		productString += Product.getProductInfo(product);
    	}
     	return productString;
    }
    
    public Double getTotalAmount(){
    	Double totalAmount = 0.00;
     	for (int i=0; i<products.size(); i++) {
    		Product product = new Product();
    		product = products.get(i);
    		totalAmount += product.getAmount();
    	}
     	return totalAmount;
    }

    public void getInfo() {
        lastActivity = new Date();
        String productsIn = getProductsInCart();
        Double totalAmount = getTotalAmount();
        System.out.println("Cart ID: " + cartId + "\nLast Activity: " + lastActivity + "\nProducts in Cart: " + productsIn + "\nTotal amount: " + df.format(totalAmount));
    }

    public void deleteCart() {
        carts.remove(cartId);
        System.out.println("Cart " + cartId + " deleted successfully!");
    }

    public String generateCartId() {
    	//Generates a unique ID for a Cart
    	return UUID.randomUUID().toString();
    }

    public static Cart getCartById(String cartId) {
        Cart cartFound = carts.get(cartId);
        return cartFound;
    }

    public static void checkAndDeleteInactiveCarts() {
        Date now = new Date();
        for (Cart cart : carts.values()) {
            long inactiveMinutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - cart.lastActivity.getTime());
            if (inactiveMinutes >= 10) {
                cart.deleteCart();
            }
        }
    }
}

