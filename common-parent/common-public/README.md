# common-public
personal study

# 1. 响应统一处理：ResponseUtil
# 2. spring管理的bean发生方法内该类方法调用造成AOP失效时, 可以获取当前类的代理类,然后强转成当前类再调用方法, 
    具体应用:  (当前类)AopContext.currentProxy().当前类方法; 
