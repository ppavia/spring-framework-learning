package ppa.labs.springbatch.service.old;

import org.springframework.stereotype.Service;
import ppa.labs.springbatch.service.api.CsvReaderService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service("pathCsvService")
public class PathCsvReaderService implements CsvReaderService<Object> {
    @Override
    public Optional<Reader> createReaderFromCsvStream(Object csvStream) throws FileNotFoundException {
        if (csvStream instanceof Path) {
            Path csvPathfile = (Path) csvStream;
            Reader reader = new FileReader(csvPathfile.toString());
            return Optional.of(reader);
        }
        return Optional.empty();
    }

    @Override
    public List<Object> extractDataFromCsv(Path filePath) throws IOException {
        return null;
    }
}
