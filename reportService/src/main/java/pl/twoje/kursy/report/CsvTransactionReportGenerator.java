package pl.twoje.kursy.report;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
class CsvTransactionReportGenerator implements TransactionReportGenerator{
    @Override
    public void generate(List<TransactionsReportLine> transactionsReportLines) {
        System.out.println("Ja generuje csvki");

        try (CSVPrinter printer = new CSVPrinter(new FileWriter("csv.txt"), CSVFormat.Builder.create().setDelimiter('.').build())) {
            for (TransactionsReportLine transactionsReportLine : transactionsReportLines) {
                printer.printRecord(transactionsReportLine.getId(),
                        transactionsReportLine.getCustomerName(),
                        transactionsReportLine.getProductName(),
                        transactionsReportLine.getDate(),
                        transactionsReportLine.getQuantity(),
                        transactionsReportLine.getPrice());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        transactionsReportLines.forEach(transactionsReportLine -> System.out.println(transactionsReportLine.toString()));
    }
}
