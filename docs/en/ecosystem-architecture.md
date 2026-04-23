# Ecosystem Architecture

## What This Lab Is

`drakes-slimefun-labs` is not a single plugin. It is a monorepo used to port, stabilize, and document a Slimefun addon ecosystem on top of `Paper 1.21.11` and `Java 21`.

## Base Pieces

### `sources/dough-core`

- group: `dev.drake.dough`
- current base version: `1.3.1-DRAKE`
- function: shared library for the full stack

### `sources/slimefun-core/Slimefun4-src`

- group: `dev.drake`
- artifact: `Slimefun`
- current base version: `6.0-Drake-1.21.11`
- function: adapted ecosystem core

## Maven Reactor

The root `pom.xml` centralizes:

- versions
- dependencies
- active modules
- parent alignment for integrated addons

This makes it possible to work addon by addon without compiling the entire repository universe.

## Workspace Zones

- `sources/repos-to-port`: prioritized batch already stabilized
- `sources/batch-2-expansion`: libraries, expansions, and active variants
- `sources/community-addons`: community addons integrated progressively
- `templates/slimefun-addon`: base template for new modules
- `wiki_temp`: editable local mirror of the public wiki

## Active Variants

In some cases the historical addon is not the correct current target. The active adopted variants today are:

- `Cultivation_Updated`
- `Networks_Better_Compatibility`

The original `Cultivation` and `Networks` variants still exist in the repository, but they must not be counted as active or ready.

## Closure Philosophy

An addon is considered stabilized when:

- it compiles correctly
- it is aligned with the reactor parent and Drake dependencies
- it no longer has known active API failures
- its status has been documented
