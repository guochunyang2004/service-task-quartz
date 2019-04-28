//package com.mycloud.service.task.config.quartz;
//import com.mycloud.service.task.config.app.AppConfig;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.ee.servlet.QuartzInitializerListener;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//import java.io.IOException;
//import java.util.Properties;
//@Configuration
//public class QuartzConfiguration {
//
//    @Autowired
//    private AppConfig appConfig;
//
//    @Autowired
//    private SpringJobFactory springJobFactory;
//
//    @Bean//(name = "SchedulerFactory")
//    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setAutoStartup(true);
//        schedulerFactoryBean.setStartupDelay(15);//延时5秒启动
//        schedulerFactoryBean.setQuartzProperties(quartzProperties());
//        schedulerFactoryBean.setJobFactory(springJobFactory);
//        return schedulerFactoryBean;
//    }
//
//    @Bean
//    public Scheduler scheduler() throws IOException, SchedulerException {
//        return schedulerFactoryBean().getScheduler();
////        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
////        Scheduler scheduler = schedulerFactory.getScheduler();
////        scheduler.startDelayed(3);
////        return scheduler;
//    }
//
//    /**
//     * 初始化Quartz监听器,让Spring boot启动时初始化Quartz
//     * --web工程中，一般在web.xml中设置如下：
//     * <listener>
//     * <listener-class>org.quartz.ee.servlet.QuartzInitializerListener</listener-class>
//     * </listener>
//     * Quartz就会随着web容器启动，加载调度任务
//     *
//     * @return
//     */
//    @Bean
//    public QuartzInitializerListener executorListener() {
//        return new QuartzInitializerListener();
//    }
//
//    @Bean
//    public Properties quartzProperties() throws IOException {
//        Properties prop = new Properties();
//        prop.put("quartz.scheduler.instanceName", appConfig.getQuartzSchedulerInstanceName());
//        prop.put("org.quartz.scheduler.instanceId", appConfig.getQuartzSchedulerInstanceId());
//        prop.put("org.quartz.scheduler.skipUpdateCheck", appConfig.getQuartzSchedulerSkipUpdateCheck());
//        prop.put("org.quartz.scheduler.jobFactory.class", appConfig.getQuartzSchedulerJobFactoryClass());
//        prop.put("org.quartz.jobStore.class", appConfig.getQuartzJobStoreClass());
//        prop.put("org.quartz.jobStore.driverDelegateClass", appConfig.getQuartzJobStoreDriverDelegateClass());
//        prop.put("org.quartz.jobStore.dataSource", appConfig.getQuartzJobStoreDatasource());
//        prop.put("org.quartz.jobStore.tablePrefix", appConfig.getQuartzJobStoreTablePrefix());
//        prop.put("org.quartz.jobStore.isClustered", appConfig.getQuartzJobStoreIsClustered());
//        prop.put("org.quartz.threadPool.class", appConfig.getQuartzThreadPoolClass());
//        prop.put("org.quartz.threadPool.threadCount", appConfig.getQuartzThreadPoolThreadCount());
//        prop.put("org.quartz.dataSource.quartzDataSource.connectionProvider.class", appConfig.getQuartzDatasourceQuartzDataSourceConnectionProviderClass());
//        prop.put("org.quartz.dataSource.quartzDataSource.driver", appConfig.getQuartzDatasourceQuartzDataSourceDriver());
//        prop.put("org.quartz.dataSource.quartzDataSource.URL", appConfig.getQuartzDatasourceQuartzDataSourceUrl());
//        prop.put("org.quartz.dataSource.quartzDataSource.user", appConfig.getQuartzDatasourceQuartzDataSourceUser());
//        prop.put("org.quartz.dataSource.quartzDataSource.password", appConfig.getQuartzDatasourceQuartzDataSourcePassword());
//        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", appConfig.getQuartzDatasourceQuartzDataSourceMaxConnections());
//
//        return prop;
//    }
//}