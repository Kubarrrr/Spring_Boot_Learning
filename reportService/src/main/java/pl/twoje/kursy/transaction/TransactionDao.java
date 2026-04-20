package pl.twoje.kursy.transaction;

import org.springframework.stereotype.Component;
import pl.twoje.kursy.customer.Customer;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Component
class TransactionDao {
        List<Transaction> findAll() {
        try (Stream<String> lines = Files.lines(Path.of("files", "transactions.csv"))) {
            return lines.map(Transaction::fromCsvString)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
