package sj.project.eatgo.utils;

import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class JwtUtilTest {

    @Test
    public void createToken() {
        String secret = "1234567890123456789testsecretkey";

        JwtUtil jwtUtil = new JwtUtil(secret);

        String token = jwtUtil.createToken(1004L, "John");

        assertThat(token, containsString("."));
    }

}