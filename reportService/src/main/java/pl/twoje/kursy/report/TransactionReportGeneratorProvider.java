package pl.twoje.kursy.report;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionReportGeneratorProvider {
    private final Map<ReportType, TransactionReportGenerator> GENERATOR_MAP;

    public TransactionReportGeneratorProvider(CsvTransactionReportGenerator csvTransactionReportGenerator,
                                              XlsTransactionReportGenerator xlsTransactionReportGenerator) {
                this.GENERATOR_MAP = Map.of(
                ReportType.CSV, csvTransactionReportGenerator,
                ReportType.XLS, xlsTransactionReportGenerator);
    }

    TransactionReportGenerator provide(ReportType reportType){
        return GENERATOR_MAP.get(reportType);
    }
}
