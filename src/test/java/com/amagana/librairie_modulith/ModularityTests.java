package com.amagana.librairie_modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityTests {

    static ApplicationModules modules = ApplicationModules.of(LibrairieModulithApplication.class);

    @Test
    void verifiesModularStructure() {
        modules.verify();
    }
}
