package com.df.common.sonar.extension.rules;

import com.df.common.sonar.extension.ExtensionPluginConstants;
import com.df.common.sonar.extension.rules.type.InterfaceNamingRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class InterfaceNamingRuleTest {

    @Test
    public void test1() {
        JavaCheckVerifier.verify("src/test/files/IOrderService.java",
                new InterfaceNamingRule(), ExtensionPluginConstants.USING_JAVA_VERSION);
    }
}
