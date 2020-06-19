# Mercado Libre Challenge

## Descripción del Challenge:
El objetivo final del challenge es el desarrollo de una aplicación que permita consultar a través de una API la información agrupada de un ITEM obtenida a partir de la consulta a dos servicios Rest expuestos por Mercado libre (ML). La información resultante de la consulta referida a un ITEM que no haya sido consultado anteriormente debe ser almacenada en una BD **Postgres o MySQL**, de modo que esta actúe como cache evitando que se deva volver a consultar las APIs de ML si ya se cuenta con la refrencia de un ITEM.

De igual forma la aplicación debe permitir consultar algunas métricas que proporcionen información agrupada por minuto sobre algunos parámetros que reflejen el tiempo promedio de respuesta de la aplicación, la cantidad de consultas recibidas, el tiempo promedio que tardan en responder las APIs de ML y sus códigos de respuesta agrupados.

La aplicación debe correr dentro de un contenedor **Docker**. 

La API contiene los siguientes endpoints:

### Item ###
- `GET /item/:id`: Recibe un id de item y devuelve el item con ese ID. En caso de no existir, devuelve error.
### Métricas ###
- `GET /health`: Devuelve un Json con métricas de la aplicación agrupada por minuto. La información resultante mostrará el comportamiento de la aplicación solo para los últimos 60.
### Métricas adiciones ###
***Spring Boot Actuator***

- `GET /actuator/health` 
- `GET /actuator/metrics`

## Tecnologías ##

- Java
- PostgresSQL
- Spring Boot
- Docker

### L2 Cache ###
- hibernate ehcache: Con el fin de conseguir un incremento de la velocidad de acceso a los objetos.

## Assumptions ##
- Se asume que la información almacenada en caché tiene un periodo de expiración de una semana, con el objetivo de no perder nuevas republicaciones que podría tener Item. Para tener un mejor control sobre el crecimiento de la tabla, asumiendo que podría tratarse de un sistema con alta concurrencia todos los Items almacendados en la cache con fecha de creación mayor a 7 días, serán eliminados por medio de un proceso desatendido desde la BD que se ejecutará cada día a una hora determinada.

- Se asume que la información mostrada por el servicio ***health*** será correspondiente solamente a los 60 minutos anteriores a la consulta del servicio. Estas métricas seran recolectadas y almacenadas en la tabla ***metrica*** en formato json a través de un proceso desatendido que correrá en la BD cada 1 minuto y analisará la información de los request del minuto anterior existentes en las tablas ***item_cache*** y ***ml_api_data***, evitando que se tenga que analizar todos los registros de estas tablas correspondientes a los últimos 60 minutos cada vez que se consulte el servicio ***health*** en busca de mejor performance, asumiendo que la cantidad de registros creados por minuto podrían ser considerable.

- Para el ejemplo no se ve necesario tomar en cuenta el uso de una capa de seguridad, si esta fuera a ser usada en un ambiente de producción sería una mejora recomendada.

## Mejoras recomendadas ##
- Una mejora a realizar es la obtención de los tiempos de ejecución de los métodos haciendo uso de Spring AOP, considero sería una solución más elegante que con más tiempo se podría realizar. 
