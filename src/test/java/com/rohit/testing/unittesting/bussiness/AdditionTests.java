package com.rohit.testing.unittesting.bussiness;

import com.rohit.testing.unittesting.data.SampleDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

class SampleDataServiceStub implements SampleDataService {

    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3};
    }

}

@RunWith(MockitoJUnitRunner.class)
class AdditionTests {

    @InjectMocks
    Addition addition;

    @Mock
    SampleDataService sampleDataService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void calculateSum_basic() {

        int actualResult = addition.sum(new int[]{1, 2, 3});
        int expectedResult = 6;

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSum_emptyArray() {

        int actualResult = addition.sum(new int[]{});
        int expectedResult = 0;

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSum_FromDataStub() {

        addition.setSampleDataService(new SampleDataServiceStub());
        int actualResult = addition.calculateSumFromData();
        int expectedResult = 6;

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSum_WithMockedData() {

        when(sampleDataService.retrieveData()).thenReturn(new int[]{4, 5, -2});
        int actualResult = addition.calculateSumFromData();
        int expectedResult = 7;

        Assertions.assertEquals(expectedResult, actualResult);
        verify(sampleDataService,atMostOnce()).retrieveData();

    }
}
