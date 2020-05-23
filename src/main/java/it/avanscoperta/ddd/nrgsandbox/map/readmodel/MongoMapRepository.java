package it.avanscoperta.ddd.nrgsandbox.map.readmodel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface MongoMapRepository
        extends MongoRepository<MapView, String> {

}

