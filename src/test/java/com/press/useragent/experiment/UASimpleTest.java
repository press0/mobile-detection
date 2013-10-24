package com.press.useragent.experiment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UASimpleTest {

	UASimple uASimple;
	@Before
	public void init() {
		uASimple = new UASimple("foo"); 
		
	}
	
	@Test
	public void testSetter() {
		uASimple.setUserAgent(UASimple.deviceIphone  );
		assertEquals(uASimple.getUserAgent() , UASimple.deviceIphone );
	}

	@Test
	public void testGetter() {
		String string1 = "foo";
		uASimple.setUserAgent(string1);
		String string2 = uASimple.getUserAgent();
		assertEquals(string1, string2 );
	}

	@Test
	public void testCtor1() {
		String string1 = "foo";
		uASimple = new UASimple("foo");
		String string2 = uASimple.getUserAgent();
		assertEquals(string1, string2 );
	}

	@Test
	public void testCtor2() {
		uASimple = new UASimple(null);
		assertEquals("", "" );
	}

	class UASimple {
	    public static final String deviceIphone = "iphone";
	    private String userAgent = "";
	    
	    public UASimple(String userAgent) {
	        if (userAgent != null) {
	            this.userAgent = userAgent.toLowerCase();
	        } 
	    }
		public String getUserAgent() {
			return userAgent;
		}

		public String setUserAgent(String userAgent) {
			return this.userAgent = userAgent;
		}

	}

}
