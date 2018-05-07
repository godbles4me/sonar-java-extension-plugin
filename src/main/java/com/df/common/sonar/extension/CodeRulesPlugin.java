package com.df.common.sonar.extension;

import org.sonar.api.Plugin;

/**
 * 帝峰集团研发中心代码规范插件
 *
 * @author Daniel Lea
 */
public class CodeRulesPlugin implements Plugin {

    @Override
    public void define(final Context context) {
        // 服务器启动时初始化
        context.addExtension(CodeRulesDefinition.class);
        // 代码分析时初始化
        context.addExtension(CodeRulesCheckRegistrar.class);
    }
}
