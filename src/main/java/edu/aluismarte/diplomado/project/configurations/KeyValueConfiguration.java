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
 * Esto es un force para demostrar un concepto, usar una DB adecuada para este caso.
 *
 * @author aluis on 7/3/2022.
 * @see <a href="https://www.baeldung.com/spring-data-key-value">Spring Key-Value API</a>
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
