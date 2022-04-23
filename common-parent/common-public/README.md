# common-public
personal study

# 1. 响应统一处理：ResponseUtil
# 2. spring管理的bean发生方法内该类方法调用造成AOP失效时, 可以获取当前类的代理类,然后强转成当前类再调用方法, 
    具体应用:  (当前类)AopContext.currentProxy().当前类方法; 
# 3. 常用工具类
### 1. base64工具类: com.hufei.cp.utils.Base64Utils
### 2. 解密工具类: com.hufei.cp.utils.DecodeUtils
### 3. 解析El表达式工具类: com.hufei.cp.utils.ElUtil
### 4. 加密工具类: com.hufei.cp.utils.EncryptUtils
### 5. 解析自定义表达式工具类: com.hufei.cp.utils.ExpressionResolverUtil
### 6. json工具类: com.hufei.cp.utils.JsonUtils
### 7. map工具类: com.hufei.cp.utils.MapUtils
### 8. 解析Properties文件工具类: com.hufei.cp.utils.PropertiesUtil
### 9. 请求参数处理工具类: com.hufei.cp.utils.RequestParamUtil
### 10. 响应结果封装工具类: com.hufei.cp.utils.ResponseUtil
### 11. 获取spring容器对象工具类: com.hufei.cp.utils.SpringBeanUtil
### 12. 时间计算工具类: com.hufei.cp.utils.TimeUtil
### 13. 类型转换工具类: com.hufei.cp.utils.TypeConvertUtils
