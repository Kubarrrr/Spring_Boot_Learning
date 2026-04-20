package pl.twoje.kursy.product;

import org.springframework.stereotype.Component;
import pl.twoje.kursy.customer.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Component
class ProductDao {
    private static final ProductDao instance = new ProductDao();

    private ProductDao() {

    }

    public static ProductDao getInstance() {
        return instance;
    }

    List<Product> findAll(Set<Integer> ids) {
        try (Stream<String> lines = Files.lines(Path.of("files", "products.csv"))){
            return lines
                    .map(Product::fromCsvString)
                    .filter(product -> ids.contains(product.getId()))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
