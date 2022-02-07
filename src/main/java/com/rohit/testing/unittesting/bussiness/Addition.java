package com.rohit.testing.unittesting.bussiness;

import com.rohit.testing.unittesting.data.SampleDataService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;

@Data
public class Addition {

    private SampleDataService sampleDataService;


    public int sum(int [] inputValues){
        return Arrays.stream(inputValues).sum();
    }

    public int calculateSumFromData(){
        return Arrays.stream(sampleDataService.retrieveData()).sum();
    }
}
