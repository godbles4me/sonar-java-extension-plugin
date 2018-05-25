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
