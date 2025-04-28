package io.pahangkrisdyan.mcp.server.tool.urlshotener;

import io.quarkiverse.mcp.server.ToolResponse;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UrlShortenerToolTest {

    @Mock
    private SpoomeUrlShortenerService spoomeUrlShortenerService;

    @InjectMocks
    private UrlShortenerTool urlShortenerTool;

    @Test
    void givenUrl_whenShorten_thenCallSpoomeUrlShortenerServiceAndReturnShortUrl() {
        String url = "https:///a.sample.url/dummy/path#dummy-fragment?dummy=query";
        String expectedShorUrl = "https:///a.short.url/dummy";

        when(spoomeUrlShortenerService.shorten(url))
                .thenReturn(Uni.createFrom().item(new SpoomeUrlShortenerServiceResponse(expectedShorUrl)));

        urlShortenerTool.shorten(url).subscribe().withSubscriber(UniAssertSubscriber.create())
                .assertCompleted().assertItem(ToolResponse.success(expectedShorUrl));
    }
}