# Arquitectura del Ecosistema

## Qué es este laboratorio

`drakes-slimefun-labs` no es un plugin único. Es un monorepo de consolidación para portar, estabilizar y documentar un ecosistema de addons Slimefun sobre `Paper 1.21.11` y `Java 21`.

## Piezas base

### `sources/dough-core`

- grupo: `dev.drake.dough`
- versión base actual: `1.3.1-DRAKE`
- función: librería compartida para el stack completo

### `sources/slimefun-core/Slimefun4-src`

- grupo: `dev.drake`
- artefacto: `Slimefun`
- versión base actual: `6.0-Drake-1.21.11`
- función: core adaptado del ecosistema

## Reactor Maven

El `pom.xml` raíz centraliza:

- versiones
- dependencias
- módulos activos
- alineación de parent para addons integrados

Esto permite trabajar addon por addon sin compilar todo el universo del repo.

## Zonas del workspace

- `sources/repos-to-port`: batch prioritario ya estabilizado
- `sources/batch-2-expansion`: librerías, expansiones y variantes activas
- `sources/community-addons`: addons comunitarios integrados de forma progresiva
- `templates/slimefun-addon`: plantilla base para nuevos módulos
- `wiki_temp`: mirror local editable de la wiki pública

## Variantes Activas

En algunos casos el addon histórico no es la referencia correcta. Hoy las variantes activas adoptadas son:

- `Cultivation_Updated`
- `Networks_Better_Compatibility`

Las variantes `Cultivation` y `Networks` originales siguen presentes en el repo, pero no deben contarse como activas ni listas.

## Filosofía de cierre

Un addon se considera estabilizado cuando:

- compila correctamente
- está alineado al parent y a las dependencias Drake
- no deja errores activos de API conocidos
- su estado quedó documentado

## Navegación Relacionada

- [[Checklist de Migración]]
- [[Módulos Pendientes]]
- [[Referencia Técnica (Paper 1.21.1)]]
