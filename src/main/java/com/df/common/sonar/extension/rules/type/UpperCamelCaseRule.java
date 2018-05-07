package com.df.common.sonar.extension.rules.type;

import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;

/**
 * 首字母大写驼峰命名规则
 *
 * @author Daniel Lea
 */
public class UpperCamelCaseRule extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext javaFileScannerContext) {
        this.context = javaFileScannerContext;
        this.scan(context.getTree());
    }

    @Override
    public void visitClass(final ClassTree tree) {

    }
}
