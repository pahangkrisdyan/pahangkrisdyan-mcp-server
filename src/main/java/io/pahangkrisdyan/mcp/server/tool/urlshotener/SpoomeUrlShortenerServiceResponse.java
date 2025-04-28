package io.pahangkrisdyan.mcp.server.tool.urlshotener;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpoomeUrlShortenerServiceResponse(String shortUrl){}
