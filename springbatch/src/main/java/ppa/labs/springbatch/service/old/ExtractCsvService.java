package ppa.labs.springbatch.service.old;

import org.springframework.stereotype.Service;
import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.service.api.CsvReaderService;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ExtractCsvService implements CsvReaderService<VAERSData> {
    @Override
    public Optional<Reader> createReaderFromCsvStream(Object csvStream) throws IOException {
        return Optional.empty();
    }

    @Override
    public List<VAERSData> extractDataFromCsv(Path filePath) throws IOException {

        // hors spring-batch
        Files.lines(filePath)
                .forEach(System.out::println);

        return null;
    }
}
