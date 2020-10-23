package com.macro.mall.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 *
 * @author macro
 * @date 2019/4/8
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.macro.mall.mapper", "com.macro.mall.app.dao", "com.macro.mall.dao"})
public class MyBatisConfig {
}
