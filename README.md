# Farm backend README

快速运行
1. 在 MySQL 中创建数据库并导入 database.sql。
2. 修改 src/main/resources/application.yml 中的数据库连接信息。
3. 在项目根目录运行： mvn spring-boot:run

接口示例
- POST http://127.0.0.1:8080/api/login {"username":"admin","pwd":"123456"}
- POST /api/land/add
- GET /api/land/getAll
- GET /api/land/del?id=1
- POST /api/crop/add
- GET /api/crop/del?id=1
