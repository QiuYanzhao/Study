package com.my.shardingdemo;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

public class Generator {
    public static void main(String[] args) {
        DataSourceConfig dataSourceConfig =
                new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/localhost", "root",
                        "123456")
                        .build();
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride()
                //输出目录
                .outputDir("/opt/baomidou")
                .author("qyz")
                .build();
        autoGenerator.global(globalConfig);


        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.my.mybatisplus.shardingdemo")
                .moduleName("sys")
                .entity("pojo")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .controller("controller")
                .build();
        autoGenerator.packageInfo(packageConfig);

        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .controller("/templates/controller.java")
                .build();
        autoGenerator.template(templateConfig);



        autoGenerator.execute();


    }
}
