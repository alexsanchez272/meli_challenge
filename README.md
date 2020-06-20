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

- Prevenir una posible situación donde de forma concurrente se solicite el mismo ITEM por primera vez, para evitar que se creen varias instancias del mismo en la BD.

- Crear test unitarios.

- Agregar documentación con swagger.

## Guía de despligue ##

1- Revisar el archivo property de la aplicación para obtener los datos de conexión.

- url
- base de datos
- usuario: con permisos al menos de SELECT, INSERT, DELETE sobre la BD creada.
- password

Ajustar los parametros segun configuración deseada.

****Antes de ejecutar las sentencias de creación de los pg_cron resulta necesario instalar pg_cron.***

***Para el desarrollo se hizo uso de un contenedor con postgresql 12, en caso de usar una versión diferente instalar el postgresql-xx-cron que corresponda.***

2- En caso de tener el postgresql dentro de un contenedor docker:

`docker exec -t -i container_name /bin/bash`

3- Actualizar repositorios:

`apt-get update`

4- Instalar postgresql-12-cron:

`apt-get -y install postgresql-12-cron`

5- Instalar nano:

`apt-get -y install nano`

6- Obtener la ruta del config_file:

`psql -U postgres -c 'SHOW config_file'`

7- Editar postgresql.conf y agregar las siguientes sentencias al final del archivo:

`
shared_preload_libraries = 'pg_cron'`

`cron.database_name = 'meli_test'`

8- Reiniciar contenedor.

9- Ejecutar en la BD  las siguientes sentencias:

`CREATE EXTENSION pg_cron;`

`CREATE EXTENSION pg_cron VERSION '1.0';`

`ALTER EXTENSION pg_cron UPDATE;`

`GRANT USAGE ON SCHEMA cron TO meli;`

***Las sentencias para la creación de las tablas, tareas desatendidas y funciones en la BD
se encuentran en el archivo schema.sql en la carpeta src/main/resources del proyecto.***

10- construir la aplicación 

11- construir contenedor

`docker build -t meli_challenge/app .`

12- levantar contenedor

`docker run -p 8080:8080 meli_challenge/app`
