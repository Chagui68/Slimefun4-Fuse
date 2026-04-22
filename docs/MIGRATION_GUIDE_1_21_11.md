# 📖 Guía Técnica de Migración: Slimefun - Minecraft 1.21.11

Esta guía resume los descubrimientos técnicos, soluciones a errores comunes y estrategias de compilación optimizadas para el ecosistema Slimefun en la versión 1.21.11 y Java 21.

## 🛠️ Descubrimientos Técnicos (Modo Supervivencia)

### 1. El Gran Renombrado (API 1.21.11)
Minecraft 1.20.5+ introdujo cambios masivos en los nombres de las constantes de la API de Bukkit/Paper. Si ves un error de "symbol not found", lo más probable es que sea un cambio de nombre:

| Antiguo (1.20.4) | Nuevo (1.21.11) | Notas |
| :--- | :--- | :--- |
| `Enchantment.LUCK` | `Enchantment.LUCK_OF_THE_SEA` | |
| `Enchantment.ARROW_DAMAGE` | `Enchantment.POWER` | También aplica a KNOCKBACK -> PUNCH |
| `PotionEffectType.JUMP` | `PotionEffectType.JUMP_BOOST` | |
| `EntityType.PRIMED_TNT` | `EntityType.TNT` | El tipo de entidad ahora coincide con el bloque |
| `Particle.FIREWORKS_SPARK` | `Particle.FIREWORK` | |

### 2. Adiós a la Reflexión de Encantamientos
En 1.21.11, el comando `acceptingNew()` y la modificación de campos privados para registrar encantamientos personalizados (como `GlowEnchant`) **ya no funciona** y causa crashes.
- **Solución implementada**: Usar encantamientos existentes (como `LUCK_OF_THE_SEA`) y ocultarlos con `ItemFlag.HIDE_ENCHANTS` para obtener el efecto visual de "brillo" de forma segura.

### 3. Dough-Core Unificado
Se ha creado un "Drake Framework" basado en `dough-core`. Todos los addons deben apuntar a:
```xml
<dependency>
    <groupId>dev.drake.dough</groupId>
    <artifactId>dough-core</artifactId>
    <version>1.3.1-DRAKE</version>
</dependency>
```

---

## 🏗️ Estrategia de Compilación (Maven)

El `pom.xml` raíz funciona como **reactor Maven**. No es un plugin más: coordina módulos, versiones y dependencias comunes del laboratorio de migración.

### Qué hace exactamente el `pom` pesado
- fija la versión global de `Java`, `Paper`, `Slimefun` y `dough-core`
- define qué addons y librerías forman parte del build actual
- resuelve el orden lógico entre librerías base y addons dependientes
- permite compilar un módulo concreto con `-pl` sin perder consistencia
- evita repetir el mismo cambio de versión o dependencia en docenas de repos

El reactor principal tiene muchos módulos. Compilarlos todos a la vez consumirá mucho CPU y RAM.

### Atajos y Comandos Salvavidas
- **Compilar solo UN plugin** (Recomendado):
  `mvn install -pl :nombre-del-addon`
- **Modo Offline** (Cuando una repo de un tercero falla):
  `mvn install -o -pl :module`
- **Reanudar desde un punto de fallo**:
  `mvn install -rf :módulo-donde-falló`

### Repositorios "Envenenados"
Si Maven se queda colgado descargando metadatos de `angeschossen` o `william278`, **bórralos del POM local**. Estos repositorios están caídos y bloquean el build por tiempos de espera.

---

## 📂 Estado de los Addons (Audit)
Actualmente tenemos integrados en el workspace:
1. **Batch 2 Expansion**: `Networks_Better_Compatibility`, `LiteXpansion`, `SlimeTinker`, `Cultivation_Updated`. (Estatus: compilando en 1.21.11).
2. **Community Addons**: ~21 repositorios en la carpeta homónima.
3. **Slimefun Core**: Adaptado para 1.21.11 (Base Drake).

> [!TIP]
> El workspace ya no usa las carpetas antiguas `Networks` y `Cultivation` para el reactor. Fueron reemplazadas por `Networks_Better_Compatibility` y `Cultivation_Updated`.

> [!NOTE]
> La Wiki de Slimefun lista +80 addons. Aún faltan aproximadamente 40 repositorios que no están presentes en este workspace. Se pueden añadir clonando sus ramas master/v4 a la carpeta `community-addons`.

---

## 📅 Hoja de Ruta Detallada (Lo que falta)

A pesar de los grandes avances del Día 1, el ecosistema es masivo. Aquí está el desglose de lo que falta por hacer:

### 1. Finalización de Módulos Críticos (Batch-2)
- [x] **SlimeTinker**: Compila en 1.21.11. Se hizo opcional la integración con `Networks` para evitar bloqueo por dependencias externas.
- [x] **Networks_Better_Compatibility**: Compila en 1.21.11 y reemplaza la variante antigua de `Networks`.
- [x] **Cultivation_Updated**: Compila en 1.21.11 y reemplaza la variante antigua de `Cultivation`.
- [ ] **SMG (Simple Material Generators)**: Actualizar POM y verificar constantes de materiales.
- [ ] **CrystamaeHistoria**: Migrar lógica de partículas y encantamientos.
- [ ] **TranscEndence**: Revisar compatibilidad con el nuevo sistema de teletransporte de la 1.21.
- [ ] **Supreme**: Integración básica y corrección de advertencias.

### 2. Procesamiento Masivo de Addons
- [ ] **Repos-to-port (26 repos)**: Módulos como `ExoticGarden`, `DynaTech` (v2), `ElectricSpawners` y `SoulJars` requieren una revisión individual de `pom.xml` para apuntar al nuevo `dough-core`.
- [ ] **Community-addons (~47 repos)**: Esta es la tarea más larga. Se deben procesar uno por uno buscando:
    - Imports obsoletos.
    - Uso de `org.bukkit.enchantments.Enchantment` (cambiar `LUCK` -> `LUCK_OF_THE_SEA`, etc).
    - Métodos de NMS o Reflection (sustituir por API de Paper).

### 3. Verificación de Lógica de Datos (Components)
- [ ] **PersistentDataAPI**: Auditar el manejo de metadatos en items. La 1.21 cambió los items a "Data Components", lo que puede afectar a cómo Slimefun guarda los IDs de los items.
- [ ] **Androides y Filtros**: Validar que los inventarios de los androides persistan correctamente tras el cambio de formato de NBT a Components.

### 4. Pruebas en Vivo (Runtime)
- [ ] Instalar el `Slimefun4-src` (Core) en un servidor de pruebas 1.21.11.
- [ ] Comprobar que la `SlimefunGuide` se abre y los items se pueden craftear sin errores en consola.

## 🤝 Créditos de Porting
- **Chagui (`Chagui68`)**: sus forks `Networks_Better_Compatibility` y `Cultivation_Updated` quedaron adoptados como variantes activas dentro del workspace para estos addons.

---
*Manual generado para el equipo de DrakesCraft-Labs.*
