package com.press.useragent;

import com.press.useragent.UAgentInfo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public abstract class TestUAgentInfoAbstractBase extends UAgentInfo {

	protected boolean expect;
	protected static int i = 0;
	protected static final String foo = "foo";
	protected static final String bar = "bar";

	public TestUAgentInfoAbstractBase(boolean expect, String userAgent, String httpAccept) {
    	super(userAgent, httpAccept);
        this.expect = expect;
	}
	
    @BeforeClass public static void beforeClass() { 
    	System.out.println("Creating new test Class instance..."); 
    }

    @Before public void beforeMethod() {
        System.out.println("test #" + i++ + ", expect:" + expect + ", userAgent:" + this.getUserAgent() + (this.getHttpAccept().equals("")? "" : ", httpAccept:" + this.getHttpAccept()));
	}

}
