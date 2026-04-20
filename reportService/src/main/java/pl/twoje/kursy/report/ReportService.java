package pl.twoje.kursy.report;

import org.springframework.stereotype.Service;
import pl.twoje.kursy.customer.Customer;
import pl.twoje.kursy.customer.CustomerService;
import pl.twoje.kursy.product.Product;
import pl.twoje.kursy.product.ProductService;
import pl.twoje.kursy.transaction.Transaction;
import pl.twoje.kursy.transaction.TransactionService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final CustomerService customerService;
    private final ProductService productService;
    private final TransactionService transactionService;

    private final TransactionReportGeneratorProvider transactionReportGeneratorProvider;


    public ReportService(TransactionService transactionService,
                         CustomerService customerService,
                         ProductService productService,
                         TransactionReportGeneratorProvider transactionReportGeneratorProvider) {
        this.transactionService = transactionService;
        this.customerService = customerService;
        this.productService = productService;
        this.transactionReportGeneratorProvider = transactionReportGeneratorProvider;
    }

    public void generateTransactionsReport(ReportType reportType) {
        List<Transaction> transactions = transactionService.findAll();
        Set<Integer> customerIds = transactions.stream()
                .map(Transaction::getCustomerId)
                .collect(Collectors.toSet());

        Set<Integer> productIds = transactions.stream()
                .map(Transaction::getProductId)
                .collect(Collectors.toSet());

        Map<Integer, Customer> customerMap = customerService.find(customerIds);
        Map<Integer, Product> productMap = productService.find(productIds);

        // -----------------------------------
        List<TransactionsReportLine> transactionsReportLines = transactions.stream()
                .map(transaction -> {
                    Customer customer = customerMap.get(transaction.getCustomerId());
                    Product product = productMap.get(transaction.getProductId());

                    return new TransactionsReportLine(
                            transaction.getId(),
                            customer.firstAndLastName(),
                            product.getName(),
                            transaction.getDate(),
                            transaction.getQuantity(),
                            transaction.getPrice()
                    );
                })
                .toList();

        TransactionReportGenerator transactionReportGenerator = transactionReportGeneratorProvider.provide(reportType);
        transactionReportGenerator.generate(transactionsReportLines);
    }
}
