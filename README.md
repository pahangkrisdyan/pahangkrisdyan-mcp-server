# pahangkrisdyan-mcp-server

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.package.jar.enabled=false -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21.0.5
```

You can then execute your native executable with: `./build/pahangkrisdyan-mcp-server-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/gradle-tooling>.

## Creating the docker image from the native executable

```shell script
docker build -f src/main/docker/Dockerfile.native-micro -t quarkus/pahangkrisdyan-mcp-server .
```

## Running the docker image

```shell script
docker run -i --rm -p 8080:8080 quarkus/pahangkrisdyan-mcp-server
```

## Related Guides

- MCP Server - HTTP/SSE ([guide](https://docs.quarkiverse.io/quarkus-mcp-server/dev/index.html)): This extension enables developers to implement the MCP server features easily.
