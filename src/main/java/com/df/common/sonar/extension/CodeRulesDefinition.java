package com.df.common.sonar.extension;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.plugins.java.Java;

/**
 * 指定仓库及其代码规则定义
 *
 * @author Daniel Lea
 */
public class CodeRulesDefinition implements RulesDefinition {


    @Override
    public void define(final Context context) {
        // 建立特定编程语言的插件仓库
        NewRepository repository = context.createRepository(ExtensionPluginConstants.REPOSITORY_KEY, Java.KEY);
        repository.setName(ExtensionPluginConstants.REPOSITORY_NAME);

        // 使用规则定义注解的加载器
        RulesDefinitionAnnotationLoader annotationLoader = new RulesDefinitionAnnotationLoader();
        annotationLoader.load(repository, CheckClassesCenter.checkClasses());
        annotationLoader.load(repository, CheckClassesCenter.testCheckClasses());

        repository.done();
    }

}
