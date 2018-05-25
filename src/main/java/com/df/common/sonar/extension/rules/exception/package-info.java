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