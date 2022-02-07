package com.rohit.testing.unittesting.bussiness;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertsTest {

    String actual = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";

    @SneakyThrows
    @Test
    public void jsonAsserts_strict(){

        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";

        JSONAssert.assertEquals(expected,actual,true);

    }

    @SneakyThrows
    @Test
    public void jsonAsserts_nonStrict(){

        String expected = "{id: 1,name:Ball}";

        JSONAssert.assertEquals(expected,actual,false);

    }
}
