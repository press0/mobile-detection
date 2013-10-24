package com.press.useragent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestBug.class,
        TestUAgentInfoAbstractBase.class,
        TestUAgentInfoCtorCoverage.class,
        TestUAgentInfoFullCoverage.class
})
public class TestAll {}