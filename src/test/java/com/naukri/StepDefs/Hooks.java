package com.naukri.StepDefs;

import io.cucumber.java.BeforeAll;
import org.testng.annotations.BeforeMethod;

public class Hooks {

    @BeforeAll
    public static void beforeMethod()
    {
        System.out.println(" ************** before method ****************");
    }
}
