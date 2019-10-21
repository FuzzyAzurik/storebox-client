package dk.wortmann.storebox.client;

import dk.wortmann.storebox.model.Card;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.ClientBuilder;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StoreboxClientTest {

    private StoreboxClient storeboxClient;

    @BeforeEach
    void setUp() {
        storeboxClient = new StoreboxClient(ClientBuilder
                .newBuilder()
                .register(JacksonJsonProvider.class)
                .build(),
                "https://storebox.com",
                "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIwdmxocmtqNjFsdjZwZ21tdTJkcXFxZjZmZDN0cjQ3MiIsImlhdCI6MTU3MTU5ODAyMiwic3ViIjoiMCIsImV4cCI6MTU3NDE5MDAyMn0.0caSjR71bRCyWQZLdeGqW-AshsP_BEXjowz2K-qVZ2U");
    }

    @Test
    void getCards_OK() {

        final List<Card> result = storeboxClient.getCards();

        assertThat(result)
                .isNotEmpty();
    }
}