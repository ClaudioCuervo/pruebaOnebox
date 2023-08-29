package com.claudio.pruebaOnebox;

public class App 
{
    public static void main( String[] args )
    {
    	//Create products and carts (2 different ways to do it)
    	Product product1 = new Product(1,"This is a sample product.", 19.99);
    	Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("This is another sample product.");
        product2.setAmount(99.99);
        Product product3 = new Product(3,"This is a sample product.", 23.55);
        Product product4 = new Product(4,"This is a sample product.", 0.99);
        
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        
        //Add products to the carts
        cart1.addProduct(product3);
        cart1.addProduct(product1);
        
        cart2.addProduct(product1);
        cart2.addProduct(product2);
        cart2.addProduct(product4);

        //Check a cart's info given its ID
        System.out.println("--------------- Checking cart2 info ---------------");
        Cart cartToCheck = Cart.getCartById(cart2.getCartId());        		
        cartToCheck.getInfo();
        
        System.out.println("");
        
        System.out.println("--------------- Checking cart1 info ---------------");
        cartToCheck = Cart.getCartById(cart1.getCartId());        		
        cartToCheck.getInfo();
        
        //Checks for inactive carts and deletes them
        Cart.checkAndDeleteInactiveCarts();
        
        System.out.println("");
        
        //Deletes cart1
        cart1.deleteCart();
    }
}
