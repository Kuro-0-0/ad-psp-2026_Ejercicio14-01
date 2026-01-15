import random
from datetime import datetime, timedelta, date

# -------- CONFIG --------
NUM_PACIENTES = 20
NUM_PROFESIONALES = 8
NUM_CITAS = 40
OUTPUT_FILE = "import.sql"

ESTADOS = ["PROGRAMADA", "CANCELADA", "ATENDIDA"]
ESPECIALIDADES = [
    "Medicina General",
    "Pediatría",
    "Dermatología",
    "Traumatología",
    "Cardiología"
]

NOMBRES = [
    "Ana", "Luis", "Carlos", "María", "Lucía", "Pedro",
    "Marta", "Javier", "Elena", "Sergio", "Paula", "Raúl"
]

APELLIDOS = [
    "García", "Martínez", "López", "Sánchez",
    "Pérez", "Gómez", "Fernández", "Ruiz"
]

# -------- HELPERS --------
def random_name():
    return f"{random.choice(NOMBRES)} {random.choice(APELLIDOS)}"

def random_email(name):
    base = name.lower().replace(" ", ".")
    return f"{base}@example.com"

def random_date(start_year=1950, end_year=2005):
    start = date(start_year, 1, 1)
    end = date(end_year, 12, 31)
    return start + timedelta(days=random.randint(0, (end - start).days))

def random_datetime():
    now = datetime.now()
    delta = timedelta(days=random.randint(-30, 30), hours=random.randint(8, 18))
    return now + delta

# -------- GENERATION --------
sql = []

# PACIENTES
sql.append("-- PACIENTES")
for i in range(1, NUM_PACIENTES + 1):
    nombre = random_name()
    email = random_email(nombre)
    fecha_nac = random_date()
    sql.append(
        f"INSERT INTO paciente (id, nombre, email, fecha_nacimiento) "
        f"VALUES ({i}, '{nombre}', '{email}', '{fecha_nac}');"
    )

# PROFESIONALES
sql.append("\n-- PROFESIONALES")
for i in range(1, NUM_PROFESIONALES + 1):
    nombre = random_name()
    especialidad = random.choice(ESPECIALIDADES)
    sql.append(
        f"INSERT INTO profesional (id, nombre, especialidad) "
        f"VALUES ({i}, '{nombre}', '{especialidad}');"
    )

# CONSULTAS
sql.append("\n-- CONSULTAS")
for i in range(1, NUM_CITAS + 1):
    fecha = random_date(2024, 2026)
    diagnostico = random.choice([
        "Sin patología relevante",
        "Infección leve",
        "Dolor muscular",
        "Control rutinario",
        "Seguimiento"
    ])
    observaciones = random.choice([
        "Paciente evoluciona favorablemente",
        "Requiere seguimiento",
        "Se receta medicación",
        "Sin incidencias"
    ])
    sql.append(
        f"INSERT INTO consulta (id, fecha, diagnostico, observaciones) "
        f"VALUES ({i}, '{fecha}', '{diagnostico}', '{observaciones}');"
    )

# CITAS
sql.append("\n-- CITAS")
for i in range(1, NUM_CITAS + 1):
    fecha_hora = random_datetime().strftime("%Y-%m-%d %H:%M:%S")
    estado = random.choice(ESTADOS)
    paciente_id = random.randint(1, NUM_PACIENTES)
    profesional_id = random.randint(1, NUM_PROFESIONALES)
    consulta_id = i if estado == "ATENDIDA" else "NULL"

    sql.append(
        f"INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id, consulta_id) "
        f"VALUES ({i}, '{fecha_hora}', '{estado}', {paciente_id}, {profesional_id}, {consulta_id});"
    )

# -------- WRITE FILE --------
with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
    f.write("\n".join(sql))

print(f"Archivo '{OUTPUT_FILE}' generado correctamente.")
