# Migration Checklist

## Executive Summary

- Real repository universe: `87 addons + 2 base modules`
- Current active reactor: `59 modules`
- Ready in reactor: `57`
- Active with confirmed failures: `2`
- Outside the reactor: `30`
- Real raw backlog: `32 addons`

## Reading Rule

- If a page says `pending`, verify whether it means reactor pending work or full repository pending work.
- The reactor board does not replace the total repository inventory.
- For operational tracking, both numbers matter.

## Status by Layer

### Current Reactor

- Already included in the root `pom.xml`
- Goal: make them build cleanly without breaking the unified reactor
- Active unresolved failures: `2`

### Outside the Reactor

- Present under `sources/*`, but not yet integrated into the unified build
- Goal: triage, validate `pom.xml`, or convert from Gradle where needed
- Remaining pending addons: `30`

## Current Priority

1. Close the active failures still inside the reactor.
2. Integrate quick wins that already have a usable `pom.xml`.
3. Leave old variants or Gradle-heavy projects for later.

## Quick Wins Outside the Reactor

- `MoreResearches`
- `SfBetterChests`
- `SlimeHUD`
- `SmallSpace`
- `Quaptics`
