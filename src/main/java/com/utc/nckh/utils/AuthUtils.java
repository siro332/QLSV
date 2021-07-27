package com.utc.nckh.utils;

import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthUtils {

    private final Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

    public static Algorithm getAlgorithm() {
        return algorithm;
    }
}
