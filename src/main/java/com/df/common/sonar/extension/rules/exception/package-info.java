/**
 * 异常相关校验包.
 *
 * 异常校验分为以下几部分
 * 1. 自定义异常是否有继承父异常.
 *      一般建议继承Exception, 而不是笼统的Throwable, 千万别继承Error.
 * 2. 自定义异常命名规则.
 *      详见类 UserDefinedExceptionNamingRule
 *
 * @author Daniel Lea
 */
package com.df.common.sonar.extension.rules.exception;