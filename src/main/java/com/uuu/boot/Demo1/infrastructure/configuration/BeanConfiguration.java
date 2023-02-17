package com.uuu.boot.Demo1.infrastructure.configuration;

import com.uuu.boot.Demo1.domain.common.repository.PointTypeRepository;
import com.uuu.boot.Demo1.domain.common.service.PointTypeService;
import com.uuu.boot.Demo1.domain.common.service.PointTypeServiceImpl;
import com.uuu.boot.Demo1.infrastructure.repository.PointTypeMemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PointTypeService pointTypeService(final PointTypeRepository repository){
        return new PointTypeServiceImpl(repository);
    }
    @Bean
    PointTypeRepository pointTypeRepository(){
        return new PointTypeMemRepository();
    }
}
