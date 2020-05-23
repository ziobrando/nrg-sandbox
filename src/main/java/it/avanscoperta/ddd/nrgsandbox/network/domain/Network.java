package it.avanscoperta.ddd.nrgsandbox.network.domain;

public class Network {

    private final String networkName;

    private Network(String networkName) {
        this.networkName = networkName;
    }

    /**
     * factory method with revealing name.
     * @param networkName
     * @return
     */
    public static Network fromScratch(String networkName) {
        return new Network(networkName);
    }

    public boolean isConnected() {
        // TODO: proper implementation
        return true;
    }
}
