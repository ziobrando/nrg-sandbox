package it.avanscoperta.ddd.nrgsandbox.network.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNetwork {

    @Test
    public void can_create_a_network() {
        Network network = Network.fromScratch("BIN");

        assertTrue(network.isConnected());
    }



}
