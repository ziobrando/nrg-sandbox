package it.avanscoperta.ddd.nrgsandbox;

import it.avanscoperta.ddd.nrgsandbox.map.readmodel.MapProjection;
import it.avanscoperta.ddd.nrgsandbox.map.readmodel.MongoMapProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMapProjection {

    @Autowired
    MongoMapProjection projection;

    @Test
    public void the_map_is_updated_on_cabinet_added() {

    }
}
