# 🐉 DrakesCraft-Labs: Slimefun Ecosystem
### *The Ultimate 1.21.11 Migration & Tech Independence Framework*

<div align="center">

![Version](https://img.shields.io/badge/Minecraft-1.21.11-green?style=for-the-badge&logo=minecraft)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Build](https://img.shields.io/badge/Build-Maven-red?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-GPL--3.0-blue?style=for-the-badge)

**Drake Framework** es la respuesta definitiva para un ecosistema de Slimefun moderno, eficiente e independiente. 
Hemos unificado **+85 repositorios** en un Mono-Repo estratégico para la migración total a la 1.21.11.

[Explorar Código](/sources) • [Checklist de Migración](MIGRATION_CHECKLIST.md) • [Arquitectura](ARCHITECTURE.md)

</div>

---

## ⚡ Estado del Núcleo (SF4 Core)
> [!CAUTION]
> **Componente**: `sources/slimefun-core/Slimefun4-src`
> **Estado**: ⚠️ **PENDIENTE DE ADAPTACIÓN (Target 1.20.6)**
> El núcleo es la pieza más compleja y la base de todo el ecosistema. Su adaptación a los *Data Components* de la 1.21.11 es el requisito previo para que los addons tengan una base estable.

---

## 📊 Dashboard de Complejidad (Porting 1.21.11)

Esta tabla clasifica los componentes según el esfuerzo técnico estimado para su migración exitosa.

| Nivel de Dificultad | Componentes Representativos | Estado de Porteo |
| :--- | :--- | :--- |
| **Nivel 1: Easy** (Items/Recetas) | ExoticGarden, SoulJars, ExtraGear, SFCalc, SMG | ✅ Pilotos Listos |
| **Nivel 2: Medium** (Máquinas/GUIs) | DynaTech, ElectricSpawners, Networks, SlimeChem | ✅ Pilotos Listos |
| **Nivel 3: Hard** (Deep Logic/NMS) | **Slimefun4 Core**, InfinityExpansion, Galactifun | ⚠️ En Investigación |
| **Nivel 4: Riesgo / Legacy** | Addons antiguos de la comunidad (ExtraTools, etc.) | ⏳ Pendiente |

### 🛠️ Plugins Faltantes por Completar
- [ ] **ExtraHeads**: Repositorio oficial pendiente de integración final.
- [ ] **MobCapturer**: Requiere refactor de metadatos de entidades.
- [ ] **HardcoreSlimefun**: Pendiente de revisión de compatibilidad con bloques.

---

## 🏗️ Pilares de la Arquitectura
| Componente | Descripción |
| :-- | :-- |
| **`dough-core`** | Versión nativizada para 1.21.11. Unifica 13 módulos en uno solo (`dev.drake.dough`). |
| **`Version Bridge`** | Abstracción total entre el antiguo NBT/PDC y los nuevos componentes de ítem. |
| **`Multi-Module Maven`** | Organización centralizada de dependencias y versiones para +85 módulos. |

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
