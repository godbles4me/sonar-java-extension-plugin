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
package com.df.common.sonar.extension.rules.type;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.regex.Pattern;

/**
 * @author daniel.lee
 */
@Rule(
        key = "LowerCamelCaseRule",
        name = "首字母小写驼峰式命名法",
        description = "方法名、属性名、局部变量名必须符合首字母小写驼峰式命名规则",
        tags = {"naming", "type"},
        priority = Priority.CRITICAL
)
public class LowerCamelCaseRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final Pattern pattern = Pattern.compile("_$");
    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext javaFileScannerContext) {
        this.context = javaFileScannerContext;
        this.scan(context.getTree());
    }

    @Override
    public void visitVariable(final VariableTree tree) {

        tree.simpleName().name();

        super.visitVariable(tree);
    }


    @Override
    public void visitMethod(final MethodTree tree) {

        super.visitMethod(tree);
    }


}
