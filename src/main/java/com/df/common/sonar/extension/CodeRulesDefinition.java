/*
 * Copyright 2013-2018 Difeng Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
