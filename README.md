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

## F03 - Crear Servicios e Implementar reglas de negocio
- F03.1 - Crear cita
- F03.2 - Cancelar cita
- F03.3 - Registrar consulta

## F04 - Implementar consultas personalizadas en Repositorisos
- F04.1 - Citas por paciente
- F04.2 - Citas por estado
- F04.3 - Citas por rango de fechas
- F04.4 - Agenda diara de un profesional + datos paciente. (USAR ENTITYGRAPH)

## F05 - Crear DTOs
- F05.1 - CitaListDto
- F05.2 - CitaDetailDto
- F05.3 - CreateCitaRequest
- F05.4 - CreateConsultaRequest

## F06 - Crear Controllers/EndPoints
- F06.1 - POST /citas
- F06.2 - PUT /citas/{id}/cancelar
- F06.3 - POST /citas/{id}\consulta
- F06.4 - GET /citas (paginado)
- F06.5 - GET /pacientes/{id}/citas

#### By Pablo Garcia Maria