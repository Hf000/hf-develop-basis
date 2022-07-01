package com.hufei.mpsbs.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p> mybatis-plus代码生成器主类 </p>
 * 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/14 17:17
 */
public class CodeGenerator {

    /**
     * 数据源配置
     */
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/develop-basis?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&useSSL=false";
    private static final String DB_SCHEMA_NAME = "public";
    private static final String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_USERNAME = "root";

    /**
     * 基础实体类和字段配置
     */
//    private static final String SUPER_ENTITY_CLASS = "com.hufei.entity.BaseEntity";
//    private static final String[] SUPER_ENTITY_COLUMNS = new String[]{"id", "createDate", "updateDate", "isDelete"};
    private static final String SUPER_ENTITY_CLASS = "";
    private static final String[] SUPER_ENTITY_COLUMNS = new String[]{};

    /**
     * 代码生成执行主方法
     * @param args main方法入参
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取系统变量, 来获得项目路径
        String projectPath = scanner("模块磁盘路径");
        // 数据库连接密码
        String dbPassword = scanner("数据库连接密码");
        // 文件输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(scanner("author信息"));
        // 是否打开输出目录
        gc.setOpen(false);
        //是否重写
//        gc.setFileOverride(true);
        // 开启activeRecord模式
//        gc.setActiveRecord(true);
        // xml开启二级缓存
//        gc.setEnableCache(false);
        // 设置service文件后缀名
        gc.setServiceName("%sService");
        // 设置Mapper接口文件后缀名
        gc.setMapperName("%sMapper");
        // mapper.xml文件字段配置 通用查询结果列
        gc.setBaseColumnList(true);
        // mapper.xml文件ResultMap配置 通用查询映射结果
        gc.setBaseResultMap(true);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        // 有些数据库才需要模式名称, 例如:PostgreSql
//        dsc.setSchemaName(DB_SCHEMA_NAME);
        dsc.setDriverName(DB_DRIVER_NAME);
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(dbPassword);
        // pgSQL类型转换  转换数据库中的字段类型
        /*dsc.setTypeConvert(new PostgreSqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
                // 将数据库中的timestamp转换成date类型
                if (fieldType.toLowerCase().contains("timestamp")) {
                    return DbColumnType.DATE;
                }
                return super.processTypeConvert(config, fieldType);
            }
        });*/
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        // 配置项目包的父路径
        pc.setParent(scanner("项目包父路径"));
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setEntity("beans");
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
//        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });*/
        // 如果这里配置了mapper.xml文件的自定义输出, 那么下面配置不生成xml则不生效
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别, 如果不配置则按照默认模板文件生成
//        templateConfig.setEntity("templates/entity.java");
        // 设置为null时, 则不会生成xml文件, controller,service,mapper,entity等java类
//        templateConfig.setController(null);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);
//        templateConfig.setMapper(null);
//        templateConfig.setEntity(null);
        // 如果上面focList配置了mapper.xml的自定义输出, 那么这里即使设置成null, 也会生成xml文件
//        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略: 下划线连转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 表字段生成策略: 下划线连转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否为lombok模型, 需要依赖lombok
        strategy.setEntityLombokModel(true);
        // 生成Controller
        strategy.setRestControllerStyle(true);
        // controller映射地址url中驼峰转连字符
//        strategy.setControllerMappingHyphenStyle(true);
        // controller继承公共父类
//        strategy.setSuperControllerClass("");
        // entity继承公共父类
        strategy.setSuperEntityClass(SUPER_ENTITY_CLASS);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 表名前缀
        strategy.setTablePrefix(scanner("表前缀"));
        // 表的逻辑删除字段
        strategy.setLogicDeleteFieldName("is_deleted");
        // 设置表基础更新字段
        TableFill createdDate = new TableFill("created_date", FieldFill.INSERT);
        TableFill updatedDate = new TableFill("updated_date", FieldFill.INSERT_UPDATE);
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createdDate);
        tableFills.add(updatedDate);
        strategy.setTableFillList(tableFills);
        strategy.setFieldPrefix("is_");
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new CustomFreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 读取控制台内容
     * @param tip 提示信息
     * @return 返回
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
