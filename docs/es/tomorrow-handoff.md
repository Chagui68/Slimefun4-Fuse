# Tomorrow-Handoff

## Estado Actual

- Rama principal de trabajo: `1.21-latin`
- Stack objetivo: `Paper 1.21.11`, `Java 21`, `Slimefun 6`, `dough-core 1.3.1-DRAKE`
- Reactor activo: `59` módulos
- Listos en reactor: `57`
- Fallos activos en reactor: `2`
- Fuera del reactor: `30`
- Backlog operativo real: `32 addons`

## Último Estado Confirmado

La fuente de verdad humana es `README.md`.

Allí ya quedó documentado:

- qué addons están listos (ahora `59/59` en el reactor)
- observaciones especiales por plugin cuando aplican

## Bloqueos Activos

- **Ninguno** en el reactor actual.

## Siguiente Ruta Recomendada

1. Seguir con quick wins fuera del reactor:
   - `MoreResearches`
   - `SfBetterChests`
   - `SlimeHUD`
   - `SmallSpace`
   - `Quaptics`

## Recordatorios Operativos

- no compilar el reactor completo salvo necesidad estricta
- usar builds aislados con `-pl` y `-am`
- si cambia el estado de un addon, sincronizar `README.md` y wiki
- no contar variantes históricas como listas si la activa es otra
- no commitear `build_status.log` salvo instrucción explícita

## Comandos Útiles

Build aislado:

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

Smoke test:

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

## Enlaces Rápidos

- [[Checklist de Migración]]
- [[Módulos Pendientes]]
- [[Roadmap de Estabilización]]
