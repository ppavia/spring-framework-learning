package ppa.labs.springbatch.service.api;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface CsvReaderService<T> {


    Optional<Reader> createReaderFromCsvStream(Object csvStream) throws IOException;

    default List<CSVRecord> extractCsvLinesWithHeader(Reader reader, Character delimiter, Class clazz) throws IOException {
        return CSVFormat.RFC4180
                .withDelimiter(delimiter)
                .withHeader(clazz)
                //.withFirstRecordAsHeader()
                .parse(reader)
                .getRecords();
    }

    List<T> extractDataFromCsv(Path filePath) throws IOException;
}
