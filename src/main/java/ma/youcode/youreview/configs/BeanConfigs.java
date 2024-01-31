package ma.youcode.youreview.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {
    
    @Bean 
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
