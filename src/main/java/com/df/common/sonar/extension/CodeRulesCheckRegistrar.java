package com.df.common.sonar.extension;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonarsource.api.sonarlint.SonarLintSide;

/**
 * 代码规则检查注册中心
 *
 * @author Daniel Lea
 */
@SonarLintSide
public class CodeRulesCheckRegistrar implements CheckRegistrar {

    @Override
    public void register(final RegistrarContext registrarContext) {
        registrarContext
                .registerClassesForRepository(ExtensionPluginConstants.REPOSITORY_KEY,
                        CheckClassesCenter.getJavaChecks(), CheckClassesCenter.getJavaTestChecks());
    }


}
