package ppa.labs.springbatch.service.old;

import org.springframework.stereotype.Service;
import ppa.labs.springbatch.service.api.CsvReaderService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service("streamCsvService")
public class StreamCsvReaderService implements CsvReaderService<Object> {

    @Override
    public Optional<Reader> createReaderFromCsvStream(Object csvStream) throws IOException {
        if (csvStream instanceof String) {
            String stringCsv = (String) csvStream;
            Reader reader = new StringReader(stringCsv);
            InputStream is = new ByteArrayInputStream(stringCsv.getBytes(StandardCharsets.UTF_8));
            //Files.copy(is, Path.of(csvPathName));
            return Optional.of(reader);
        }
        return Optional.empty();
    }

    @Override
    public List<Object> extractDataFromCsv(Path filePath) throws IOException {
        return null;
    }
}
