package com.lvmama.tony.bootstrap.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * <p>
 * <p>
 *
 * @author qianjiangtao
 * @date 2019/1/8
 */
public class SpringEventListenerTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyApplicationListener.class);

        //1.手动创建listener
        // applicationContext.addApplicationListener(new MyApplicationListener());

        //使用register注册listener
        //applicationContext.register(MyApplicationListener.class);

        //applicationContext.refresh();

        applicationContext.publishEvent(new MyApplicationEvent("Hello World"));
        applicationContext.publishEvent(new MyApplicationEvent(159));
    }

    private static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.printf("MyApplicationListener receives event source : %s \n", event.getSource());
        }
    }

    private static class MyApplicationEvent extends ApplicationEvent {

        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
