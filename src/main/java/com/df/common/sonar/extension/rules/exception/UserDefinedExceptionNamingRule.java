package com.df.common.sonar.extension.rules.exception;

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
 * 自定义异常命名规则.
 *
 * @author Daniel Lea
 */
@Slf4j(topic = "UserDefinedExceptionNamingRule")
@Rule(
        key = "UserDefinedExceptionNamingRule",
        name = "自定义异常命名规则",
        description = "用户自定义异常必须以Exception为后缀,如BaseException.",
        tags = {"naming", "exception"},
        priority = Priority.CRITICAL
)
public class UserDefinedExceptionNamingRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final String ISSUE_EXCEPTION_MSG =
            "The suffix of exception class should be `Exception`.";
    private static final String ISSUE_RUNTIME_EXCEPTION_MSG =
            "The suffix of exception class should be `RuntimeException`.";
    private static final String ISSUE_SUPER_EXCEPTION_MSG =
            "A custom exception should derive from a base exception class.";

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        this.scan(context.getTree());
    }

    @Override
    public void visitClass(final ClassTree tree) {
        Objects.requireNonNull(tree, "the AST can not be null.");

        String clazzName = tree.simpleName().name();

        // 保存从异常超类派生
        if(null != tree.superClass()) {
            String superClazzName = tree.superClass().symbolType().name();

            // 检查超类是否以Exception结尾
            if(!superClazzName.endsWith(ExtensionPluginConstants.EXCEPTION_CLASS_SUFFIX)) {
                context.reportIssue(this, tree, ISSUE_EXCEPTION_MSG);
            } else {
                // 如果超类RuntimeException结尾,则子类必须相同结尾
                if (superClazzName.endsWith(ExtensionPluginConstants.RUNTIME_EXCEPTION_CLASS_SUFFIX)) {
                    if (!clazzName.endsWith(ExtensionPluginConstants.RUNTIME_EXCEPTION_CLASS_SUFFIX)) {
                        context.reportIssue(this, tree, ISSUE_RUNTIME_EXCEPTION_MSG);
                    }
                } else {
                    // 非运行时异常, 子类必须以Exception结尾(也允许是RuntimeException)
                    if (!clazzName.endsWith(ExtensionPluginConstants.EXCEPTION_CLASS_SUFFIX)) {
                        context.reportIssue(this, tree, ISSUE_EXCEPTION_MSG);
                    }
                }
            }
        } else {
            context.reportIssue(
                    this, tree, ISSUE_SUPER_EXCEPTION_MSG);
        }

        super.visitClass(tree);
    }
}
