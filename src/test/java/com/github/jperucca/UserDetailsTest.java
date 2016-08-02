package com.github.jperucca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class UserDetailsTest {

    @Autowired
    JacksonTester<UserDetails> json;

    @Test
    public void should_map_to_json() throws IOException {
        final UserDetails userDetails = UserDetails.builder().name("John").roles(singletonList("client")).build();

        final JsonContent<UserDetails> content = json.write(userDetails);

        System.out.println(content);
        assertThat(content)
                .isEqualToJson("user_details.json")
        // or for another assertion way, field by field
                .hasJsonPathStringValue("@.name")
                .hasJsonPathArrayValue("@.roles");
        assertThat(content)
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("John");
        assertThat(content)
                .extractingJsonPathArrayValue("@.roles")
                .contains("client");
    }

}