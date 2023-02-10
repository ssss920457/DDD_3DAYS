package com.uuu.boot.Demo1.domain.service;

import com.uuu.boot.Demo1.domain.PointType;
import com.uuu.boot.Demo1.domain.common.repository.PointTypeRepository;
import com.uuu.boot.Demo1.domain.common.service.PointTypeService;
import com.uuu.boot.Demo1.domain.common.service.PointTypeServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class PointTypeServiceUnitTest {
    private PointTypeRepository repository;
    private PointTypeService service;
    @BeforeAll
    static void PrepareOnce() {
        System.out.println("Prepare only once");
    }
    @AfterAll
    static void FinalCleanup() {
        System.out.println("final clean up");
    }
    @BeforeEach
    void Prepare() {
        System.out.println("prepare environment each time");
        repository = mock(PointTypeRepository.class);
        when(repository.save(ArgumentMatchers.any(PointType.class))).thenReturn(UUID.randomUUID());
        service = new PointTypeServiceImpl(repository);
    }
    @AfterEach
    void clean() {
        System.out.println("clean and store data");
    }
    @Test
    public void checkPrecondition() {
        Assertions.assertNotNull(repository);
        Assertions.assertNotNull(service);
    }
    @Test
    public void repositoryShouldSave() {
        PointType t = new PointType("type1","description1");
        UUID id = service.createPointType(t);
        //UUID id2 = service.createPointType(t);
        //System.out.println("id="+id.toString());
        verify(repository).save(ArgumentMatchers.any(PointType.class));
    }
    @Test
    public void serviceShouldReturnValidUUID() {
        PointType t = new PointType("type1","description1");
        UUID id = service.createPointType(t);
        Assertions.assertNotNull(id);
        System.out.println("UUID="+id.toString());
    }
    @Disabled("this feature has not yet implemented")
    @Test
    public void repositoryShouldCalledAccordingly() {
        service.allTypes();
        verify(repository).getAll();
    }
}
