# Checklist de Migración: DrakesCraft-Labs 1.21.11

Este documento detalla el progreso del port masivo del ecosistema Slimefun a la versión **1.21.11 (Java 21)**.

## 1. Dependencias Core (Estado de Migración)

| Dependencia | Versión 1.21.1 | Estado |
|-----------|-------------------------|--------|
| Paper/Spigot API | 1.21.11-R0.1-SNAPSHOT | [x] **LISTO** |
| Slimefun4 Core | 5.0-Drake-1.21.11 | [x] **READY** (Base POM adaptada) |
| ProtocolLib | 5.3.0 (Build 720+) | [x] **LISTO** |
| Vault | Standard 1.21 | [x] **LISTO** |

## 1.1 Reactor Actual

El `pom.xml` raíz es el **reactor Maven** del workspace:

- define las versiones compartidas (`Java 21`, `Paper 1.21.11`, `Slimefun RC-37`, `dough-core`)
- lista los módulos activos del port
- permite compilar por addon sin perder una base común
- hoy las variantes activas para esta parte del árbol son `Cultivation_Updated` y `Networks_Better_Compatibility`

## 2. Estado de Porteo (Dough-Core & Addons)

| Componente | Estado de Porteo | Observaciones |
|------------|------------------|---------------|
| **dough-core** | **[x] LISTO** | Versión `1.3.1-DRAKE`. NMS purgado y empaquetado. |
| **SefiLib** | **[x] LISTO** | Compilado para 1.21.11. |
| **InfinityLib** | **[x] LISTO** | Compilado para 1.21.11. |
| **Networks_Better_Compatibility** | **[x] LISTO** | Compila en 1.21.11 y reemplaza al `Networks` antiguo en el reactor. |
| **LiteXpansion** | **[x] LISTO** | Refactorizado: Eliminada reflexión de encantamientos (incompatible). |
| **SlimeTinker** | **[x] LISTO** | Compila en 1.21.11. Integración con `Networks` quedó opcional para no bloquear el build. |
| **Cultivation_Updated** | **[x] LISTO** | Compila en 1.21.11 y reemplaza al `Cultivation` antiguo en el reactor. |
| **CrystamaeHistoria** | **[x] LISTO** | Portado a 1.21.11 (paquetes y persistencia adaptados). |
| **Supreme** | **[x] LISTO** | Compila en 1.21.11. |
| **TranscEndence** | **[x] LISTO** | Compila en 1.21.11. |
| **SMG (SimpleMaterialGenerators)** | **[x] LISTO** | Portado a 1.21.11. Dependencia de PaperLib purgada. |
| **SoulJars** | **[x] LISTO** | Reactor heredado. dough-core y bstats centralizados. |
| **ExtraGear** | **[x] LISTO** | Reactor heredado. dough-core y bstats centralizados. |
| **ColoredEnderChests** | **[x] LISTO** | Reactor heredado. dough-core y bstats centralizados. |
| **DyedBackpacks** | **[x] LISTO** | Reactor heredado. dough-core, bstats y commons-lang centralizados. |
| **+52 Addons Restantes** | [ ] Pendiente | Clonados y listos para procesar uno a uno. |


## 3. Logros del Día 1
- [x] Unificación del reactor Maven (eliminados repositorios muertos).
- [x] Solución al bloqueo de registro de encantamientos personalizados en 1.21.1.
- [x] Mapeo completo de renombrados de constantes (Bukkit -> Paper 1.21).
- [x] Creación de la `docs/MIGRATION_GUIDE_1_21_11.md`.

## 4. Próximos Pasos (Día 3)
1. Seguir con el resto de expansiones del Batch 2 (ej. `SefiLib` refactorización si falta).
2. Hacer testing in-game en un servidor local 1.21.11 de los addons ya porteados (`SMG`, `Supreme`, `TranscEndence`, etc.).
3. Mantener compilación aislada con `-pl` para no saturar el PC.

## 5. Créditos de Referencia
- **Chagui (`Chagui68`)** aportó las variantes adoptadas para `Networks_Better_Compatibility` y `Cultivation_Updated`, ahora usadas como reemplazo directo de los repos antiguos.

---
*Checklist actualizado al cierre de la sesión del 21/04/2026.*
