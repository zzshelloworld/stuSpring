package com.zhangzhe.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;



    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader=resourceLoader;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName=name;
    }

    public void outputResult() throws IOException {
        System.out.println("Bean的名称是:"+beanName);
        Resource resource=loader.getResource("classpath:com/zhangzhe/aware/test.txt");
        System.out.println("ResourceLoader加载的文件内容是:");
        String line;
        BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream()));
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
    }
}
