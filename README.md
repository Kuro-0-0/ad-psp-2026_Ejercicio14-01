# ad-psp-2025_Ejercicio14-01

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

## F04 - Crear Servicios e Implementar reglas de negocio
- F04.1 - Crear cita
- F04.2 - Cancelar cita
- F04.3 - Registrar consulta

## F05 - Implementar consultas personalizadas en Repositorisos
- F05.1 - Citas por paciente
- F05.2 - Citas por estado
- F05.3 - Citas por rango de fechas
- F05.4 - Agenda diara de un profesional + datos paciente. (USAR ENTITYGRAPH)

## F06 - Crear DTOs
- F06.1 - CitaListDto
- F06.2 - CitaDetailDto
- F06.3 - CreateCitaRequest
- F06.4 - CreateConsultaRequest

## F07 - Crear Controllers/EndPoints
- F07.1 - POST /citas
- F07.2 - PUT /citas/{id}/cancelar
- F07.3 - POST /citas/{id}\consulta
- F07.4 - GET /citas (paginado)
- F07.5 - GET /pacientes/{id}/citas

#### By Pablo Garcia Maria