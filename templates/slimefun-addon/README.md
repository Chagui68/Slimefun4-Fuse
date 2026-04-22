# TemplateAddon

Plantilla mínima para crear addons nuevos sobre este workspace.

## Qué reemplazar

- `TemplateAddon` por el nombre real del addon
- `dev.drake.template` por tu package real
- `TemplateMachine` por tu primer item o máquina
- ids como `TEMPLATE_MACHINE` y `template_research`

## Si va dentro del monorepo

- mueve esta carpeta a `sources/repos-to-port`, `sources/batch-2-expansion` o `sources/community-addons`
- corrige `relativePath` del `pom.xml` si cambia la profundidad
- agrega el módulo al `pom.xml` raíz

## Primer build

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```
