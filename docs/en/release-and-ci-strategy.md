# Release and CI Strategy

## Goal

Define a clear policy for artifact publication and automation in `drakes-slimefun-labs` without confusing the migration lab with a single stable monolithic distribution.

## Current state

This repository is a large staged `Maven reactor`.

That means:

- not every module has the same runtime validation level
- some modules still carry version labels such as `UNOFFICIAL`, `MODIFIED`, or similar
- the fact that a module builds does not automatically mean it should be published as a stable release

## Main decision

The project should not publish one massive release containing every reactor `.jar` as if it were a single production-ready product.

Instead, the recommended strategy is:

1. use CI to validate curated groups of stable modules
2. keep downloadable workflow artifacts for fast review
3. publish manual or semi-manual releases only for selected stacks or modules

## What does make sense to publish

### Base stack releases

Good candidates:

- `dough-core`
- Drake `Slimefun` core

### Clearly scoped library or addon releases

Good candidates:

- `InfinityLib`
- `InfinityExpansion`
- `SimpleUtils`
- `ExoticGarden`

### Curated batch releases

Only if documented carefully:

- a build-validated and smoke-tested addon batch
- a family of modules with a shared dependency line

## What should not be done yet

- a single release bundling dozens of unrelated `.jar` files
- one global tag that suggests uniform stability across the whole reactor
- automatic release publication on every `push` without filtering

## Recommended CI

The first automation layer should be conservative.

Goal of the first workflow:

- use `Java 21`
- run isolated builds with `-pl` and `-am`
- work only on stable curated groups
- upload downloadable artifacts

## Recommended current workflow

`ci-curated-modules.yml`

Planned groups:

- `core-stack`
- `ecosystem-libs`
- `validated-addons`

This makes it possible to:

- validate the critical stack without building everything
- catch regressions in representative modules
- provide useful artifacts without overgrowing the pipeline

## Release policy

A release should happen when:

- the module or group has consistent validated builds
- its version and naming are reasonable for public consumption
- there is no known active API or dependency blocker
- if the module needs it, it already passed basic runtime validation

## Suggested next steps

1. maintain and tune the curated CI
2. review naming/versioning for real release candidates
3. create manual draft releases for genuinely stable modules
4. only then evaluate automated releases
