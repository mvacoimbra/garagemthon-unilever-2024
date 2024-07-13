# API

Este projeto é uma API RESTful para gerenciar um sistema das doações. Inclui funcionalidades para gerenciar pedidos de entrega, empresas de destino, produtos e empresas de transporte. O projeto é construído com Spring Boot e utiliza vários componentes Spring para diferentes funcionalidades.

## Funcionalidades

- Gerenciar pedidos de entrega
- Gerenciar empresas de destino
- Gerenciar produtos
- Gerenciar empresas de transporte

## Tecnologias Utilizadas

- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok

## Controladores

### DeliveryOrderController

#### Endpoints

- **POST /api/v1/delivery**
  - Criar um novo pedido de entrega.
  - Corpo da requisição: `DeliveryOrderEntity`
  - Resposta: `DeliveryOrderEntity` criado
  
- **GET /api/v1/delivery**
  - Obter uma lista de todos os pedidos de entrega.
  - Resposta: Lista de `DeliveryOrderEntity`
  
- **GET /api/v1/delivery/{deliveryOrderId}**
  - Obter um pedido de entrega pelo ID.
  - Variável de caminho: `deliveryOrderId` (Long)
  - Resposta: `Optional<DeliveryOrderEntity>`
  
- **PATCH /api/v1/delivery/{deliveryOrderId}**
  - Atualizar o status e a localização de um pedido de entrega.
  - Variável de caminho: `deliveryOrderId` (Long)
  - Parâmetros de consulta: `newStatus` (String), `location` (String)
  - Resposta: `DeliveryOrderEntity` atualizado
  
- **DELETE /api/v1/delivery/{deliveryOrderId}**
  - Excluir um pedido de entrega pelo ID.
  - Variável de caminho: `deliveryOrderId` (Long)
  - Resposta: Mensagem de status de exclusão

### DestinationCompanyController

#### Endpoints

- **POST /api/v1/destination**
  - Criar uma nova empresa de destino.
  - Corpo da requisição: `DestinationCompanyEntity`
  - Resposta: `DestinationCompanyEntity` criado
  
- **GET /api/v1/destination**
  - Obter uma lista de todas as empresas de destino.
  - Resposta: Lista de `DestinationCompanyEntity`
  
- **GET /api/v1/destination/{destinationCompanyId}**
  - Obter uma empresa de destino pelo ID.
  - Variável de caminho: `destinationCompanyId` (Long)
  - Resposta: `Optional<DestinationCompanyEntity>`
  
- **PATCH /api/v1/destination/{destinationCompanyId}**
  - Atualizar uma empresa de destino.
  - Variável de caminho: `destinationCompanyId` (Long)
  - Corpo da requisição: `DestinationCompanyEntity`
  - Resposta: `DestinationCompanyEntity` atualizado
  
- **DELETE /api/v1/destination/{destinationCompanyId}**
  - Excluir uma empresa de destino pelo ID.
  - Variável de caminho: `destinationCompanyId` (Long)
  - Resposta: Mensagem de status de exclusão

### ProductController

#### Endpoints

- **POST /api/v1/products**
  - Criar um novo produto.
  - Corpo da requisição: `ProductEntity`
  - Resposta: `ProductEntity` criado
  
- **GET /api/v1/products**
  - Obter uma lista de todos os produtos.
  - Resposta: Lista de `ProductEntity`
  
- **GET /api/v1/products/{productId}**
  - Obter um produto pelo ID.
  - Variável de caminho: `productId` (Long)
  - Resposta: `Optional<ProductEntity>`
  
- **PATCH /api/v1/products/{productId}**
  - Atualizar um produto.
  - Variável de caminho: `productId` (Long)
  - Corpo da requisição: `ProductEntity`
  - Resposta: `ProductEntity` atualizado
  
- **DELETE /api/v1/products/{productId}**
  - Excluir um produto pelo ID.
  - Variável de caminho: `productId` (Long)
  - Resposta: Mensagem de status de exclusão

### TransportCompanyController

#### Endpoints

- **POST /api/v1/transport**
  - Criar uma nova empresa de transporte.
  - Corpo da requisição: `TransportCompanyEntity`
  - Resposta: `TransportCompanyEntity` criado
  
- **GET /api/v1/transport**
  - Obter uma lista de todas as empresas de transporte.
  - Resposta: Lista de `TransportCompanyEntity`
  
- **GET /api/v1/transport/{transportCompanyId}**
  - Obter uma empresa de transporte pelo ID.
  - Variável de caminho: `transportCompanyId` (Long)
  - Resposta: `Optional<TransportCompanyEntity>`
  
- **PATCH /api/v1/transport/{transportCompanyId}**
  - Atualizar uma empresa de transporte.
  - Variável de caminho: `transportCompanyId` (Long)
  - Corpo da requisição: `TransportCompanyEntity`
  - Resposta: `TransportCompanyEntity` atualizado
  
- **DELETE /api/v1/transport/{transportCompanyId}**
  - Excluir uma empresa de transporte pelo ID.
  - Variável de caminho: `transportCompanyId` (Long)
  - Resposta: Mensagem de status de exclusão

## Começando

### Pré-requisitos

- Java 11 ou superior
- Maven
- PostgreSQL
