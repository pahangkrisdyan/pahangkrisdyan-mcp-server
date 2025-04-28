package io.pahangkrisdyan.mcp.server.tool.urlshotener;

import io.quarkiverse.mcp.server.TextContent;
import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import io.quarkiverse.mcp.server.ToolResponse;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hibernate.validator.constraints.URL;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.client.api.WebClientApplicationException;

public class UrlShortenerTool {

    private final SpoomeUrlShortenerService spoomeUrlShortenerService;

    public UrlShortenerTool(@RestClient SpoomeUrlShortenerService spoomeUrlShortenerService) {
        this.spoomeUrlShortenerService = spoomeUrlShortenerService;
    }

    @Tool(name = "UrlShortener", description = "Shortens URL")
    public Uni<ToolResponse> shorten(@ToolArg(name = "url", description = "The original long URL") @URL String url) {
        return spoomeUrlShortenerService.shorten(url)
                .onItem().transform(SpoomeUrlShortenerServiceResponse::shortUrl)
                .onItem().transform(ToolResponse::success);
    }
}
