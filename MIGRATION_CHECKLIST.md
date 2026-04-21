# Checklist de Migración: DrakesCraft-Labs 1.21.11

Este documento detalla las dependencias y tareas necesarias para completar el port masivo del ecosistema Slimefun de la 1.20.6 a la 1.21.11.

## 1. Dependencias Core (Descargar versiones equivalentes)

| Dependencia | Versión 1.20.6 (Actual) | Versión 1.21.11 (Objetivo) | Estado |
|-----------|-------------------------|----------------------------|--------|
| Purpur Server | 1.20.6-2233 | [Download Purpur 1.21.1](https://purpurmc.org/downloads) | [ ] Pendiente |
| Slimefun4 | RC-37 | RC-37+ (Build 1.21 compatible) | [ ] Pendiente |
| ProtocolLib | 5.3.0-SNAPSHOT | [Build #720+](https://ci.dmulloy2.net/job/ProtocolLib/) | [ ] Pendiente |
| Vault | 1.7.3 | Standard 1.21 | [ ] Pendiente |
| EssentialsX | 2.20.1 | [Dev Build 2.21+](https://essentialsx.net/downloads.html) | [ ] Pendiente |

## 2. Estado de Porteo (Dough-Core & Addons)

| Componente | Estado de Porteo | Observaciones |
|------------|------------------|---------------|
| **dough-core** | **[/] PROCESADO** | Repackaged a `dev.drake.dough`, NMS purgado. |
| **SefiLib** | **[x] LISTO** | Validado con Multi-módulo. |
| **InfinityLib** | **[x] LISTO** | Validado con Multi-módulo. |
| **DynaTech** | **[x] LISTO** | Validado con Multi-módulo. |
| **Networks** | **[x] LISTO** | Validado con Multi-módulo. |
| **SlimeChem** | **[x] LISTO** | Validado con Multi-módulo. |
| **+30 Addons Restantes** | [ ] Pendiente | Requieren refactor de imports a `dev.drake.dough`. |

## 3. Tareas Críticas de Datos (Components)

- [ ] Verificar persistencia de Androides (Filtros y Metadatos).
- [ ] Validar compatibilidad de `PersistentDataAPI` con el componente `custom_data` de la 1.21.
- [ ] Revisar transformaciones de `Damageable` y `ItemFlags` en Dough.

## 4. Instrucciones de Build

Para compilar todo el ecosistema tras descargar las bases:
```powershell
mvn clean package
```
Los JARs resultantes se encontrarán en las carpetas `target/` de cada módulo bajo `/sources`.
