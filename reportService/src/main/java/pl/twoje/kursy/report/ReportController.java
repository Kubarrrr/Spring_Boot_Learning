package pl.twoje.kursy.report;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public void generateReport(@RequestBody GenerateReportRequest generateReportRequest) {
        System.out.println(generateReportRequest.reportType());
        reportService.generateTransactionsReport(generateReportRequest.reportType());
    }

}
