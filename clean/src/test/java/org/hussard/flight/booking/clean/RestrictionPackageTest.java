package org.hussard.flight.booking.clean;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class RestrictionPackageTest {
    private JavaClasses jc = new ClassFileImporter()
            .importPackages("org.hussard.flight.booking");
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
    }
    @Test
    void test2(){
        ArchRule rule =
                classes().that().resideInAPackage("..application..")
                        .should().onlyBeAccessed().byAnyPackage("..business..", "..infrastructure..");
    }
}
