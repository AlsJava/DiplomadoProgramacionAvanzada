# Diplomado Programación Avanzada 2022

[![Java-17](https://img.shields.io/badge/Java-17-red.svg?style=flat&logo=Java&logoColor=white)](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
[![Spring-Boot](https://img.shields.io/badge/Spring%20Boot-2.6.9-green.svg?style=flat&logo=Springt&logoColor=white)](https://spring.io/projects/spring-boot)


Repositorio básico del código de ejemplo de los temas tratados en el diplomado, donde se muestran los temas explicados
en código y sus tareas respectivas.

# Notas

Cada semana intenta tener un ejercicio en las clases, con el objetivo de tener una práctica con el profesor del tema
tratado

# Ejercicios de JAVA

https://codingbat.com/java

# Soluciones

- [Soluciones Semanales](https://github.com/AlsJava/SolutionDiplomadoProgramacionAvanzada)
- [Solucion Proyecto Final](https://github.com/AlsJava/ProyectoFinalProgramacionAvanzada)

# Detalles por semana

## Semana 1

Introducción de los elementos de trabajo

- instalación de los JDK
- IDE (IntelliJ)
- Video de paradigma
- POO
- Compilador
- Funcionamiento de JAVA

En resumen se preparan los temas y la tarea para la siguiente semana

## Semana 2

Profundiza en JAVA y hace los preparativos para la parte de seguridad y pruebas

## Semana 3

Definimos lo que es una prueba y su forma de trabajo

## Semana 4

Aprendemos a identificar el código que puede tener test y cuales no

## Semana 5

Pruebas cuando los elementos son compuestos y tienen dependencias externas

## Semana 6

Conjuntos de pruebas dinámicos y sus usos

## Semana 7

Conocimiento sobre seguridad y como estar actualizado

## Semana 8

Tendremos los modelos arquitectónicos y explicaremos sus usos.

Esta semana se explicarán las diferencias y se tomará el modelo arquitectónico monolítico
Se inicia el proyecto como tal, en la cuenta de git y se preparan los conceptos.

## Semana 9

Empezamos la definición de un micro servicio y las partes que lo definen, asi como la construcción básica:

- Subir y encontrar los servicios
- Externalización de configuración
- Monitoreo de la salud
- Tolerancia a fallos
- Distribución de la carga

### Nota:

Desde esta semana se trabajará en un proyecto basado en las arquitecturas y se explicará Spring, aunque se podrá usar
otro framework

## Semana 10

Implementación de patrón para responder distribuido y la segregación de tareas

## Semana 11

Manejo de los logs y conceptos a tomar en cuenta a la hora de procesar data

## Semana 12

Manejo de transacciones con SAGA

# Configuraciones

Para clonar y configurar el proyecto debemos tener IntelliJ (Se instala o se descomprime) y el GIT for windows (Este se
instala) y una vez hecho esto se procede a lo siguiente:

## Clonar el proyecto con IntelliJ
![Clonación](documentation/HowTo/IntellijClonarRepositorio1.png?raw=true)

Copiamos la URL del git y luego la clonamos

![Clonación](documentation/HowTo/IntellijClonarRepositorio2.png?raw=true)

## Configurar JDK (IntelliJ)

Una vez abierto el proyecto vamos a project structure

![Clonación](documentation/HowTo/ConfigurarJDK1.png?raw=true)

Vamos a SDKs y le damos al signo mas para adicionar un JDK

![Clonación](documentation/HowTo/ConfigurarJDK2.png?raw=true)

Luego le damos a download JDK

![Clonación](documentation/HowTo/ConfigurarJDK3.png?raw=true)

Seleccionamos la versión (la Ultima LTS de preferencia) y el vender que de preferencia será amazon

![Clonación](documentation/HowTo/ConfigurarJDK4.png?raw=true)

Una vez descargue vamos a y configuramos el SDK en nuestro proyecto

![Clonación](documentation/HowTo/ConfigurarJDK5.png?raw=true)

## Configurar Gradle

En la pestaña derecha vamos y le damos a la herramienta

![Clonación](documentation/HowTo/ConfigurarGradle1.png?raw=true)

Le damos a configuraciones de gradle

![Clonación](documentation/HowTo/ConfigurarGradle2.png?raw=true)

Le indicamos que use el mismo JDK que el proyecto

![Clonación](documentation/HowTo/ConfigurarGradle3.png?raw=true)

## Actualizar y bajar las dependencias del proyecto

Una vez ya configurado todo, solo debemos hacer el reload del proyecto para que descargue todas las dependencias

![Clonación](documentation/HowTo/ActualizaciónGradleDependencies.png?raw=true)


## Pull o bajar los cambios del proyecto

Para bajar los cambios y poner todo al dia, en caso de que existan cambios en el proyecto, usamos ese botón o presionamos CTRL-T

![Clonación](documentation/HowTo/PullProject.png?raw=true)

