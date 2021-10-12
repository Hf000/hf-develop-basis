# common-config
personal study

# 1. 请求参数增强的统一处理 RequestParameterAspect
# 2. 封装elasticJob定时任务, 采用注解方式（注解：@ElasticSimpleJob）实现定时任务处理并兼容xml方式
    使用方法:
        1> 引入common-config依赖
        2> 创建作业类, 添加@Component、@ElasticSimpleJob注解, 实现SimpleJob接口
        3> 在application.properties文件中配置ej相关配置项
# 3. 自定义注解@CustomBeanReplace实现spring容器中的bean替换
    使用方法:
        1> 引入common-config依赖
        2> 创建需要替换接口的实现类, 添加@CustomBeanReplace(value="被替换bean的名称")
        3> 在application.properties文件中配置replaceBean.scannerPackages替换扫描包配置项
# 4. 自定义@EventListenerAnnotation事件注解, 可同步进行事件的发布和监听
    使用方法:
        1> 引入common-config依赖
        2> 创建事件实体, 继承EventBaseAbstract或者实现EventBase
        3> 创建事件监听器处理类添加@EventListenerAnnotation, 继承EventListenerAbstract<第二步创建的事件实体>或者实现EventListener<第二步创建的事件实体>
        4> 在需要的bean中注入EventPublisher对象, 进行事件发布
