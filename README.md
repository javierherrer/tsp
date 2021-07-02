# tsp
Algoritmia básica (30229) - Grado en Ingeniería Informática

Escuela de Ingeniería y Arquitectura - Universidad de Zaragoza

## Descripción
El objetivo de la práctica es implementar y comparar la eficiencia en tiempo de distintos esquemas algorítmicos para la resolución del problema del viajante de comercio (_TSP, Travelling Salesman Problem_).

Tareas a realizar:

1- Implementar los siguientes esquemas algorítmicos vistos en clase para el problema del viajante de comercio:
- Fuerza bruta (enumeración de todos los posibles recorridos)
- Algoritmo voraz
- Programación dinámica
- Ramificación y poda

2- Calcular y comparar los tiempos de ejecución para distintos datos de entrada.

## Compilacion

Para compilar el codigo basta con ejecutar el script

`compilar.sh`

## Ejecucion
Para lanzar una unica ejecucion basta con lanzar el script tsp:
`./tsp -opt <nombre de fichero>`

## Lanzar todas las pruebas
Lanza la bateria de pruebas utilizada para calcular los tiempos
`./tests.sh`
