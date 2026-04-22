# 🐉 Slimefun 6: Drake Framework Ecosystem
### *The Ultimate 1.21.11 Migration & Tech Independence Framework*

<div align="center">

![Version](https://img.shields.io/badge/Minecraft-1.21.11-green?style=for-the-badge&logo=minecraft)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Build](https://img.shields.io/badge/Build-Maven-red?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-GPL--3.0-blue?style=for-the-badge)

**Slimefun 6 (Drake Framework)** es la respuesta definitiva para un ecosistema de Slimefun moderno, eficiente e independiente.
Este repo funciona como **laboratorio de migración**: un mono-repo estratégico para unificar versiones, dependencias, compatibilidad Paper y fixes repetidos antes de volver a separar addons.
Hoy el reactor agrupa **53 módulos activos**: `Slimefun 6 Core`, `dough-core`, librerías base y addons del port masivo.

[Explorar Código](/sources) • [Checklist de Migración](MIGRATION_CHECKLIST.md) • [Arquitectura](ARCHITECTURE.md) • [Dev Setup](docs/DEV_SETUP.md)

</div>

---

## ⚡ Estado del Núcleo (Slimefun 6 Core)
> [!CAUTION]
> **Componente**: `sources/slimefun-core/Slimefun4-src`
> **Estado**: ✅ **MIGRADO A SLIMEFUN 6 (1.21.11)**
> Se ha establecido el Framework de Drake como base. El núcleo ya permite la compilación de addons dependientes mediante el uso de `dough-core` unificado.

---

## 📊 Dashboard de Complejidad (Porting 1.21.11)

Esta tabla clasifica los componentes según el esfuerzo técnico estimado para su migración exitosa.

| Nivel de Dificultad | Componentes Representativos | Estado de Porteo |
| :--- | :--- | :--- |
| **Nivel 1: Easy** | ExoticGarden, SoulJars, ExtraGear, AlchimiaVitae | ✅ Porteo completado |
| **Nivel 2: Medium** | LiteXpansion, Networks_Better_Compatibility, CrystamaeHistoria | ✅ Porteo completado |
| **Nivel 3: Hard** | **Slimefun 6 Core**, SlimeTinker, InfinityExpansion, DankTech2 | ✅ Porteo completado |
| **Nivel 4: Riesgo / Legacy** | Addons antiguos (ExtraTools, etc.) | ⏳ Pendiente |

### ✅ Logros del Checkpoint actual
- [x] **Slimefun 6**: Salto generacional para soporte nativo de 1.21.11.
- [x] **Dough-Core (1.3.1-DRAKE)**: Unificación total de librerías.
- [x] **20 componentes confirmados**: `Slimefun 6 Core`, `dough-core` y 18 addons/librerías ya documentados como listos.
- [x] **Forks activos de Chagui**: `Networks_Better_Compatibility` y `Cultivation_Updated` reemplazan a las variantes antiguas.
- [x] **Batch técnico cerrado**: `SMG`, `Supreme`, `TranscEndence`, `CrystamaeHistoria`, `ExoticGarden` y otros módulos clave ya quedaron alineados al checkpoint actual.

### 📌 Estado real del tablero
- `53` módulos activos en el reactor raíz.
- `20` componentes confirmados para `1.21.11`.
- `33` módulos aún pendientes de validación final, port o documentación.
- La documentación prioriza **el estado real del workspace**, no el conteo histórico de la wiki pública.

### 🔧 Qué Hace El Reactor
- El `pom.xml` raíz centraliza `Java 21`, `Paper 1.21.11`, `Slimefun 6.0`, `dough-core` y librerías comunes.
- Permite compilar por módulo con `-pl` sin perder una base común de versiones.
- Implementa **reflexión estratégica** para desacoplar APIs de terceros (mcMMO, etc.) y permitir compilación limpia.

### 🗺️ Pilares de la Arquitectura
| Componente | Descripción |
| :-- | :-- |
| **`dough-core`** | Versión nativizada para 1.21.11. Unifica 13 módulos en uno solo (`dev.drake.dough`). |
| **`Version Bridge`** | Abstracción total entre el antiguo NBT/PDC y los nuevos componentes de ítem. |
| **`Slimefun 6 Core`** | El motor de Slimefun modernizado para Paper 1.21.11. |

### 🤝 Créditos y Autores
Damos crédito a todos los visionarios detrás de este ecosistema:

- **[TheBusyBiscuit](https://github.com/TheBusyBiscuit)**: Creador original de Slimefun.
- **[Sefiraat](https://github.com/Sefiraat)**: Genio detrás de Networks, AlchimiaVitae, CrystamaeHistoria y las librerías de expansión.
- **[Mooy1](https://github.com/Mooy1)**: Creador original de InfinityExpansion.
- **[Sfiguz7](https://github.com/Sfiguz7)**: Creador original de DankTech2.
- **[Chagui68](https://github.com/Chagui68)**: Aportes fundamentales en compatibilidad de redes y cultivos.
- **[Pablo Elías](https://github.com/JackStar6677-1)**: Arquitecto del **Drake Framework** y líder de la migración a **Slimefun 6**.

---
<div align="center">
Desarrollado con ❤️ por <b>DrakesCraft-Labs</b>
</div>
