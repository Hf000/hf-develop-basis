# mybatis-plus-springboot-simple
personal study

# 1. SpringBoot整合MyBatis-Plus的简单应用
# 2. mybatis-plus自动生成代码工具, 支持模板VelocityTemplateEngine(模板文件.vm), 也支持模板FreemarkerTemplateEngine(模板文件.ftl)、BeetlTemplateEngine(模板文件.btl)
       .btl为后缀的文件对应的是BeetlTemplateEngine引擎类
       .ftl为后缀的文件对应的是FreemarkerTemplateEngine引擎类
       .vm为后缀的文件为VelocityTemplateEngine引擎类(默认支持)
       可在mybatis-plus-generator依赖包的templates文件夹拷对应模板进行修改
       使用方法:
       1> 执行CodeGenerator类主方法
       2> 根据提示输入以下信息
           请输入模块磁盘路径：
           根据实际情况输入: D:\IdeaWorkSpace\hf-develop-basis\mybatis-parent\mybatis-plus-springboot-simple
           请输入数据库连接密码：
           根据实际情况输入: root
           请输入author信息：
           根据实际情况输入: hf
           请输入模块名：
           根据实际情况输入: mpsbtest
           请输入项目包父路径：
           根据实际情况输入: com.hufei
           请输入表名，多个英文逗号分割：
           根据实际情况输入: tb_user
           请输入表前缀：
           根据实际情况输入: tb_