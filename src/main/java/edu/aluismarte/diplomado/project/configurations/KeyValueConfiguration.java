package edu.aluismarte.diplomado.project.configurations;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.keyvalue.core.KeyValueAdapter;
//import org.springframework.data.keyvalue.core.KeyValueOperations;
//import org.springframework.data.keyvalue.core.KeyValueTemplate;
//import org.springframework.data.map.MapKeyValueAdapter;
import org.springframework.data.map.repository.config.EnableMapRepositories;

//import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aluis on 7/3/2022.
 */
@EnableMapRepositories
@Configuration
public class KeyValueConfiguration {

//    //To be used only if @EnableMapRepositories is not used.
//    //Else @EnableMapRepositories gives us a template as well.
//    @Bean("keyValueTemplate")
//    public KeyValueOperations keyValueTemplate() {
//        return new KeyValueTemplate(keyValueAdapter());
//    }
//
//    @Bean
//    public KeyValueAdapter keyValueAdapter() {
//        return new MapKeyValueAdapter(ConcurrentHashMap.class);
//    }
}
