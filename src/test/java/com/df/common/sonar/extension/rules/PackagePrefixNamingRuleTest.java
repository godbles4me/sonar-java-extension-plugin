package com.df.common.sonar.extension.rules;

import com.df.common.sonar.extension.ExtensionPluginConstants;
import com.df.common.sonar.extension.rules.structure.PackagePrefixNamingRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class PackagePrefixNamingRuleTest {

    @Test
    public void test1() {
        JavaCheckVerifier.verify("src/test/files/AuditBuyingOrderParam.java",
                new PackagePrefixNamingRule(), ExtensionPluginConstants.USING_JAVA_VERSION);
    }
}
