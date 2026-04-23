# Bienvenido a Drakes Slimefun Labs Wiki

> [!NOTE]
> Esta wiki documenta el estado real del laboratorio de migracion para `Paper 1.21.11`, `Java 21`, `Slimefun 6` y `dough-core 1.3.1-DRAKE`.

---

## Estado Real

- Addons presentes en el repo: `87`
- Modulos base: `2`
- Universo total del workspace: `89`
- Modulos activos en el reactor: `59`
- Modulos listos dentro del reactor: `57`
- Modulos activos con fallo confirmado: `2`
- Addons fuera del reactor: `30`
- Backlog bruto real: `32 addons`

> [!TIP]
> El `README.md` ahora contiene la lista explicita completa de addons listos, addons con observaciones y addons faltantes. Usa esa lista como fuente de verdad humana.

## Navegacion Rapida

- [[Checklist de Migración]]
- [[Módulos Pendientes]]
- [Project backlog en GitHub](https://github.com/orgs/DrakesCraft-Labs/projects/1/views/1)
- [[Roadmap de Estabilización]]
- [[Referencia Técnica (Paper 1.21.1)]]
- [[Guía de Smoke Test]]
- [[Dev-Setup]]
- [[New-Addon-Template]]
- [[Tomorrow-Handoff]]
- [[Home-EN]]
- [Estrategia de Releases y CI](release-and-ci-strategy.md)

## Que significa cada numero

- `Reactor activo`: lo que hoy compila con el parent `pom.xml` unificado.
- `Activos con fallo confirmado`: addons ya integrados al build, pero aun no cerrados.
- `Fuera del reactor`: addons presentes en `sources/*` que aun no fueron incorporados al build unificado.
- `Backlog bruto`: suma de lo pendiente dentro del reactor mas lo que aun esta fuera del reactor.

## Ruta Recomendada

- Primero cerrar los `2` activos con fallo confirmado del reactor.
- Despues incorporar quick wins con `pom.xml` ya existente desde comunidad.
- Dejar para despues los casos con Gradle o variantes obsoletas que requieren triage.

## Quick Wins Actuales

- `MoreResearches`
- `SfBetterChests`
- `SlimeHUD`
- `SmallSpace`
- `Quaptics`

## Ultimos Cierres Validados

- `MapJammers`
- `HeadLimiter`
- `MiniBlocks`
- `DyeBench`
- `Element-Manipulation`
- `MissileWarfare`

## Fallo Activo Confirmado

- `GeneticChickengineering-Reborn`
- `PotionExpansion`

## Navegacion

- [[Checklist de Migración]]
- [[Módulos Pendientes]]
- [[Roadmap de Estabilización]]
- [[Tomorrow-Handoff]]
- [[Home-EN]]
