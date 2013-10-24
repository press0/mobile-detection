package com.press.useragent;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

public class TestBug extends TestUAgentInfoAbstractBase {
	
    static Object[][] detectLegacyUAList = {
    	
		{ true, "Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; NOKIA; Lumia 710)", foo },
		
    };

    public TestBug(boolean expect, String userAgent, String httpAccept)
    {
    	super(expect, userAgent, httpAccept);
    }

    @RunWith(Parameterized.class) public static class detectMobileLong extends TestBug {
        public detectMobileLong(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectLegacyUAList );
        }
    	@Test public void tdetectMobileQuick() {
    		assertEquals( detectMobileQuick(), expect );
    	}
     	@Test public void tdetectMobileLong() {
    		assertEquals( detectMobileLong(), expect );
    	}
      	@Test public void tgetIsTierTablet() {
    		assertEquals( getIsTierTablet(), ! expect ); // not equal
    	}

     	@Test public void tboth() {
    		assertEquals( detectMobileQuick() || getIsTierTablet(), expect );
    	}
     	
    }
    


}
