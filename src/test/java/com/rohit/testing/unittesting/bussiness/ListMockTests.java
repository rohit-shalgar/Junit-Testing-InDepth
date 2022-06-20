package com.rohit.testing.unittesting.bussiness;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTests {

    @Test
    public void argumentCaptorsSample(){

        List<String> mockedList = mock(List.class);
        mockedList.add("someSampleString");
        mockedList.add("someSampleStringAgain");

        //on methods, we can capture arguments passed and verify them.
        //captor.capture() can we used to verify the data type
        //captor.getValue() can be used to get actual value with which the mock is invoked.
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mockedList,times(2)).add(captor.capture());
        assertEquals("someSampleString",captor.getAllValues().get(0));
        assertEquals("someSampleStringAgain",captor.getAllValues().get(1));

    }
}
