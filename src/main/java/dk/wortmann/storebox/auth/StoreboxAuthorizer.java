package dk.wortmann.storebox.auth;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Cookie;
import java.io.IOException;

public class StoreboxAuthorizer implements ClientRequestFilter {
    private final String token;

    public StoreboxAuthorizer(final String token) {
        this.token = token;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext
                .getHeaders()
                .putSingle("X-Storebox-deviceid", "web-v1");
        requestContext
                .getHeaders()
                .putSingle("Cookie", "auth-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIwdmxocmtqNjFsdjZwZ21tdTJkcXFxZjZmZDN0cjQ3MiIsImlhdCI6MTU3MTU5ODAyMiwic3ViIjoiMCIsImV4cCI6MTU3NDE5MDAyMn0.0caSjR71bRCyWQZLdeGqW-AshsP_BEXjowz2K-qVZ2U;");
    }
}
