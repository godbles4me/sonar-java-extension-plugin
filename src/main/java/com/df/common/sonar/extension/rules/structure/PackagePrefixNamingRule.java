package com.df.common.sonar.extension.rules.structure;

import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Rule;
import org.sonar.java.model.JavaTree;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 包前缀规则.
 *
 * <pre>
 *     <p>package com.df.aizhuan.trade.api</p>
 *     <p>package com.df.aizhuan.trade.core</p>
 *     <p>package com.df.aizhuan.trade.dao</p>
 *     <p>package com.df.aizhuan.trade.web</p>
 * </pre>
 *
 * @author Daniel Lea
 */
@Slf4j(topic = "PackagePrefixNamingRuleLog")
@Rule(
        key = "PackagePrefixNamingRule"
)
public class PackagePrefixNamingRule extends IssuableSubscriptionVisitor {

    private static final Pattern PACKAGE_PREFIX_NAMING_REG = Pattern.compile("^(com[.]df[.][a-z]+[.][a-z]+[.](api|core|dao|web))$");

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return null;
    }

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        this.scanFile();
    }

    @Override
    public void visitPackage(final PackageDeclarationTree tree) {


        System.out.println(tree.kind().getAssociatedInterface());
        System.out.println(tree.packageName().symbolType());
    }
}
