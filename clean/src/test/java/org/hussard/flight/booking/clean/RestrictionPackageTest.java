package org.hussard.flight.booking.clean;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import com.tngtech.archunit.library.Architectures;
import org.hussard.flight.booking.clean.architecture.Layers;
import org.hussard.flight.booking.clean.architecture.Packages;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

/**
 * @link{https://github.com/TNG/ArchUnit-Examples/tree/main/example-plain/src/test/java/com/tngtech/archunit/exampletest}
 */
@AnalyzeClasses(packages = "uk.co.samhogy.example.archunit", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
class RestrictionPackageTest {
    private JavaClasses jc = new ClassFileImporter()
            .withImportOption(ImportOption.DoNotIncludeJars)
            .importPackages("org.hussard.flight.booking");

    static final ArchRule layer_dependencies_are_respected = layeredArchitecture().consideringAllDependencies()
            .layer(Layers.BUSINESS_ADAPTER_IN).definedBy(Packages.BUSINESS_PKG_ADAPTER_IN)
            .layer(Layers.BUSINESS_ADAPTER_OUT).definedBy(Packages.BUSINESS_PKG_ADAPTER_OUT)
            .layer(Layers.BUSINESS_MODEL).definedBy(Packages.BUSINESS_PKG_MODEL)
            .layer(Layers.BUSINESS_SERVICES).definedBy(Packages.BUSINESS_PKG_SERVICES)
            .layer(Layers.INFRA_ENTITIES).definedBy(Packages.INFRA_PKG_ENTITIES)
            .layer(Layers.INFRA_SERVICES).definedBy(Packages.INFRA_PKG_SERVICES)
            .layer(Layers.APPLICATION_CONTROLLERS).definedBy(Packages.APPLICATION_PKG_CONTROLLERS)
            .layer(Layers.APPLICATION_SERVICES).definedBy(Packages.APPLICATION_PKG_SERVICES)
            .layer(Layers.APPLICATION_DTO).definedBy(Packages.APPLICATION_PKG_DTO)
            .whereLayer(Layers.BUSINESS_MODEL).mayNotBeAccessedByAnyLayer()
            .whereLayer(Layers.INFRA_ENTITIES).mayNotBeAccessedByAnyLayer()
            .whereLayer(Layers.APPLICATION_DTO).mayNotBeAccessedByAnyLayer()
            .whereLayer(Layers.APPLICATION_CONTROLLERS).mayOnlyBeAccessedByLayers(Layers.APPLICATION_SERVICES,Layers.APPLICATION_DTO);
    @Test
    void Architecture(){
        layer_dependencies_are_respected.check(jc);
    }
    /*@Test
    void Architecture(){
        Architectures.OnionArchitecture adapter = onionArchitecture()
                .domainModels("org.hussard.flight.booking.business.model..")
                .domainServices("org.hussard.flight.booking.business.services..")
                .applicationServices("org.hussard.flight.booking.application..")
                .adapter("in", "org.hussard.flight.booking.business.adapter.in..")
                .adapter("out", "org.hussard.flight.booking.business.adapter.in..")
                .adapter("rest", "org.hussard.flight.booking.infrastructure.repository..");
        adapter.check(jc);
    }*/
    @Test
    void BusinessNotUseApplicationOrInfrastructure() {

        Architectures.LayeredArchitecture arch =  layeredArchitecture()
                .consideringAllDependencies()
                .layer("Application").definedBy("..application..")
                .layer("Business").definedBy("..business..")
                .layer("Infrastructure").definedBy("..infrastructure..")
                .whereLayer("Business").mayNotBeAccessedByAnyLayer();
        arch.check(jc);
    }
    @Test
    void BusinessNotUseApplicationOrInfrastructure2() {
        Architectures.LayeredArchitecture arch = layeredArchitecture()
                .consideringAllDependencies()
                .layer("Application").definedBy("..application..")
                .layer("Business").definedBy("..business..")
                .layer("Infrastructure").definedBy("..infrastructure..")
                .whereLayer("Infrastructure").mayNotBeAccessedByAnyLayer();
        arch.check(jc);
    }
    @Test
    void PasDependenceAvecInfra(){
        ClassesShouldConjunction classesShouldConjunction = noClasses().that().resideInAPackage("..infrastructure..")
                .should().dependOnClassesThat().resideInAPackage("..business..");
        classesShouldConjunction.check(jc);
    }
    @Test
    void test(){
        ArchRule rule =
                classes().that().resideInAPackage("..business..")
                        .should().onlyBeAccessed().byAnyPackage("..application..", "..infrastructure..");
        rule.check(jc);
    }
    @Test
    void test2(){
        ArchRule rule =
                classes().that().resideInAPackage("..application..")
                        .should().onlyBeAccessed().byAnyPackage("..business..", "..infrastructure..");
    }
}
