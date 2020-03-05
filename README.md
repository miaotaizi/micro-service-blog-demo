Spring 微服务架构Demo
===================

> 本 demo 假设您有能力解决 `docker`, `docker-compose`, `java`, `spring框架` 的基本问题, 不熟悉的请自行解决, 我还在摸索

### 框架选择

- SpringBoot 版本: `2.1.7.RELEASE`
- SpringCloud 版本: `Greenwich.SR2`
- Skywalking 版本: `v6.4.0`

> Skywalking 的 `spring-cloud-gateway` 插件仅 `Greenwich.SR2` 版本下可以正常追踪, 需要 接入 Skywalking 这里需要注意下

### 模块

- account-svc: 账户服务
- account-api: 账户服务 声明式Web Service客户端
- post-svc: 文章服务
- post-api: 文章服务 声明式Web Service客户端
- page: 页面服务, 用于聚合 `account-svc` 和 `post-svc` 提供的数据
- gateway: 基于 `spirng-cloud-gateway` 的服务网关

### 构建步骤

1. 安装 `docker` 与 `docker-compose`

2. 项目根目录下 运行 maven 命令: `mvn clean package -DskypTests` 构建 JAR 包

3. 项目根目录下 创建 `.env` 环境变量(可参照`.env.example`), 按照需求结合 `docker-compose.yml` 文件进行修改

4. 项目根目录下运行 `docker-compose build` 构建 docker 镜像

5. 运行 `docker-compose up -d` 启动项目

### 测试

1. 访问 `http://localhost/post` 返回同时包含 `account` 与 `post` 信息, 例如:

```json
{
  "account": {
    "name": "Cordell Cassin I",
    "address": "Suite 575 67746 Graham Views, South Laelland, OK 96683-9798"
  },
  "post": {
    "title": "The Widening Gyre",
    "content": "Remember, your mind is the best weapon you have."
  }
}
```

2. 访问 `http://localhost/posts` 返回文章信息, 例如:

```json
{
  "data": {
    "title": "I Will Fear No Evil",
    "content": "I still don't know if there is a divine plan, but I've come to realize that it doesn't matter. What matters is that we act; that we do what's right when confronted with evil. That's what you did at Kvatch. It wasn't the gods that saved us, it was you."
  }
}
```

3. 访问 `http://localhost/accounts` 返回 账户信息, 例如:

```json
{
  "data": {
    "name": "Miss Cary Jerde",
    "address": "Apt. 078 90424 Carroll Fields, Lake Karamouth, GA 75763"
  }
}
```

4. 访问 `http://localhost/post/foo` 返回 固定 字符串 `post.foo`

5. 访问 `http://localhost:8080/` 可以看到 `skywalking` 监控界面

