# refresher_java8+

The project is organized into mutliple modules.

## Java8+ concepts

- Consumer
- Supplier
- Lambda
- BiConsumer
- BiFunction
- Function
- BiSupplier
- IntStream
- Stream functions
- Generics review - bounded and unbounded wildcards, invariance, covariance and contravariance

## Lombok

### Annotation practice

Examples in the [Lombok](./lombok) module contain the following annotations:
- @Data, 
- @Builder, 
- @Builder.Default
- @Getter
- @ToString
- @EqualsAndHashCode

### What did I learn?
 - Key annotations, usage and an example
 - Use JEP 286 - Local Variable Type Inference with Lombok
 - Read and understand when to use : JEP 395 (Java Records) vs @Data and @Value
 - Use `val` to assign `final` local inference type variables over vanilla `var`
 - Use Java Record with lombok annotations
 - How to generate mutable setters for specific fields with Lombok @With on Java Records
 - Understand `@Cleanup`
 - Caching expensive calls to data using `@Getter(lazy=true)`
 - Optionally, use `@SneakyThrows` to convert checked exceptions to unchecked exceptions