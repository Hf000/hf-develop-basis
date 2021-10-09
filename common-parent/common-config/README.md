# common-config
personal study

# 1. 请求参数增强的统一处理
# 2. 封装elasticJob定时任务, 采用注解方式（注解：ElasticSimpleJob）实现定时任务处理并兼容xml方式
    使用方法:
        1> 引入common-config依赖
        2> 创建作业类, 添加@Component、@ElasticSimpleJob注解, 实现SimpleJob接口
        3> 在application.properties文件中配置ej相关配置项
