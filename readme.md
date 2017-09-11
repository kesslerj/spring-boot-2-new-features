# Demo Project to show new features in Spring-Boot 2.0.0 compared to 1.x

This project covers several changes in spring-boot 2.0.0 which are worth knowing. For a complete list of changes please take a look at the [official release notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes).

Currently this project contains changes from the latest released milestone 2.0.0M3.

__Code structure__
This repository contains two spring-boot-projects:
- `spring-boot-2-demo` which shows the new features, see below.
- `spring-boot-1-demo` which is meant to show the old behaviour

## @Nullable
See package `de.acando.jk.bootdemo.newfeatures.nullable`.

`@Nullable` annotation can be used in controller to define that e.g. a RequestParam is not required.

This feature comes from spring-framework 5.0 and not from spring-boot 2.0.0 directly.

## Actuator
- All managing endpoints are moved to `/application`, for example the info endpoint is now available under `/application/info`.
- Autoconfig endpoint contains autoconfigurations whithout conditions (@Conditional... annotations).

Can be changed with property `management.context-path`.

## @ConfigurationProperties needs @Validated
`@Valiadated` is now required, if there are any validation annotations in a `@ConfigurationProperties` class, which should be requested at startup.

## Changed or removed properties
- Several servlet related properties are now properly named, e.g.: `server.context-path` replaced with `server.servlet.context-path`
- Paging in spring-data-web can now easily be configured via properties (no example in project, but good to know)

## New spring-boot-starter-json
Includes dependencies `jackson-databind`, `jackson-datatype-jsr310` (necessary for convenient handling of java 8 data types) among others. The `spring-boot-starter-json` is in 2.0.0 included everywhere, where `jackson-databind` was used in 1.x. E.g. in the `spring-boot-starter-web`, so for my normal project setup there is no jackson dependency to be added explicitly anymore.