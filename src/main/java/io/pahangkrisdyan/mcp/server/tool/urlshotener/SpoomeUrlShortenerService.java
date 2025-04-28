package io.pahangkrisdyan.mcp.server.tool.urlshotener;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "spoomeurlshortener-api")
public interface SpoomeUrlShortenerService {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ClientHeaderParam(name = HttpHeaders.ACCEPT, value = MediaType.APPLICATION_JSON)
    Uni<SpoomeUrlShortenerServiceResponse> shorten(@FormParam("url") String url);
}
