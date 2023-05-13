# ©️Proyecto Final Argentina Programa 4.0 🚀 

![image](https://github.com/Jhossymarbalderrama/portafolio-BackEnd/assets/52534649/ee4f3959-76db-4a7d-8c4a-2e6721fc5ea0)

Proyecto Backend sobre mí portafolio construido Spring Boot. Este proyecto cuenta con una conexion a un Fronend creado con Angular (alojado en Firebase) y a una BD (Base de datos) MySQL que almacena los datos de mi portafolio.

<a href='https://my-portafolio-7abab.web.app/' title='mi portafolio' target='_blank'>🚀 Mi Portafolio 👈<a/>
## 📌 🖥️ Tecnologías Utilizadas  📱

<p  align="center">
     <img src="https://user-images.githubusercontent.com/52534649/238108268-01f305b7-073c-41eb-a869-a9b64b129c79.png" alt="drawing" style="width:400px;"/> 
</p>

## 📌🔐 Conexión API a MySQL ⚙️

Parámetros de configuración para: `application.properties`:

- `spring.jpa.hibernate.ddl-auto=update`: Esta propiedad indica que Hibernate debe actualizar automáticamente la base de datos cada vez que se inicia la aplicación.
- `spring.datasource.url=jdbc:mysql://localhost:3306/nombrebdd?useSSL=false&serverTimezone=UTC`: Esta propiedad indica la URL de la base de datos que se va a utilizar. En este caso, se utiliza una base de datos llamada "backend_dinoferre" que está alojada en el localhost y utiliza el puerto 3306. También se indica que no se utiliza SSL y se utiliza el huso horario UTC. Al hacer deploy cambio esta direccion por la url de Clever Cloud.
- `spring.datasource.username=root`: Esta propiedad indica el nombre de usuario que se utiliza para conectarse a la base de datos. Cambio por user de Clever Cloud al hacer deploy.
- `spring.datasource.password=`: Esta propiedad indica la contraseña que se utiliza para conectarse a la base de datos. Cambio por password de Clever Cloud al hacer deploy.
- `spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect`: Esta propiedad indica el dialecto de la base de datos que se está utilizando. En este caso, se está utilizando MySQL 8.


## 📌📁 Características de la aplicación 📚

- `Controller`: Clases de controlador que se comunican con el Frontend y los métodos que manejan las peticiones HTTP.
- `Model`: Todos los tipos de Entidades.
- `Repository`: Interfaces que extienden de JPA y sus métodos para realizar operaciones en la BD (Base de Datos). 
- `Service`: Ubicacion donde se encuentran las clases y interfaces de servicio.

## 📌 Contacto ✉️
* Gmail: jhossymarbalderrama@gmail.com
