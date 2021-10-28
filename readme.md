# Spring Boot "Warehouse"  Example Project
REST APIs implemented using Spring Boot Maven Project


## REST APIs Endpoints
```Yaml
openapi: "3.0.3"
info:
  title: "simple API"
  description: "simple API"
  version: "1.0.0"
servers:
  - url: "https://simple"
paths:
  /api/v1/persons:
    get:
      summary: "GET api/v1/persons"
      operationId: "getAllPerson"
      responses:
        "200":
          description: "OK"
    post:
      summary: "POST api/v1/persons"
      operationId: "create"
      responses:
        "200":
          description: "OK"
  /api/v1/persons/{id}:
    get:
      summary: "GET api/v1/persons/{id}"
      operationId: "findPersonById"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
    put:
      summary: "PUT api/v1/persons/{id}"
      operationId: "update"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
    delete:
      summary: "DELETE api/v1/persons/{id}"
      operationId: "delete"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
  /api/v1/products:
    get:
      summary: "GET api/v1/products"
      operationId: "getProduct"
      responses:
        "200":
          description: "OK"
    post:
      summary: "POST api/v1/products"
      operationId: "create"
      responses:
        "200":
          description: "OK"
  /api/v1/products/search:
    get:
      summary: "GET api/v1/products/search"
      operationId: "getProductByName"
      parameters:
        - name: "name"
          in: "query"
          required: true
          schema:
            type: "string"
      responses:
        "200":
          description: "OK"
  /api/v1/products/{id}:
    get:
      summary: "GET api/v1/products/{id}"
      operationId: "findById"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
    put:
      summary: "PUT api/v1/products/{id}"
      operationId: "update"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
    delete:
      summary: "DELETE api/v1/products/{id}"
      operationId: "delete"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
  /api/v1/products/{id}/orders:
    get:
      summary: "GET api/v1/products/{id}/orders"
      operationId: "getAllOrderBiProductId"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "number"
            format: "int64"
      responses:
        "200":
          description: "OK"
```

