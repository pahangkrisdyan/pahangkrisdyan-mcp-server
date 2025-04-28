package io.pahangkrisdyan.mcp.server.tool.urlshotener;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import org.hibernate.validator.constraints.URL;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpoomeUrlShortenerServiceResponse(String shortUrl){}
