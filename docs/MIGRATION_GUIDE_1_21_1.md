# 📖 Guía Técnica de Migración: Slimefun - Minecraft 1.21.1

Esta guía resume los descubrimientos técnicos, soluciones a errores comunes y estrategias de compilación optimizadas para el ecosistema Slimefun en la versión 1.21.1 y Java 21.

## 🛠️ Descubrimientos Técnicos (Modo Supervivencia)

### 1. El Gran Renombrado (API 1.21.1)
Minecraft 1.20.5+ introdujo cambios masivos en los nombres de las constantes de la API de Bukkit/Paper. Si ves un error de "symbol not found", lo más probable es que sea un cambio de nombre:

| Antiguo (1.20.4) | Nuevo (1.21.1) | Notas |
| :--- | :--- | :--- |
| `Enchantment.LUCK` | `Enchantment.LUCK_OF_THE_SEA` | |
| `Enchantment.ARROW_DAMAGE` | `Enchantment.POWER` | También aplica a KNOCKBACK -> PUNCH |
| `PotionEffectType.JUMP` | `PotionEffectType.JUMP_BOOST` | |
| `EntityType.PRIMED_TNT` | `EntityType.TNT` | El tipo de entidad ahora coincide con el bloque |
| `Particle.FIREWORKS_SPARK` | `Particle.FIREWORK` | |

### 2. Adiós a la Reflexión de Encantamientos
En 1.21.1, el comando `acceptingNew()` y la modificación de campos privados para registrar encantamientos personalizados (como `GlowEnchant`) **ya no funciona** y causa crashes.
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

El reactor principal tiene +24 módulos. Compilarlos todos a la vez consumirá el 100% de tu CPU y RAM.

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
1. **Batch 2 Expansion**: `Networks`, `LiteXpansion`, `SlimeTinker`, `EMC2`. (Estatus: Compilando).
2. **Community Addons**: ~21 repositorios en la carpeta homónima.
3. **Slimefun Core**: Adaptado para 1.21.1 (Base Drake).

> [!NOTE]
> La Wiki de Slimefun lista +80 addons. Aún faltan aproximadamente 40 repositorios que no están presentes en este workspace. Se pueden añadir clonando sus ramas master/v4 a la carpeta `community-addons`.

---
*Documentación generada por Antigravity para el equipo de DrakesCraft-Labs.*
