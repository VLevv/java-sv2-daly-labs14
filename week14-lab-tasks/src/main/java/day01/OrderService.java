package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderService {
    private List<Order> orders=new ArrayList<>();

    public void saveOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> findOrdersByStatus(String status){
        return orders.stream().filter(order -> order.getStatus().equals(status)).collect(Collectors.toList());
    }

    public long countOrdersByStatus(String status){
        return orders.stream().filter(order -> order.getStatus().equals(status)).count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate start,LocalDate end){
        return orders.stream().filter(order -> order.getOrderDate().isAfter(start))
                .filter(order -> order.getOrderDate().isBefore(end)).collect(Collectors.toList());
    }

    public boolean isThereOrderWithLessProductsThen(int amount){
        return orders.stream().anyMatch(order -> order.getProducts().size()<amount);
    }

    public List<Product> findProductsOverPrice(int price){
        return orders.stream()
                .flatMap(order -> order.getProducts().stream()
                        .filter(product -> product.getPrice()>price)
                        .collect(Collectors.toList()).stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Order getOrderWithMaxNumberOfProducts(){
        return orders.stream().sorted(Comparator.comparing(order -> order.getProducts().size()))
                .collect(Collectors.toList()).get(orders.size()-1);
    }

    public List<Order> getOrdersWithGivenProduct(String category){
        return orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals(category))).collect(Collectors.toList());
    }
}
