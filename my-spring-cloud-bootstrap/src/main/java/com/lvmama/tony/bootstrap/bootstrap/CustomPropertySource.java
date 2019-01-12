package com.lvmama.tony.bootstrap.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

/**
 *
 * @author Toter
 * @since 2019-01-12 16:04
 **/
public class CustomPropertySource implements PropertySourceLocator{
    @Override
    public PropertySource<?> locate(Environment environment) {
        return null;
    }
}
