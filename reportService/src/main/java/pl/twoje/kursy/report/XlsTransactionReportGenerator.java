package pl.twoje.kursy.report;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
class XlsTransactionReportGenerator implements TransactionReportGenerator{
    @Override
    public void generate(List<TransactionsReportLine> transactionsReportLines) {
        System.out.println("Ja generuje xlsy");
        transactionsReportLines.forEach(transactionsReportLine -> System.out.println(transactionsReportLine.toString()));
    }
}
