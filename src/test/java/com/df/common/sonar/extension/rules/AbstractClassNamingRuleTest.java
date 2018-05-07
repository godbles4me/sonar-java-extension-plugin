package com.df.common.sonar.extension.rules;

import com.df.common.sonar.extension.ExtensionPluginConstants;
import com.df.common.sonar.extension.rules.type.AbstractClassNamingRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class AbstractClassNamingRuleTest {

    @Test
    public void test1() {
        JavaCheckVerifier.verify("src/test/files/BaseController.java",
                new AbstractClassNamingRule(), ExtensionPluginConstants.USING_JAVA_VERSION);
    }

    @Test
    public void test2() {
        JavaCheckVerifier.verify("src/test/files/AbstractService.java",
                new AbstractClassNamingRule(), ExtensionPluginConstants.USING_JAVA_VERSION);
    }
}
