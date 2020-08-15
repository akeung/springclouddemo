package com.ak.demo.code;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author Akeung
 * 2020/8/14
 */
public class CodeGenerator {

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:/gene");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("Akeung");

        gc.setServiceName("%sManager");
        gc.setServiceImplName("%sDAO");
        gc.setFileOverride(true);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://192.168.71.128:3306/seata_account?characterEncoding=utf8&serverTimezone=UTC");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[]{"t_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setEntityLombokModel(true);
//        strategy.setLogicDeleteFieldName("fdelete");
        strategy.setInclude(new String[]{
                "t_account",
        }); // 需要生成的表
        //strategy.setDbColumnUnderline(true);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setEntity("entities");
        pc.setMapper("mapper");
        pc.setXml("mybatis");
        pc.setService("manager");
        pc.setServiceImpl("dao");
        pc.setParent("com.ak.demo");
//        pc.setModuleName("dsc");
        mpg.setPackageInfo(pc);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();

//        tc.setXml(null);
        //tc.setEntity("entity.java.vm");
//        tc.setController(null);
//        tc.setMapper("mapper.java.vm");
//        tc.setXml("mapper.xml.vm");
//        tc.setService(null);
//        tc.setServiceImpl(null);
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
}
