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

- qué addons están listos
- cuáles siguen fallando dentro del reactor
- cuáles siguen fuera del reactor
- observaciones especiales por plugin cuando aplican

## Bloqueos Activos

### `GeneticChickengineering-Reborn`

- sigue integrado al reactor, pero no listo
- bloqueo principal actual: `pom.xml` y dependencias faltantes
- revisar primero `lombok` y `bstats`

### `PotionExpansion`

- sigue integrado al reactor, pero no listo
- bloqueo principal actual: API vieja
- revisar usos de `SlimefunItemStack.item()`
- revisar llamadas viejas a `CustomItemStack.create(...)`

## Siguiente Ruta Recomendada

1. cerrar `GeneticChickengineering-Reborn`
2. cerrar `PotionExpansion`
3. volver a quick wins fuera del reactor:
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
