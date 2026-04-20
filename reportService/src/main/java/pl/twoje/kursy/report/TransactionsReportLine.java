package pl.twoje.kursy.report;

import java.math.BigDecimal;
import java.time.LocalDate;

class TransactionsReportLine {
     private final Integer id;
     private final String customerName;
     private final String productName;
     private final LocalDate date;
     private final Integer quantity;

     private final BigDecimal price;

     public TransactionsReportLine(Integer id, String customerName, String productName, LocalDate date, Integer quantity, BigDecimal price) {
          this.id = id;
          this.customerName = customerName;
          this.productName = productName;
          this.date = date;
          this.quantity = quantity;
          this.price = price;
     }

     public Integer getId() {
          return id;
     }

     public String getCustomerName() {
          return customerName;
     }

     public String getProductName() {
          return productName;
     }

     public LocalDate getDate() {
          return date;
     }

     public Integer getQuantity() {
          return quantity;
     }

     public BigDecimal getPrice() {
          return price;
     }
}
