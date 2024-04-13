package top.qinhuajun.collectserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@OpenAPIDefinition(info = @Info(title = "数据采集服务", description = "数据采集服务"))
public class CollectServerConfig {

    @Bean
    public ThreadPoolExecutor threadPoolTaskExecutor() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(1024);
        return new ThreadPoolExecutor(10, 100, 100, TimeUnit.MINUTES, workQueue);
    }

}
