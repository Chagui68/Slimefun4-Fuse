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
1. **53 módulos activos** en el reactor raíz.
2. **Batch 2 Expansion**: `SefiLib`, `InfinityLib`, `Cultivation_Updated`, `LiteXpansion`, `Networks_Better_Compatibility`, `SlimeTinker`, `SMG`, `Supreme` y `TranscEndence`.
3. **Community Addons**: `18` módulos activos en la carpeta homónima.
4. **Slimefun Core**: Adaptado para 1.21.11 como base Drake.

> [!TIP]
> El workspace ya no usa las carpetas antiguas `Networks` y `Cultivation` para el reactor. Fueron reemplazadas por `Networks_Better_Compatibility` y `Cultivation_Updated`.

> [!NOTE]
> La Wiki de Slimefun lista más addons de los que hoy existen dentro del laboratorio. Esta guía se centra en el **estado real del workspace local**: `25` componentes ya confirmados y `28` módulos pendientes dentro del reactor actual.

---

## 📅 Hoja de Ruta Detallada (Lo que falta)

A pesar de los grandes avances del Día 1, el ecosistema es masivo. Aquí está el desglose de lo que falta por hacer:

### 1. Finalización de Módulos Críticos (Batch-2)
- [x] **SlimeTinker**: Compila en 1.21.11. Se hizo opcional la integración con `Networks` para evitar bloqueo por dependencias externas.
- [x] **Networks_Better_Compatibility**: Compila en 1.21.11 y reemplaza la variante antigua de `Networks`.
- [x] **Cultivation_Updated**: Compila en 1.21.11 y reemplaza la variante antigua de `Cultivation`.
- [x] **SMG (Simple Material Generators)**: Compila en 1.21.11.
- [x] **CrystamaeHistoria**: Portado a 1.21.11 y ya no bloquea el reactor.
- [x] **TranscEndence**: Compila en 1.21.11.
- [x] **Supreme**: Compila en 1.21.11.
- [x] **PrivateStorage**: Alineado al parent/reactor y compilando en 1.21.11.
- [x] **ElectricSpawners**: Alineado al parent/reactor y compilando en 1.21.11.
- [x] **SFMobDrops**: Verificado con build aislado.
- [x] **GlobalWarming**: Verificado con build aislado.
- [x] **SimpleUtils**: Build aislado validado; el bloqueo estaba en `InfinityLib` fijando una versión vieja de `dev.drake:Slimefun`.

### 2. Procesamiento Masivo de Addons
- [ ] **Repos-to-port pendientes**: El frente activo ya no incluye `ExoticGarden`, `SoulJars`, `ExtraGear`, `ColoredEnderChests`, `DyedBackpacks` ni `InfinityExpansion`, porque ya forman parte del checkpoint confirmado. El trabajo sigue sobre módulos como `DynaTech`, `ElectricSpawners`, `SlimeChem`, `SoundMuffler` y compañía.
- [ ] **Community-addons pendientes**: El siguiente tramo sigue siendo el más largo. Se deben procesar módulo por módulo buscando imports obsoletos, renombres de API Bukkit/Paper 1.21 y reemplazo de reflection/NMS por Paper cuando sea viable.

### 3. Verificación de Lógica de Datos (Components)
- [ ] **PersistentDataAPI**: Auditar el manejo de metadatos en items. La 1.21 cambió los items a "Data Components", lo que puede afectar a cómo Slimefun guarda los IDs de los items.
- [ ] **Androides y Filtros**: Validar que los inventarios de los androides persistan correctamente tras el cambio de formato de NBT a Components.

### 4. Pruebas en Vivo (Runtime)
- [ ] Instalar el `Slimefun4-src` (Core) en un servidor de pruebas 1.21.11.
- [ ] Comprobar que la `SlimefunGuide` se abre y los items se pueden craftear sin errores en consola.

## 📍 Dónde quedó el proyecto
- `README.md` y `MIGRATION_CHECKLIST.md` ya reflejan el conteo real del reactor.
- Los forks activos de Chagui para `Networks` y `Cultivation` quedaron adoptados como variantes oficiales del laboratorio.
- El siguiente trabajo ya no es "arreglar la base", sino seguir bajando la cola de los `28` módulos pendientes con compilación aislada vía `-pl`.

## 🤝 Créditos de Porting
- **Chagui (`Chagui68`)**: sus forks `Networks_Better_Compatibility` y `Cultivation_Updated` quedaron adoptados como variantes activas dentro del workspace para estos addons.

---
*Manual generado para el equipo de DrakesCraft-Labs.*
