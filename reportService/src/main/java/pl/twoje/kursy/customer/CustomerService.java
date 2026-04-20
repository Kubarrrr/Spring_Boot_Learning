package pl.twoje.kursy.customer;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private CustomerDao customerDao;

    private CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Map<Integer, Customer> find(Set<Integer> ids){
        List<Customer> customers = customerDao.findAll(ids);

        Map<Integer, Customer> result = customers.stream()
                .collect(Collectors.toMap(Customer::getId, Function.identity()));

        Map<Integer, List<Customer>> map = customers.stream()
                .collect(Collectors.groupingBy(Customer::getId));

        return result;
    }
}
