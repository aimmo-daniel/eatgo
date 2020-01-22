package sj.project.eatgo.utils;

import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class JwtUtilTest {

    private static final String SECRET = "1234567890123456789testsecretkey";

    private JwtUtil jwtUtil;

    @Before
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {
        String token = jwtUtil.createToken(1004L, "John");

        assertThat(token, containsString("."));
    }

    @Test
    public void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjY4LCJuYW1lIjoiVGVzdGVyIn0.lhPC6Pktxb9kUHgteB-9i2ywBokFgWXkctnQ5KIUvVo";

        Claims claims = jwtUtil.getClaims(token);

        assertThat(claims.get("userId", Long.class), is(68L));
        assertThat(claims.get("name"), is("Tester"));

    }

}