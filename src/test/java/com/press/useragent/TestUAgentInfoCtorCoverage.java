package com.press.useragent;

import static org.junit.Assert.*;
import org.junit.Test;

import com.press.useragent.UAgentInfo;

public class TestUAgentInfoCtorCoverage {

	static final String foo = "foo";
	static final String bar = "bar";
	protected UAgentInfo uai;

	private void isNotNull() {
		assertNotNull( uai.getUserAgent() );
		assertNotNull( uai.getHttpAccept() );
	}

	@Test public void testCtorParams_00() {
		uai = new UAgentInfo(foo, bar);
		assertEquals( uai.getUserAgent(), foo );
		assertEquals( uai.getHttpAccept(), bar );
		isNotNull();
	}

	@Test public void testCtorParams_11() {
		uai = new UAgentInfo(null, null);
		assertEquals( uai.getUserAgent(), "" );
		assertEquals( uai.getHttpAccept(), "" );
		isNotNull();
	}

	@Test public void testCtorParams_01() {
		uai = new UAgentInfo(foo, null);
		assertEquals( uai.getUserAgent(), foo );
		assertEquals( uai.getHttpAccept(), "" );
		isNotNull();
	}

	@Test public void testCtorParams_10() {
		uai = new UAgentInfo(null, bar);
		assertEquals( uai.getUserAgent(), "" );
		assertEquals( uai.getHttpAccept(), bar );
		isNotNull();
	}

}
