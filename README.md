# 🐉 DrakesCraft-Labs: Slimefun Ecosystem
### *The Ultimate 1.21.11 Migration & Tech Independence Framework*

<div align="center">

![Version](https://img.shields.io/badge/Minecraft-1.21.11-green?style=for-the-badge&logo=minecraft)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Build](https://img.shields.io/badge/Build-Maven-red?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-GPL--3.0-blue?style=for-the-badge)

**Drake Framework** es la respuesta definitiva para un ecosistema de Slimefun moderno, eficiente e independiente.
Este repo funciona como **laboratorio de migración**: un mono-repo estratégico para unificar versiones, dependencias, compatibilidad Paper y fixes repetidos antes de volver a separar addons.

[Explorar Código](/sources) • [Checklist de Migración](MIGRATION_CHECKLIST.md) • [Arquitectura](ARCHITECTURE.md) • [Dev Setup](docs/DEV_SETUP.md)

</div>

---

## ⚡ Estado del Núcleo (SF4 Core)
> [!CAUTION]
> **Componente**: `sources/slimefun-core/Slimefun4-src`
> **Estado**: ⚠️ **MIGRADO PARCIALMENTE (Target 1.21.11)**
> Se ha establecido el Framework de Drake como base. El núcleo ya permite la compilación de addons dependientes mediante el uso de `dough-core` unificado.

---

## 📊 Dashboard de Complejidad (Porting 1.21.11)

Esta tabla clasifica los componentes según el esfuerzo técnico estimado para su migración exitosa.

| Nivel de Dificultad | Componentes Representativos | Estado de Porteo |
| :--- | :--- | :--- |
| **Nivel 1: Easy** (Items/Recetas) | ExoticGarden, SoulJars, ExtraGear | ⏳ Pendiente |
| **Nivel 2: Medium** (Máquinas/GUIs) | LiteXpansion, Networks_Better_Compatibility, SlimeChem | ✅ LiteXpansion y compatibilidad de Networks listas |
| **Nivel 3: Hard** (Deep Logic/NMS) | **Slimefun4 Core**, SlimeTinker, InfinityExpansion | ✅ SlimeTinker compila en 1.21.11 |
| **Nivel 4: Riesgo / Legacy** | Addons antiguos (ExtraTools, etc.) | ⏳ Pendiente |

### ✅ Logros del Checkpoint actual
- [x] **Dough-Core (1.3.1-DRAKE)**: Unificación total de librerías.
- [x] **Networks_Better_Compatibility**: Compila en 1.21.11 y reemplaza al `Networks` viejo dentro del workspace.
- [x] **LiteXpansion**: Eliminación de hacks de reflexión para compatibilidad total con Java 21.
- [x] **SlimeTinker**: Compilación restaurada en 1.21.11 con integración de `Networks` degradada a opcional.
- [x] **Cultivation_Updated**: Compila en 1.21.11 y reemplaza al `Cultivation` viejo dentro del workspace.

### 🔧 Qué Hace El Reactor
- El `pom.xml` raíz no es “un plugin gigante”; es un **parent/reactor Maven**.
- Centraliza `Java 21`, `Paper 1.21.11`, `Slimefun RC-37`, `dough-core` y librerías comunes para que los módulos no repitan lo mismo.
- Declara qué carpetas del workspace participan en el build y en qué orden conviene resolver dependencias.
- Permite compilar por módulo con `-pl` sin perder una base común de versiones.
- Su función principal es **coordinar** el port masivo, no reemplazar el destino final de tener repos separados.

### 🤝 Créditos
- **Chagui (`Chagui68`)**: referencia práctica y base adoptada para el port con sus forks `Networks_Better_Compatibility` y `Cultivation_Updated`, ahora integrados como reemplazo de las variantes antiguas.

---

## 🏗️ Pilares de la Arquitectura
| Componente | Descripción |
| :-- | :-- |
| **`dough-core`** | Versión nativizada para 1.21.11. Unifica 13 módulos en uno solo (`dev.drake.dough`). |
| **`Version Bridge`** | Abstracción total entre el antiguo NBT/PDC y los nuevos componentes de ítem. |
| **`Multi-Module Maven Reactor`** | Parent POM que centraliza versiones, módulos y dependencias comunes para coordinar el porting masivo. |

## 📂 Organización del Proyecto
```bash
/
├── sources/               # Central de Código Fuente
│   ├── dough-core/        # Librería base Drake Framework
│   ├── slimefun-core/     # Slimefun4 Original (Core a portar)
│   ├── repos-to-port/     # Batch 1: Addons Oficiales / Alta Prioridad
│   ├── batch-2-expansion/ # Batch 2: Addons de Expansión
│   └── community-addons/  # Archivo masivo de la comunidad (Wiki Full)
├── deploy/                # Entornos de prueba aislados
├── scripts/               # Automatización y Herramientas
└── docs/                  # Inteligencia y Roadmaps
```

---
<div align="center">
Desarrollado con ❤️ por <b>DrakesCraft-Labs</b>
</div>
