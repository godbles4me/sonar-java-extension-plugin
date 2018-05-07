/**
 * 项目结构规则包
 *
 * <pre>
 * aizhuan-trade
 *   aizhuan-trade-api    [com.df.aizhuan.api]
 *     constants
 *     domain
 *       dto
 *       entity
 *     exception
 *     params
       service
 *   aizhuan-trade-core  [com.df.aizhuan.core]
 *     consumer
 *     service
 *       impl
 *          XXServiceImpl
 *       XXService
 *     fallback
 *     utils
 *   aizhuan-trade-dao   [com.df.aizhuan.dao]
 *          XXXMapper
 *   aizhuan-trade-web   [com.df.aizhuan.web]
 *      api
 *          RemoteXXXController
 *      app
 *          XXXController
 * </pre>
 *
 * @author Daniel Lea
 */
package com.df.common.sonar.extension.rules.structure;