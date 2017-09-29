# Demo Project to show new features in Spring-Boot 2.0.0 compared to 1.x

This project covers several changes in spring-boot 2.0.0 which are worth knowing. For a complete list of changes please take a look at the [official release notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes).

Currently this project contains changes from the latest released milestone 2.0.0M4.

__Code structure__<br/>
This repository contains two spring-boot-projects:
- `spring-boot-2-demo` which shows the new features, see below.
- `spring-boot-1-demo` which is meant to show the old behaviour

TODO:
 - Boot: spring security, small config added to code, no documentation here

# Features inherited from Spring Framework 5.0.0

## @Nullable and @NonNullApi

> Intention of the spring developers was to "leverage [JSR 305](https://jcp.org/en/jsr/detail?id=305) (...) meta-annotations to specify explicitly
null-safety of Spring Framework parameters and return values", compare this  [commit message](https://github.com/spring-projects/spring-framework/commit/87598f48e41d483745aba56cbf4e998c6f6d680c#diff-31f527c92f7d3887b2320e4a28e7be8a). <br/>
> Another aim was to make the Spring-Framework null-safe for Kotlin. The annotations are also used for static code analysis, e.g. IntelliJ produces warnings when unsafe nullable usages are detected.

Besides these points described above, the `@Nullable` annotation can be used to declare that a object can be null which means it is not required. Places where it can be used: 
- On field injection
- On controller injection
- In controllers requestmapping methods to define that e.g. a RequestParam is not required.

Example implementation see package `newfeaturesin2.nullable` in both projects.

## Candidate Component Index
There is a new package `spring-context-indexer` which, if included as dependency, creates a index file `META-INF/spring.components` at build time. This file lists all candidate components (Spring Beans) as well as JPA candidates (Entities, Repositories).

Add following maven dependendy to active the new feature:

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context-indexer</artifactId>
    </dependency>

For more details for this new feature see the [commit message](https://github.com/snicoll/spring-framework/commit/dc160f6fd1f3623bf14b375c14a9b5065e660377) and the [JIRA Discussion](https://jira.spring.io/browse/SPR-11890).

Simple hint for taking a look at the new mechanism via debugging in an IDE:
- CAUTION: This is just for taking a look at the new mechanism, should be reverted if going back to developing! 
- Run a build, then copy `META-INF/spring.components` from the jar file to `src/main/resources/META-INF/spring.components`
- Breakpoints in 
  * `CandidateComponentsIndexLoader.loadIndex(..)` where the index file is loaded
  * `ClassPathScanningCandidateComponentProvider.findCandidateComponents(..)` where the index is used ix exists, otherwise class path is scanned

To see that it works for JPA related candidates, checkout the branch `jpa` and run a build.


## Changed or removed properties
- Several servlet related properties are now properly named, e.g.: `server.context-path` replaced with `server.servlet.context-path`
- Paging in spring-data-web can now easily be configured via properties (no example in project, but good to know)



# Features from Spring Boot 2.0.0

## Actuator
- All managing endpoints are moved to `/application`, for example the info endpoint is now available under `/application/info`. Default actuator endpoint can be changed with property `management.context-path`.
- Autoconfig endpoint contains autoconfigurations whithout conditions (@Conditional... annotations).
- Creating a custom actuator endpoint is much more easier now. Check out class `PersonActuatorEndpoint` in package `newfeaturesin2.actuator`. <br/>
TODO: Implementation in spring-boot 1.x is still missing


## @ConfigurationProperties needs @Validated

`@Validated` is now required, if there are any validation annotations in a `@ConfigurationProperties` class, which should be requested at startup.

Example implementation: see package `newfeaturesin2.properties` in both projects. In v1.x the application fails starting, if the property `test.any` is not set. In v2.x it only fails if the `@Validated` annotation is used.

## New spring-boot-starter-json
Includes dependencies `jackson-databind`, `jackson-datatype-jsr310` (necessary for convenient handling of java 8 data types) among others. The `spring-boot-starter-json` is in 2.0.0 included everywhere, where `jackson-databind` was used in 1.x. E.g. in the `spring-boot-starter-web`, so for my normal project setup there is no jackson dependency to be added explicitly anymore.