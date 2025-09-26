Instrucciones
Gestión de Sustituciones de Profesores
Un instituto necesita llevar la gestión de sustituciones en caso de que un profesor falte a una clase. Para ello, cada profesor dispone de su horario en formato CSV, donde se indica:

Nombre del profesor
Día de la semana
Hora (por ejemplo, 1ª, 2ª, 3ª hora…)
Grupo/Clase asignada (o LIBRE en caso de no tener grupo en esa franja)
Requisitos del sistema:
El programa debe recibir como entrada:

El nombre del profesor ausente
El día de la semana
La hora de la clase a sustituir
Con esa información, el sistema debe:

Consultar los horarios de todos los profesores (CSV).
Detectar qué profesores tienen esa franja libre.
De entre los profesores libres, debe generarse un listado con los posibles sustitutos.

Ordenado de menor a mayor, por el número de sustituciones realizadas.

Cada vez que un profesor acepte o se le asigne una sustitución:

Se debe actualizar un fichero de control de sustituciones (CSV acumulativo), donde figure:
Profesor sustituto
Fecha (día/hora de la sustitución)
Número total de sustituciones realizadas por ese profesor
El programa debe permitir:

Consultar en cualquier momento cuántas sustituciones ha hecho un profesor.
Mostrar el ranking de profesores con más sustituciones acumuladas (orden descendente).
Ejemplo:
El profesor García falta el martes 2ª hora.
El sistema busca sustitutos y encuentra que Martínez y López están libres.
Se asigna por Turno o manualmente a López.
Se registra en el fichero de sustituciones que López ya tiene 3 sustituciones hechas en total.
👉 Este ejercicio mezcla:

Lectura y escritura de CSV
Consulta y filtrado de datos
Gestión de ficheros acumulativos
Persistencia de estadísticas
Mi trabajo
