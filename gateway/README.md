# GatewayMicroservice

API Gateway para enrutar requests HTTP hacia los microservicios `clients`, `products` y `sales`.

## Dependencia clave

El gateway usa Spring Cloud Gateway Server WebFlux:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-gateway-server-webflux</artifactId>
</dependency>
```

Con Spring Boot `4.0.6`, el release train compatible de Spring Cloud es `2025.1.x`.

## Rutas

| Request al gateway | Servicio destino |
| --- | --- |
| `/clients/**` | `http://clients-service:8080` |
| `/products/**` | `http://products-service:8080` |
| `/sales/**` | `http://sales-service:8080` |

Los nombres destino coinciden con los servicios definidos en el `docker-compose.yml` del repo.

## Uso con Docker Compose

Para deployarlo junto al resto, agregá este servicio al `docker-compose.yml` raíz:

```yaml
  gateway-service:
    build:
      context: ./gateway

    restart: unless-stopped

    depends_on:
      - clients-service
      - products-service
      - sales-service

    ports:
      - "${GATEWAY_PORT}:8080"

    environment:
      CLIENTS_SERVICE_URI: http://clients-service:8080
      PRODUCTS_SERVICE_URI: http://products-service:8080
      SALES_SERVICE_URI: http://sales-service:8080
```

Y en tu `.env`:

```properties
GATEWAY_PORT=8080
```

Después podés llamar, por ejemplo:

```bash
curl http://localhost:8080/clients/1
curl http://localhost:8080/products/1
curl http://localhost:8080/sales/1
```

## Uso local sin Docker

Si corrés los servicios fuera de Docker, pasá las URLs locales:

```bash
CLIENTS_SERVICE_URI=http://localhost:8081 \
PRODUCTS_SERVICE_URI=http://localhost:8082 \
SALES_SERVICE_URI=http://localhost:8083 \
./mvnw spring-boot:run
```

En Windows PowerShell:

```powershell
$env:CLIENTS_SERVICE_URI="http://localhost:8081"
$env:PRODUCTS_SERVICE_URI="http://localhost:8082"
$env:SALES_SERVICE_URI="http://localhost:8083"
.\mvnw.cmd spring-boot:run
```
