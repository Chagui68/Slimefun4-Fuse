# Checklist de Migración: DrakesCraft-Labs 1.21.11

Este documento detalla el progreso del port masivo del ecosistema Slimefun a la versión **1.21.11 (Java 21)**.

## 1. Dependencias Core (Estado de Migración)

| Dependencia | Versión 1.21.1 | Estado |
|-----------|-------------------------|--------|
| Paper/Spigot API | 1.21.11-R0.1-SNAPSHOT | [x] **LISTO** |
| Slimefun4 Core | 5.0-Drake-1.21.11 | [x] **READY** (Base POM adaptada) |
| ProtocolLib | 5.3.0 (Build 720+) | [x] **LISTO** |
| Vault | Standard 1.21 | [x] **LISTO** |

## 2. Estado de Porteo (Dough-Core & Addons)

| Componente | Estado de Porteo | Observaciones |
|------------|------------------|---------------|
| **dough-core** | **[x] LISTO** | Versión `1.3.1-DRAKE`. NMS purgado y empaquetado. |
| **SefiLib** | **[x] LISTO** | Compilado para 1.21.11. |
| **InfinityLib** | **[x] LISTO** | Compilado para 1.21.11. |
| **Networks** | **[x] LISTO** | Compila en 1.21.11. POM alineado con repos válidos y referencia cruzada con el fork de Chagui. |
| **Networks_Better_Compatibility** | **[x] LISTO** | Validado en 1.21.11 como referencia externa útil para integración. |
| **LiteXpansion** | **[x] LISTO** | Refactorizado: Eliminada reflexión de encantamientos (incompatible). |
| **SlimeTinker** | **[x] LISTO** | Compila en 1.21.11. Integración con `Networks` quedó opcional para no bloquear el build. |
| **Cultivation** | **[x] LISTO** | Compila en 1.21.11. Contrastado con `Cultivation_Updated` de Chagui. |
| **+60 Addons Restantes** | [ ] Pendiente | Clonados y listos para procesar uno a uno. |

## 3. Logros del Día 1
- [x] Unificación del reactor Maven (eliminados repositorios muertos).
- [x] Solución al bloqueo de registro de encantamientos personalizados en 1.21.1.
- [x] Mapeo completo de renombrados de constantes (Bukkit -> Paper 1.21).
- [x] Creación de la `docs/MIGRATION_GUIDE_1_21_11.md`.

## 4. Próximos Pasos (Día 2)
1. Seguir con `SMG` y `CrystamaeHistoria`.
2. Revisar `Supreme` y `TranscEndence`.
3. Mantener compilación aislada con `-pl` para no saturar el PC.

## 5. Créditos de Referencia
- **Chagui (`Chagui68`)** aportó referencias útiles de porting en sus forks `Networks_Better_Compatibility` y `Cultivation_Updated`, que se usaron para validar repositorios, compatibilidad y estado de compilación.

---
*Checklist actualizado al cierre de la sesión del 21/04/2026.*
