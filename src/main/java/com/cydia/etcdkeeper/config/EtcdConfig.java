package com.cydia.etcdkeeper.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
@Data
@Configuration
@ConfigurationProperties(prefix = "etcd")
public class EtcdConfig {

    @JsonProperty
    private String separator;

    @JsonProperty
    private boolean usetls;

    @JsonProperty
    private String key;

    @JsonProperty
    private String cert;

    @JsonProperty
    private String cacert;

    @JsonProperty
    private boolean auth;
}