package pl.twoje.kursy.report;

import java.util.List;

interface TransactionReportGenerator {
    void generate(List<TransactionsReportLine> transactionsReportLines);
}
