# Welcome to the Drakes Slimefun Labs Wiki

> [!NOTE]
> This wiki documents the real state of the migration lab for `Paper 1.21.11`, `Java 21`, `Slimefun 6`, and `dough-core 1.3.1-DRAKE`.

## Real Status

- Addons present in the repository: `87`
- Base modules: `2`
- Total workspace universe: `89`
- Active modules in the reactor: `59`
- Ready modules inside the reactor: `57`
- Active modules with confirmed failures: `2`
- Addons outside the reactor: `30`
- Real raw backlog: `32 addons`

> [!TIP]
> The full explicit inventory now lives in [README_EN.md](../README_EN.md). Use it as the public human source of truth.

## Quick Navigation

- [[Migration Checklist]]
- [[Pending Modules]]
- [GitHub project backlog](https://github.com/orgs/DrakesCraft-Labs/projects/1/views/1)
- [[Stabilization Roadmap]]
- [[Technical Reference (Paper 1.21.1)]]
- [[Smoke Test Guide]]
- [[Development Setup]]
- [[New-Addon-Template-EN]]
- [[Tomorrow-Handoff-EN]]
- [Release and CI Strategy](release-and-ci-strategy.md)

## What the Numbers Mean

- `Active reactor`: what currently builds under the unified root `pom.xml`.
- `Active with confirmed failure`: addons already integrated into the build but not closed yet.
- `Outside reactor`: addons present in `sources/*` that are not yet part of the unified build.
- `Raw backlog`: the sum of unresolved reactor modules plus everything still outside the reactor.

## Recommended Route

- First close the `2` active failures still inside the reactor.
- Then integrate quick wins that already have a usable `pom.xml`.
- Leave old variants and tooling-heavy cases for explicit triage later.

## Current Quick Wins

- `MoreResearches`
- `SfBetterChests`
- `SlimeHUD`
- `SmallSpace`
- `Quaptics`

## Latest Validated Closures

- `MapJammers`
- `HeadLimiter`
- `MiniBlocks`
- `DyeBench`
- `Element-Manipulation`
- `MissileWarfare`

## Active Confirmed Failures

- `GeneticChickengineering-Reborn`
- `PotionExpansion`

## Language

- Spanish wiki home: [[Home]]
- English wiki home: [[Home-EN]]
