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
package com.df.common.sonar.extension.rules.structure;

import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Rule;
import org.sonar.java.model.JavaTree;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;
import org.sonar.plugins.java.api.tree.Tree;

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
public class PackagePrefixNamingRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final Pattern PACKAGE_PREFIX_NAMING_REG = Pattern.compile("^(com[.]df[.][a-z]+[.][a-z]+[.](api|core|dao|web))$");

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        this.scan(context.getTree());
    }

    @Override
    public void visitPackage(final PackageDeclarationTree tree) {


        System.out.println(tree.kind().getAssociatedInterface());

    }
}
