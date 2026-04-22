# Estándares de Desarrollo: Drake Framework (1.21.1+)

Este documento establece las reglas técnicas para mantener la estabilidad del ecosistema Slimefun y prevenir regresiones de versión o bloqueos de runtime.

## 1. Gestión de Versiones del Reactor (Maven)

> [!IMPORTANT]
> **PROHIBIDO** el uso de versiones hardcodeadas en los archivos `pom.xml` de los submódulos.

- Todos los submódulos **deben** declarar el `<parent>` apuntando al reactor raíz (`drakes-slimefun-labs`).
- Las versiones de dependencias críticas deben usar exclusivamente las propiedades del parent:
    - `${paper.version}`: Para la API de Paper/Spigot.
    - `${slimefun.drake.version}`: Para la dependencia de Slimefun Core.
    - `${java.version}`: Para el compilador (debe ser 21).

## 2. Compatibilidad de Minecraft (Core)

> [!WARNING]
> Nunca uses una versión de parche específica (ej. .11) como requisito mínimo en `MinecraftVersion.java` a menos que sea estrictamente necesario por cambios en la API de Mojang.

- **Regla de Parche 0**: Al añadir soporte para una nueva rama (ej. 1.21), define el `minorVersion` como `0`. Esto garantiza compatibilidad con 1.21, 1.21.1, 1.21.2, etc.
- **Detección Dinámica**: Slimefun debe habilitarse en cualquier servidor que reporte la versión mayor correcta, delegando la seguridad de la API a las verificaciones internas de `PaperLib`.

## 3. Estándares de Código (Paper 1.21.1)

- **Atributos**: Usa siempre el prefijo `GENERIC_` para atributos de entidades si la versión de la API lo requiere (ej. `Attribute.GENERIC_MAX_HEALTH`).
- **Data Components**: Para 1.20.5+, prioriza el uso de la API de Paper para componentes persistentes en lugar de NMS.

## 4. Prevención de "Pranks" / Sabotaje

- Cualquier cambio en la lógica de validación de inicio (`StartupWarnings.java` o `Slimefun.java`) que bloquee el cargado del plugin basándose en cadenas de texto ficticias será marcado como un error crítico de estabilización.

---
*Drake Framework v1.0 - Estabilización de Laboratorio.*
