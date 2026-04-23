# AI Start Prompt

Use this summary as a starting point when opening a new session and you need quick context without rereading the whole repository.

## Short context

- branch: `1.21-latin`
- stack: `Paper 1.21.11`, `Java 21`, `Slimefun 6`, `dough-core 1.3.1-DRAKE`
- active reactor: `59` modules
- ready in reactor: `57`
- active failures: `2`
- outside reactor: `30`

## Key rules

- do not compile the whole reactor unless strictly necessary
- use `mvn -pl <path> -am -DskipTests package`
- before editing code, distinguish `pom.xml` failures from API failures
- if a state changes, synchronize `README.md`, `README_EN.md`, and the wiki
