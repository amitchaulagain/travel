package com.travel.service.impl;

import com.travel.model.repostiory.TestRepository;
import com.travel.service.TestService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TestServiceImplTest {
    private final TestRepository mockTestRepository = Mockito.mock(TestRepository.class);
    private final TestService mockTestService = Mockito.mock(TestService.class);

    @Test
    void save_test_results_should_work() {
        com.travel.model.entities.Test test = new com.travel.model.entities.Test();
        when(mockTestRepository.save(Mockito.any(com.travel.model.entities.Test.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        mockTestService.saveTestResults(test);

        assertNotNull(mockTestRepository.findById(1L));
    }
}