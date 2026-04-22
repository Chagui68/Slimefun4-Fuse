# Checklist de Migración: DrakesCraft-Labs 1.21.11 (Slimefun 6 Edition)

Este documento detalla el progreso del port masivo del ecosistema Slimefun a la versión **1.21.11 (Java 21)**, ahora bajo el paraguas técnico de **Slimefun 6**.

## 1. Dependencias Core (Estado de Migración)

| Dependencia | Versión 1.21.1 | Estado |
|-----------|-------------------------|--------|
| Paper/Spigot API | 1.21.11-R0.1-SNAPSHOT | [x] **LISTO** |
| Slimefun 6 Core | 6.0-Drake-1.21.11 | [x] **READY** (Rebranding a Slimefun6) |
| ProtocolLib | 5.3.0 (Build 720+) | [x] **LISTO** |
| Vault | Standard 1.21 | [x] **LISTO** |

## 1.1 Reactor Actual

El `pom.xml` raíz es el **reactor Maven** del workspace:

- define las versiones compartidas (`Java 21`, `Paper 1.21.11`, `Slimefun 6.0`, `dough-core`)
- lista los módulos activos del port
- permite compilar por addon sin perder una base común
- hoy las variantes activas para esta parte del árbol son `Cultivation_Updated` y `Networks_Better_Compatibility`

## 2. Estado de Porteo (Dough-Core & Addons)

| Componente | Estado de Porteo | Observaciones |
|------------|------------------|---------------|
| **dough-core** | **[x] LISTO** | Versión `1.3.1-DRAKE`. NMS purgado y empaquetado. |
| **SefiLib** | **[x] LISTO** | Compilado para 1.21.11. |
| **InfinityLib** | **[x] LISTO** | Compilado para 1.21.11. |
| **Networks_Better_Compatibility** | **[x] LISTO** | Compila en 1.21.11 y reemplaza al `Networks` antiguo. |
| **LiteXpansion** | **[x] LISTO** | Refactorizado para Java 21. |
| **SlimeTinker** | **[x] LISTO** | Compila en 1.21.11. |
| **Cultivation_Updated** | **[x] LISTO** | Compila en 1.21.11. |
| **CrystamaeHistoria** | **[x] LISTO** | Portado a 1.21.11 (Fixes de encantamientos y reflexión). |
| **AlchimiaVitae** | **[x] LISTO** | Portado a 1.21.11. |
| **DankTech2** | **[x] LISTO** | Portado a 1.21.11 (Métricas deshabilitadas). |
| **InfinityExpansion** | **[x] LISTO** | Portado a 1.21.11. |
| **Supreme** | **[x] LISTO** | Compila en 1.21.11. |
| **TranscEndence** | **[x] LISTO** | Compila en 1.21.11. |
| **SMG** | **[x] LISTO** | Portado a 1.21.11. |
| **SoulJars** | **[x] LISTO** | Reactor heredado. |
| **ExtraGear** | **[x] LISTO** | Reactor heredado. |
| **ColoredEnderChests** | **[x] LISTO** | Reactor heredado. |
| **DyedBackpacks** | **[x] LISTO** | Reactor heredado. |
| **+48 Addons Restantes** | [ ] Pendiente | Listos para procesar. |


## 3. Logros del Proyecto (Drake Framework)
- [x] **Slimefun 6 Rebranding**: Evolución tecnológica del core para 1.21.11.
- [x] Unificación del reactor Maven (eliminados repositorios muertos).
- [x] Solución al bloqueo de registro de encantamientos personalizados en 1.21.1.
- [x] Mapeo completo de renombrados de constantes (Bukkit -> Paper 1.21).
- [x] Desacoplamiento de APIs externas (mcMMO, WildStacker, RoseStacker) mediante reflexión.

## 4. Próximos Pasos
1. Testing in-game de la suite Slimefun 6.
2. Migración del resto de addons de la comunidad.
3. Sincronización con el repositorio principal.

## 5. Créditos y Autores
- **TheBusyBiscuit**: Creador original de Slimefun.
- **Sefiraat**: Autor/Mantenedor de Networks, AlchimiaVitae, CrystamaeHistoria, InfinityLib, etc.
- **Mooy1**: Creador original de InfinityExpansion.
- **Sfiguz7**: Creador original de DankTech2.
- **Chagui68**: Aportes en Networks_Better_Compatibility y Cultivation_Updated.
- **Pablo Elías**: Liderazgo del port a 1.21.11 y creación del Drake Framework.

---
*Checklist actualizado al 22/04/2026 - Slimefun 6 Migration.*
