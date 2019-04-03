package com.lvmama.tony.bootstrap.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义引导配置
 *
 * @author Tour Jiang
 * @since 2019-01-12 16:07
 **/
public class CustomBootstrapConfiguration implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();

        propertySources.addFirst(createPropertySource());

    }

    private PropertySource createPropertySource() {

        Map<String, Object> map = new HashMap<>();

        map.put("name", "Toter");

        return new MapPropertySource("my-property-source", map);
    }
}
