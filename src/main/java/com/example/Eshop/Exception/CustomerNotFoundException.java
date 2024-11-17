package com.example.Eshop.Exception;

public class CustomerNotFoundException extends RuntimeException {

    // Vytvoríme konštruktory podľa potreby
    public CustomerNotFoundException(String message) {
        super(message);  // Zavoláme konštruktor RuntimeException s odkazom na správu
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);  // Zavoláme konštruktor RuntimeException s odkazom na správu a príčinu
    }

}
