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

/**
 * 扩展插件统一常量
 *
 * @author Daniel Lea
 */
public class ExtensionPluginConstants {

    ////////////////////////////////////// 仓库常量 //////////////////////////////////////

    /** 插件仓库标识 */
    public static final String      REPOSITORY_KEY                      = "sonar-java-extension-rules" ;

    /** 插件仓库名称 */
    public static final String      REPOSITORY_NAME                     = "帝峰研发编码规范"      ;



    ////////////////////////////////////// 规则常量 //////////////////////////////////////

    /** 抽象类前缀 */
    public static final String      ABSTRACT_CLASS_PREFIX               = "Abstract"            ;

    /** 异常类后缀 */
    public static final String      EXCEPTION_CLASS_SUFFIX              = "Exception"           ;

    /** 运行时异常后缀 */
    public static final String      RUNTIME_EXCEPTION_CLASS_SUFFIX      = "RuntimeException"    ;

    /** 接口前缀 */
    public static final String      INTERFACE_PREFIX                    = "I"                   ;

    /** 枚举类后缀 */
    public static final String      ENUM_CLASS_SUFFIX                   = "Enum"                ;



    ////////////////////////////////////// 其它常量 //////////////////////////////////////

    /** 使用Java版本 */
    public static final int         USING_JAVA_VERSION                  = 8                     ;

    /** 类标识 */
    public static final String      CLASS_TYPE_IDENTIFIER               = "class"               ;

    /** 接口标识 */
    public static final String      INTERFACE_TYPE_IDENTIFIER           = "interface"           ;

    /** 枚举标识 */
    public static final String      ENUM_TYPE_IDENTIFIER                = "enum"                ;

    /** 注解标识 */
    public static final String      ANNOTATION_TYPE_IDENTIFIER          = "@interface"          ;

}
