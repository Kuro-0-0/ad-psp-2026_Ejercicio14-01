# ad-psp-2025_Ejercicio14-01

## Enunciado del ejercicio
[Enunciado](https://github.com/luismilopezedu/ad-psp-2025/blob/main/99_Ejercicios/Spring%20Data%20JPA/ClinicFlow-enunciado.md)


## F01 - Crear entidadess
- F01.1 - Entidad Paciente
- F01.2 - Entidad Profesional
- F01.3 - Entidad Cita
- F01.4 - Entidad Consulta

## F02 - Establecer Relacicones.
- F02.1 - Relacion Paciente - Citas (OneToMany - ManyToOne)
- F02.2 - Relacion Profesional - Citas (OneToMany - ManyToOne)
- F02.2 - Relacion Cita - Consulta (ManyToOne - OneToMany)

## F03 - Crear Repositorios

## F04 - Crear Servicios CRUD basicos
- F04.1 - Servicio Paciente
- F04.2 - Servicio Profesional
- F04.3 - Servicio Cita
- F04.4 - Servicio Consulta

## F05 - Crear Controllers CRUD basicos
- F05.1 - Controller Paciente
- F05.2 - Controller Profesional
- F05.3 - Controller Cita
- F05.4 - Controller Consulta

## F06 - Crear e Implementar reglas de negocio
- F06.1 - Crear cita
- F06.2 - Cancelar cita
- F06.3 - Registrar consulta

## F07 - Implementar consultas personalizadas en Repositorisos
- F07.1 - Citas por paciente
- F07.2 - Citas por estado
- F07.3 - Citas por rango de fechas
- F07.4 - Agenda diaria de un profesional + datos paciente. (USAR ENTITYGRAPH)

## F08 - Crear DTOs
- F08.1 - CitaListDto
- F08.2 - CitaDetailDto
- F08.3 - CreateCitaRequest
- F08.4 - CreateConsultaRequest

## F09 - Crear Controllers/EndPoints
- F09.1 - POST /citas
- F09.2 - PUT /citas/{id}/cancelar
- F09.3 - POST /citas/{id}\consulta
- F09.4 - GET /citas (paginado)
- F09.5 - GET /pacientes/{id}/citas

#### By Pablo Garcia Maria