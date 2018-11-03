package com.caliven.trace2;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }


    private final Logger logger = Logger.getLogger(getClass());


    /**
     * 从上面的控制台输出内容中，我们可以看到多了一些形如[trace-1,f410ab57afd5c145,a9f2118fa2019684,false]的日志信息，
     * 而这些元素正是实现分布式服务跟踪的重要组成部分，它们每个值的含义如下：
     *
     * 第一个值：trace-1，它记录了应用的名称，也就是application.properties中spring.application.name参数配置的属性。
     * 第二个值：f410ab57afd5c145，Spring Cloud Sleuth生成的一个ID，称为Trace ID，它用来标识一条请求链路。一条请求链路中包含一个Trace ID，多个Span ID。
     * 第三个值：a9f2118fa2019684，Spring Cloud Sleuth生成的另外一个ID，称为Span ID，它表示一个基本的工作单元，比如：发送一个HTTP请求。
     * 第四个值：false，表示是否要将该信息输出到Zipkin等服务中来收集和展示。
     *
     * 上面四个值中的Trace ID和Span ID是Spring Cloud Sleuth实现分布式服务跟踪的核心。在一次服务请求链路的调用过程中，
     * 会保持并传递同一个Trace ID，从而将整个分布于不同微服务进程中的请求跟踪信息串联起来，以上面输出内容为例，
     * trace-1和trace-2同属于一个前端服务请求来源，所以他们的Trace ID是相同的，处于同一条请求链路中。
     *
     *
     * 2018-11-03 15:44:54.567  INFO [trace-2,5ed7430c035b49ec,5ed7430c035b49ec,false] 4768 --- [nio-9094-exec-6] ication$$EnhancerBySpringCGLIB$$368de478 : ===<call trace-2>===
     *
     * @return
     */
    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace() {
        logger.info("===<call trace-2>===");
        return "Trace";
    }
}
