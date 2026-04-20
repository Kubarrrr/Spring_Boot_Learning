package pl.twoje.kursy.customer;

import pl.twoje.kursy.product.Product;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Customer fromCsvString(String str){
        String[] columns = str.split(",");
        return new Customer(Integer.valueOf(columns[0]), columns[1], columns[2]);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String firstAndLastName(){
        return firstName + " " + lastName;
    }
}
