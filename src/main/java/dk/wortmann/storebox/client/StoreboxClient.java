package dk.wortmann.storebox.client;

import dk.wortmann.storebox.auth.StoreboxAuthorizer;
import dk.wortmann.storebox.model.Card;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Slf4j
public class StoreboxClient {
    private final WebTarget target;

    public StoreboxClient(final Client client, final String host, final String token) {
        this.target = client.target(host)
                .register(new StoreboxAuthorizer(token))
                .path("/api/v1");
    }

    public List<Card> getCards() {
        return target.path("cards")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {});
    }
}
