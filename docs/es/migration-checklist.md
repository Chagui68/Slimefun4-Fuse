# Checklist de Migracion

## Resumen Ejecutivo

- Universo real del repo: `87 addons + 2 modulos base`
- Reactor activo actual: `59 modulos`
- Listos en reactor: `57`
- Activos con fallo confirmado: `2`
- Fuera del reactor: `30`
- Pendiente bruto real: `32 addons`

## Regla de Lectura

- Si una pagina dice `pendientes`, verificar si habla de pendientes del reactor o del repo completo.
- El tablero principal del reactor no reemplaza el inventario total del repo.
- Para seguimiento operativo hay que mirar ambos numeros.

## Estado por Capa

### Reactor Actual

- Ya incluidos en `pom.xml` raiz
- Objetivo: dejarlos compilando sin romper el build unificado
- Fallos activos restantes: `2`

### Fuera del Reactor

- Presentes en `sources/*`, pero aun no incluidos en el build unificado
- Objetivo: triage, validar `pom.xml` o convertir desde Gradle cuando haga falta
- Pendientes restantes: `30`

## Prioridad Actual

1. Cerrar primero los fallos activos del reactor.
2. Incorporar quick wins con `pom.xml` listo.
3. Dejar para despues variantes viejas o proyectos con Gradle.

## Quick Wins Fuera del Reactor

- `MoreResearches`
- `SfBetterChests`
- `SlimeHUD`
- `SmallSpace`
- `Quaptics`
