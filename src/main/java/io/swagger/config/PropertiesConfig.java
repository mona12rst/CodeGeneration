package io.swagger.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
// this is the prefix for the line in prop file: bookstore.defaultQuantity
@ConfigurationProperties(prefix = "banking")
public class PropertiesConfig
{
    // this has to be same name as in the prop file
    private int defaultReqSize;

    public int getDefaultQuantity()
    {
        return defaultReqSize;
    }

    public void setDefaultQuantity(int defaultReqSize)
    {
        this.defaultReqSize = defaultReqSize;
    }
}
