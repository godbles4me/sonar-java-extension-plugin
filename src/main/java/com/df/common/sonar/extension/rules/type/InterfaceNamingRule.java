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

import com.df.common.sonar.extension.ExtensionPluginConstants;
import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;

import java.util.Objects;

/**
 * 接口命名规则.
 *
 * 通常我们会按如下方式定义接口,
 * <pre>
 *     public interface IXXX {
 *         ...
 *     }
 * </pre>
 *
 * @author Daniel Lea
 */
@Slf4j(topic = "InterfaceNamingRuleLog")
@Rule(
        key = "InterfaceNamingRule",
        name = "接口命名规则",
        description = "接口命名必须以I为前缀,例如IOrderService.",
        tags = {"naming", "type"},
        priority = Priority.CRITICAL
)
public class InterfaceNamingRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final String ISSUE_MSG = "The prefix of interface class should be `I`.";

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        this.scan(context.getTree());
    }

    @Override
    public void visitClass(final ClassTree tree) {

        Objects.requireNonNull(tree, "the AST can not be null.");

       if (ExtensionPluginConstants.INTERFACE_TYPE_IDENTIFIER.equals(tree.declarationKeyword().text())) {
            if (!tree.simpleName().name().startsWith(ExtensionPluginConstants.INTERFACE_PREFIX)) {
                context.reportIssue(this, tree, ISSUE_MSG);
            }
       }

       super.visitClass(tree);
    }
}
