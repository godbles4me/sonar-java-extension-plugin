package com.df.common.sonar.extension.rules.type;

import com.df.common.sonar.extension.ExtensionPluginConstants;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.model.ModifiersUtils;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

import java.util.List;
import java.util.Objects;

/**
 * 常量类命名规则
 *
 * 通常我们会按如下方式定义常量,
 * <pre>
 *     public interface XXXEnum {
 *         ...
 *     }
 * </pre>
 *
 * @author Daniel Lea
 */
@Slf4j(topic = "EnumClassNamingRuleLog")
@Rule(
        key = "EnumClassNamingRule",
        name = "枚举类命名规则",
        description = "枚举类命名必须以Enum为后缀,如OrderTypeEnum",
        tags = {"naming", "type"},
        priority = Priority.CRITICAL
)
public class EnumClassNamingRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final String ISSUE_MSG = "The suffix of enum class shoud be `Enum`.";

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        this.scan(context.getTree());
    }

    @Override
    public void visitClass(final ClassTree tree) {

        Objects.requireNonNull(tree, "the AST can not be null.");

        if (ExtensionPluginConstants.ENUM_TYPE_IDENTIFIER.equals(tree.declarationKeyword().text())) {
            if (!tree.simpleName().name().endsWith(ExtensionPluginConstants.ENUM_CLASS_SUFFIX)) {
                context.reportIssue(this, tree, ISSUE_MSG);
            }
        }

        super.visitClass(tree);
    }
}
