package com.df.common.sonar.extension.rules;

import com.df.common.sonar.extension.rules.type.LowerCamelCaseRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class LowerCamelCaseRuleTest {


    @Test
    public void testLowerCamelCaseRuleCase1() {
        JavaCheckVerifier.verify("src/test/files/AuditBuyingOrderParam.java", new LowerCamelCaseRule());
    }

    @Test
    public void testLowerCamelCaseRuleCase2() {

    }


    @Test
    public void testLowerCamelCaseRuleCase3() {

    }


}
