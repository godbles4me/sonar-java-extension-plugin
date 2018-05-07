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
