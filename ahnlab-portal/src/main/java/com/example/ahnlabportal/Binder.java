package com.example.ahnlabportal;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.PropertySourcesPlaceholdersResolver;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Component
public class Binder extends org.springframework.boot.context.properties.bind.Binder {

    private final Environment environment;


    public Binder(Environment environment){
        super(ConfigurationPropertySources.get(environment), new PropertySourcesPlaceholdersResolver(environment), null, null, null);
        this.environment = environment;
    }

    public String getProperty(String key){
        return environment.getProperty(key);
    }

    public <T> T getProperty(String key, Class<T> tClass){
        return this.bind(key, tClass).get();
    }

    public Map<String, String> getStringMapProperty(String key){
        return this.getMapProperty(key, String.class);
    }

    public List<Map<String, String>> getListStringMapProperty(String key){
        return this.getListMapProperty(key, String.class);
    }

    public Map<String, Integer> getIntegerMapProperty(String key){
        return this.getMapProperty(key, Integer.class);
    }

    public List<Map<String, Integer>> getListIntegerMapProperty(String key){
        return this.getListMapProperty(key, Integer.class);
    }

    public Map<String, Object> getMapProperty(String key){
        return this.getMapProperty(key, Object.class);
    }

    public List<Map<String, Object>> getListMapProperty(String key){
        return this.getListMapProperty(key, Object.class);
    }

    public <V> Map<String, V> getMapProperty(String key, Class<V> vClass){
        return this.bind(key, Bindable.mapOf(String.class, vClass)).get();
    }

    public <V> List<Map<String, V>> getListMapProperty(String key, Class<V> vClass){
        return this.bind(key, Bindable.listOf(Map.class)).get().stream()
                .map(map -> ((Set<Map.Entry<String, V>>) map.entrySet())
                        .stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> vClass.cast(entry.getValue())))).toList();
    }

}
