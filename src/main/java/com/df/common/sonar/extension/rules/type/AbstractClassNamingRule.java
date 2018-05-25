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
import org.apache.commons.lang3.StringUtils;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.model.ModifiersUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

import java.util.Objects;

/**
 * 抽象类命名规则.
 *
 * 通常我们会按如下方式定义,
 * <pre>
 *     public class abstract AbstractXXX {
 *         ...
 *     }
 *  or
 *     public class abstract BaseXXXX {    // 暂时不支持
 *         ...
 *     }
 * </pre>
 *
 * @author Daniel Lea
 */
@Slf4j(topic = "AbstractClassNamingRuleLog")
@Rule(
        key = "AbstractClassNamingRule",
        name = "抽象类命名规则",
        description = "抽象类命名必须以Abstract为前缀,例如AbstractController.",
        tags = {"naming", "type"},
        priority = Priority.CRITICAL
)
public class AbstractClassNamingRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final String ISSUE_MSG = "The prefix of abstract class should be `Abstract`.";

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        this.scan(context.getTree());
    }

    @Override
    public void visitClass(final ClassTree tree) {

        Objects.requireNonNull(tree, "the AST can not be null.");

        if (ModifiersUtils.hasModifier(tree.modifiers(), Modifier.ABSTRACT)) {
            if (null != tree.simpleName() &&
                    StringUtils.isNoneBlank(tree.simpleName().name())) {

                log.info("The name of current abstract class is <{}>.", tree.simpleName().name());

                if (ExtensionPluginConstants.ABSTRACT_CLASS_PREFIX.length() >= tree.simpleName().name().length()) {
                    context.reportIssue(this, tree, ISSUE_MSG);
                } else {
                    if (!tree.simpleName().name()
                            .startsWith(ExtensionPluginConstants.ABSTRACT_CLASS_PREFIX)) {
                        context.reportIssue(this, tree, ISSUE_MSG);
                    }
                }
            }
        }

        super.visitClass(tree);
    }

}
