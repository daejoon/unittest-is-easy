package com.ddoong2.unittestiseasy.util;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.BuilderArbitraryGenerator;

public abstract class FixtureMonkeyUtil {

    public static FixtureMonkey fixture() {
        return FixtureMonkey.builder()
                .defaultGenerator(BuilderArbitraryGenerator.INSTANCE)
                .defaultNotNull(true)
                .build();
    }

}
