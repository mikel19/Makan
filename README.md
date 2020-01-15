# Makan

Proyecto del Restaurante Makan

## Descripción

Este restaurante no dispone de ningún tipo de software para gestionar las comandas, las reservas, ni los platos y menús. Por lo que este proyecto en lenguaje Java pretende es solucionar y mejorar estos aspectos. 

Se ha utilizado Maven para el desarrollo del proyecto, incorporando muchas herramientas vinculadas a esta.

1) JUnit
2) Mockito
2) Javadoc (Comentarios en la clase de BaseDeDatos.java)

## ¿Cómo instalar el proyecto en el equipo?

Para instalar el proyecto, es suficiente con hacer git clone del repositorio del proyecto

## ¿Cómo lanzar la aplicación?

Para lanzar la aplicación, es necesario validar y compilar previamente. Por lo que, desde linea de comandos, se lanzarán lo siguiente:

- mvn validate
- mvn compile

Cuando se quieran lanzar los tests de JUnit, es necesario escribir el siguiente comando:

- mvn test

Si se quiere generar documentación con javadoc, primero hay que ejecutar los siguientes comandos:

- mvn javadoc:javadoc
- javadoc "ruta de la clase BaseDeDatos.java
