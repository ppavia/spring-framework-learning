package ppa.labs.springbatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ppa.labs.springbatch.model.VAERSData;

@Repository
public interface VAERSDataRepositoty extends MongoRepository<VAERSData, Long> {
}
