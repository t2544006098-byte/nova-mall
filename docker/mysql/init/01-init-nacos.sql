-- 创建 Nacos 配置库
CREATE DATABASE IF NOT EXISTS nacos_config DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE nacos_config;
-- 表结构由 nacos 容器启动时自动从环境变量指定的库里读，这里只建库