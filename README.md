# transbank-restorant

## Prueba de evaluación técnica

## Repositorio

Los datos del repositorio para descargar el proyecto está en el siguiente link:

https://github.com/saguilarcabello/transbank-restorant.git

## Ejecución del proyecto

Para ejecutar el proyecto debe usar gradle

```
./gradlew bootRun
```

El proyecto se levanta en el puerto 8080

las pruebas se realizan por medio de gradle:

```
./gradlew test
```

## Documentación del proyecto

La documentación del proyecto está en swagger ubicada en:

```
http://localhost:8080/swagger-ui.html
```

## Login de usuario

El proyecto utiliza la url ```http://localhost:8080/login``` para iniciar sesion de usuario, 
una vez autenticado se puede acceder a las url. Ésto lleva a una página vacía que indica que está logeado

Si intenta acceder a cualquier url sin autenticarse se levantará una ventana pidiendole que ingrese el usuario y clave para ingresar.


Los datos de prueba para el login son los siguientes:
```
{
    "userName": "jhonDoe",
    "password": "EqdmPh53c9x"
}
```

para terminar la session de usuario debe ingresar a la url ```http://localhost:8080/logout```


## Apis

Los datos de prueba para crear una venta:

```/api/sales```
```
{
    "diningRoomTable": "1",
    "dateOfSale": "30-10-2020",
    "products": [
        {
            "id": 200,
            "quantity": 1,
            "name": "hamburger",
            "price": 6990
        },
        {
            "id": 300,
            "quantity": 5,
            "name": "coca-cola",
            "price": 500
        }
    ]
}
```

Los datos para obtener las ventas del día: si coloca una fecha en que no hay datos la lista estará vacía.

```/api/sales/30-10-2020```
```
[
    {
        "diningRoomTable": "1",
        "dateOfSale": "30-10-2020",
        "total": 7490,
        "products": [
            {
                "id": 200,
                "quantity": 1,
                "name": "hamburger",
                "price": 6990
            },
            {
                "id": 300,
                "quantity": 5,
                "name": "coca-cola",
                "price": 500
            }
        ]
    }
]
```

Para probar una carga masiva de datos, en el ejemplo creará 10 ventas, el número de ventas puede variar según el número que se indique

```/api/sales/concurrentLoad/10```

```
{
    "diningRoomTable": "1",
    "dateOfSale": "30-10-2020",
    "products": [
        {
            "id": 200,
            "quantity": 1,
            "name": "hamburger",
            "price": 6990
        },
        {
            "id": 300,
            "quantity": 5,
            "name": "coca-cola",
            "price": 500
        }
    ]
}
```

## Implementación JMS

El proyecto genera una cola JMS al momento de grabar una venta, contiene un listener que escucha esta petición y graba la venta en memoria.
El endpoint ```concurrentLoad``` simula una carga masiva de datos a la cola.


## Docker

El proyecto se puede levantar desde un contenedor docker

```
docker build --build-arg JAR_FILE=build/libs/*.jar -t transbank/restorant .
```
```
docker run -p 8080:8080 transbank/restorant
```