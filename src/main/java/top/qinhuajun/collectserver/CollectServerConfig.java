package top.qinhuajun.collectserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class CollectServerConfig {

    @Bean
    public ThreadPoolExecutor threadPoolTaskExecutor() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(1024);
        return new ThreadPoolExecutor(10, 100, 100, TimeUnit.MINUTES, workQueue);
    }
}
