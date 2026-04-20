package pl.twoje.kursy.transaction;

import pl.twoje.kursy.customer.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private Integer customerId;
    private Integer productId;
    private LocalDate date;
    private Integer quantity;
    private BigDecimal price;

    public Transaction() {
    }

    public Transaction(Integer id, Integer customerId, Integer productId,  LocalDate date, Integer quantity, BigDecimal price) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public static Transaction fromCsvString(String str){
        String[] columns = str.split(";");
        return new Transaction(Integer.valueOf(columns[0]),
                Integer.valueOf(columns[1]),
                Integer.valueOf(columns[2]),
                LocalDate.parse(columns[3]),
                Integer.valueOf(columns[4]),
                new BigDecimal(columns[5]));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
