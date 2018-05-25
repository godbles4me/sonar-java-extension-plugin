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

import com.df.common.sonar.extension.rules.exception.UserDefinedExceptionNamingRule;
import com.df.common.sonar.extension.rules.type.*;
import com.google.common.collect.ImmutableList;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.Arrays;
import java.util.List;

/**
 * 扩展插件实际需要注册的类在此添加.
 *
 * @author Daniel Lea
 */
public class CheckClassesCenter {

    /**
     * Lists all Java checks provided by the plugin
     */
    public static List<Class> getAllChecks() {
        return
                ImmutableList
                        .<Class>builder()
                        .addAll(getJavaChecks())
                        .addAll(getJavaTestChecks())
                        .build();
    }

    /**
     * Lists all the checks provided by the plugin
     */
    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return
                Arrays.asList(checkClasses());

    }

    /**
     * Lists all the test checks provided by the plugin
     */
    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return
                Arrays.asList(testCheckClasses());
    }

    /**
     * Lists all the checks provided by the plugin
     */
    public static Class<? extends JavaCheck>[] checkClasses() {
        return
                new Class[] {
                        AbstractClassNamingRule.class,
                        EnumClassNamingRule.class,
                        InterfaceNamingRule.class,
                        UserDefinedExceptionNamingRule.class,
                };
    }

    /**
     * Lists all the test checks provided by the plugin
     */
    public static Class<? extends JavaCheck>[] testCheckClasses() {
        return
                new Class[] {};
    }
}
