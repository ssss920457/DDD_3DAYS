package com.uuu.boot.Demo1.infrastructure.repository;

import com.uuu.boot.Demo1.domain.PointType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PointTypeJPARepositoryTest {
    @Autowired
    private PointTypeJPARepository repository;
    @Test
    void repositoryShouldNotNull() {
        assertNotNull(repository);
    }
    @Test
    void savePointType() {
        PointType t = repository.save(new PointType("regular point","250NTD per class"));
        assertThat(repository.findById(t.getTypeId())).isNotNull();
    }
}