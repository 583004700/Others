package com.byefan;

import com.byefan.core.flowable.JobListener;
import com.byefan.core.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.byefan.xhoa.utils.IConst.PROCESSES;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.byefan.xhoa", "com.byefan.core"})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.byefan.xhoa.mapper", "com.byefan.core.mapper"})
@EnableScheduling
@EnableCaching
@EnableSwagger2
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class
})
@Import({SpringUtils.class})
public class XhoaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XhoaApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("2048MB"); //KB,MB
        /// 设置总上传数据总大小  10485760
        factory.setMaxRequestSize("20480MB");
        //更改 文件上传临时路径
        String location = System.getProperty("user.dir") + "/data/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }

    /**
     * WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XhoaApplication.class);
    }

    //    @Bean
//    public CommandLineRunner init(final RepositoryService repositoryService,
//                                  final RuntimeService runtimeService,
//                                  final TaskService taskService) {
    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
                List<String> fileNames = new ArrayList<>();
                list.forEach(pd -> fileNames.add(pd.getResourceName()));
                //增加事件监听
                runtimeService.addEventListener(new JobListener());
                Resource resource = new ClassPathResource(PROCESSES);
                try {
                    File[] files = resource.getFile().listFiles();
                    for (File file : files) {
                        String fileName = PROCESSES + File.separator + file.getName();
                        if (!fileNames.contains(fileName)) {
                            //流程部署
                            repositoryService.createDeployment().addClasspathResource(fileName).name(file.getName()).deploy();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
