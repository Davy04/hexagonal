package com.woolley.hexagonal.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

// Camadas: LayeredArchitectureTest. Nomes e pacotes: NamingConventionTest.
@AnalyzeClasses(packages = "com.woolley.hexagonal", importOptions = ImportOption.DoNotIncludeTests.class)
class ArchitectureTest {

    // O núcleo é Java puro: nada de Spring, Mongo, Kafka...
    @ArchTest
    static final ArchRule applicationIsFrameworkFree = noClasses()
            .that().resideInAPackage("..application..")
            .should().dependOnClassesThat().resideInAnyPackage(
                    "org.springframework..", "org.apache.kafka..", "org.mongodb..", "com.mongodb..", "lombok..");

    @ArchTest
    static final ArchRule portsAreInterfaces = classes()
            .that().resideInAnyPackage("..application.ports.in..", "..application.ports.out..")
            .should().beInterfaces();

    @ArchTest
    static final ArchRule outputAdaptersAreComponents = classes()
            .that().resideInAPackage("..adapters.out")
            .should().beAnnotatedWith(Component.class);

    // Sem @Component o Spring não registra o @KafkaListener e as mensagens são ignoradas
    @ArchTest
    static final ArchRule consumersAreComponents = classes()
            .that().resideInAPackage("..adapters.in.consumer")
            .should().beAnnotatedWith(Component.class);
}
