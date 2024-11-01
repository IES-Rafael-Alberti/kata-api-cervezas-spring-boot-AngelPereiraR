
# Documentación de la API de Cerveza

Esta documentación detalla cómo interactuar con la API de gestión de cervezas, que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los recursos de cervezas, cerveceras, categorías y estilos.

## Base URL
```
http://localhost:8080
```

## Endpoints

### 1. Obtener todas las cervezas
- **Método**: GET
- **Endpoint**: `/beers`
- **Descripción**: Obtiene una lista de todas las cervezas disponibles.
- **Ejemplo de petición**:
    ```http
    GET /beers HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: Un array con todos los objetos de cerveza.

### 2. Añadir una cerveza
- **Método**: POST
- **Endpoint**: `/beer`
- **Descripción**: Añade una nueva cerveza a la base de datos.
- **Cuerpo de la solicitud**:
    ```json
    {
        "brewery": {"id": 1},
        "category": {"id": 2},
        "style": {"id": 3},
        "name": "Cerveza Artesanal",
        "abv": 5.5,
        "ibu": 40,
        "srm": 10,
        "upc": 123456789,
        "filepath": "/images/cerveza.jpg",
        "descript": "Una cerveza artesanal de gran sabor.",
        "addUser": 1,
        "lastMod": "2024-11-01T12:00:00"
    }
    ```
- **Ejemplo de petición**:
    ```http
    POST /beer HTTP/1.1
    Host: tu-api.com
    Content-Type: application/json

    {
        "brewery": {"id": 1},
        "category": {"id": 2},
        "style": {"id": 3},
        "name": "Cerveza Artesanal",
        "abv": 5.5,
        "ibu": 40,
        "srm": 10,
        "upc": 123456789,
        "filepath": "/images/cerveza.jpg",
        "descript": "Una cerveza artesanal de gran sabor.",
        "addUser": 1,
        "lastMod": "2024-11-01T12:00:00"
    }
    ```
- **Respuesta**: El objeto de cerveza añadido con su `id`.

### 3. Mostrar una cerveza por ID
- **Método**: GET
- **Endpoint**: `/beer/{id}`
- **Descripción**: Muestra los detalles de la cerveza con el ID especificado.
- **Ejemplo de petición**:
    ```http
    GET /beer/1 HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: El objeto de cerveza correspondiente al `id`.

### 4. Eliminar una cerveza
- **Método**: DELETE
- **Endpoint**: `/beer/{id}`
- **Descripción**: Elimina la cerveza con el ID especificado.
- **Ejemplo de petición**:
    ```http
    DELETE /beer/1 HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: `204 No Content` si se elimina correctamente.

### 5. Modificar una cerveza
- **Método**: PUT
- **Endpoint**: `/beer/{id}`
- **Descripción**: Modifica la cerveza con el ID especificado.
- **Cuerpo de la solicitud**:
    ```json
    {
        "name": "Cerveza Artesanal Modificada",
        "abv": 6.0,
        "ibu": 45
    }
    ```
- **Ejemplo de petición**:
    ```http
    PUT /beer/1 HTTP/1.1
    Host: tu-api.com
    Content-Type: application/json

    {
        "name": "Cerveza Artesanal Modificada",
        "abv": 6.0,
        "ibu": 45
    }
    ```
- **Respuesta**: El objeto de cerveza modificado.

### 6. Modificar parcialmente una cerveza
- **Método**: PATCH
- **Endpoint**: `/beer/{id}`
- **Descripción**: Modifica parcialmente la cerveza con el ID especificado.
- **Cuerpo de la solicitud**:
    ```json
    {
        "abv": 6.5
    }
    ```
- **Ejemplo de petición**:
    ```http
    PATCH /beer/1 HTTP/1.1
    Host: tu-api.com
    Content-Type: application/json

    {
        "abv": 6.5
    }
    ```
- **Respuesta**: El objeto de cerveza con el campo modificado.

### 7. Listar todas las cerveceras
- **Método**: GET
- **Endpoint**: `/breweries`
- **Descripción**: Obtiene una lista de todas las cerveceras disponibles.
- **Ejemplo de petición**:
    ```http
    GET /breweries HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: Un array con todos los objetos de cervecera.

### 8. Mostrar una cervecera por ID
- **Método**: GET
- **Endpoint**: `/brewerie/{id}`
- **Descripción**: Muestra los detalles de la cervecera con el ID especificado.
- **Ejemplo de petición**:
    ```http
    GET /brewerie/1 HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: El objeto de cervecera correspondiente al `id`.

### 9. Listar todas las categorías
- **Método**: GET
- **Endpoint**: `/categories`
- **Descripción**: Obtiene una lista de todas las categorías disponibles.
- **Ejemplo de petición**:
    ```http
    GET /categories HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: Un array con todos los objetos de categoría.

### 10. Mostrar una categoría por ID
- **Método**: GET
- **Endpoint**: `/categorie/{id}`
- **Descripción**: Muestra los detalles de la categoría con el ID especificado.
- **Ejemplo de petición**:
    ```http
    GET /categorie/1 HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: El objeto de categoría correspondiente al `id`.

### 11. Listar todos los estilos
- **Método**: GET
- **Endpoint**: `/styles`
- **Descripción**: Obtiene una lista de todos los estilos disponibles.
- **Ejemplo de petición**:
    ```http
    GET /styles HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: Un array con todos los objetos de estilo.

### 12. Mostrar un estilo por ID
- **Método**: GET
- **Endpoint**: `/style/{id}`
- **Descripción**: Muestra los detalles del estilo con el ID especificado.
- **Ejemplo de petición**:
    ```http
    GET /style/1 HTTP/1.1
    Host: tu-api.com
    ```
- **Respuesta**: El objeto de estilo correspondiente al `id`.

---
