package com.learn.design.pattern.solidP;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

public class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}

class ProductFilter {
    public static Stream<Product> findByColorAndSize(List<Product> products, Color color, Size size) {
        return products.stream().filter(product -> product.color == color && product.size == size);
    }
}

class demo {
    public static void main(String[] args) {
        Product p1 = new Product("apple", Color.RED, Size.MEDIUM);
        Product p2 = new Product("pomogranate", Color.RED, Size.HUGE);
        Product p3 = new Product("watermellon", Color.RED, Size.MEDIUM);
        List<Product> products = Arrays.asList(p1,p2,p3);
        ProductFilter.findByColorAndSize(products, Color.RED, Size.HUGE).forEach( p -> {
                System.out.println(p);
        });
    }
}