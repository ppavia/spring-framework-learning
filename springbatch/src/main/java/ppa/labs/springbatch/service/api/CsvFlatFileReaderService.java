package ppa.labs.springbatch.service.api;

import org.springframework.core.io.Resource;

import java.io.IOException;

public interface CsvFlatFileReaderService {

    Resource buildResource(String resourcePath) throws IOException;
}
