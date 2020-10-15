package com.macro.mall.portal.config;

import com.macro.mall.common.config.BaseSwaggerConfig;
import com.macro.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 *
 * @author macro
 * @date 2018/4/26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.macro.mall.portal.controller")
                .title("垚修修APP")
                .description("垚修修APP接口文档")
                .contactName("Paradise")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
