package com.press.useragent;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class TestUAgentInfoFullCoverage extends TestUAgentInfoAbstractBase {

    static Object[][] isTierMulti = {
		{ false, foo, foo }, 
		{ false, bar, foo } 
    };
	static Object[][] detectTierRichCss = { //TODO

		//this particular method is a tough nut to cover.................
		
		{ false, foo, foo }, 
	
		//detectMobileQuick && (!detectTierIphone() && !detectKindle)
		//&&
		//detectWebkit | 
		//detectS60OssBrowser |
		//detectBlackBerryHigh |
		//detectWindowsMobile |
		//engineTelecaQ |

	};
    static Object[][] detectWapWml = {
    	{ true, foo, vndwap },
    	{ true, foo, wml },
    	{ false, foo, foo },
    };
    static Object[][] detectSonyMylo = {
  		{ false, foo, foo }, 
  		{ true, qtembedded + manuSony, foo },
  		{ true, mylocom2 + manuSony, foo },
  		{ false, qtembedded, foo },
  		{ false, mylocom2, foo },
  		{ false, manuSony, foo }
    };
    static Object[][] detectTierTablet = {
        { false, foo, foo }, 
  		
        /////////////detectIpad
  		{ true, deviceIpad + engineWebKit, foo }, 
  		{ false, deviceIpad, foo }, 
  		{ false, engineWebKit, foo },

        
        /////////////detectAndroidTablet
        
  		//detectOperaMobile
  		// ! ( X  && ( Y || Z ))
        { false, engineOpera + mini + mobi, foo },
  		{ false, engineOpera + mini, foo },
  		{ false, engineOpera + mobi, foo },
  		{ false, engineOpera, foo },
  		{ false, mini, foo },
  		{ false, mobi, foo },
  		
  		{ false, deviceHtcFlyer, foo },

  		//Google: it's a tablet if it matches Android and NOT 'mobile'
  		{ true, deviceAndroid + deviceGoogleTV, foo },
  		{ true, deviceAndroid, foo  },
  		{ true, deviceGoogleTV, foo },

  		{ false, deviceAndroid + deviceGoogleTV + mobile, foo },
  		{ false, deviceAndroid  + mobile, foo },
  		{ false, deviceGoogleTV + mobile, foo },
  		{ false, deviceHtcFlyer + mobile, foo },

  		{ false, engineOpera + mobile, foo },
  		{ false, mobile, foo },

        /////////////detectBlackBerryTablet
  		{ true, deviceBBPlaybook, foo },
  		
        /////////////detectWebOSTablet
  		{ true, deviceWebOShp + deviceTablet, foo },
  		{ false, deviceWebOShp, foo },
  		{ false, deviceTablet, foo },
    };
    static Object[][] detectOperaMobile = {
  		{ false, foo, foo }, 
  		{ true, engineOpera + mini + mobi, foo },
  		{ true, engineOpera + mini, foo },
  		{ true, engineOpera + mobi, foo },
  		{ false, mini + mobi, foo },
  		{ false, engineOpera, foo },
  		{ false, mini, foo },
  		{ false, mobi, foo }
    	
    };
    static Object[][] detectMobileQuick = {
		{ false, foo, foo }, 

		//!isTierTablet
		{ false, deviceIpad + engineWebKit, foo }, 
		
		//detectWapWml()
    	{ true, foo, vndwap },
    	{ true, foo, wml },
    	{ false, foo, foo },
    	//detectBrewDevice()
		{ true, deviceBrew, foo },
		//detectOperaMobile()
  		{ false, foo, foo }, 
  		{ true, engineOpera + mini + mobi, foo },
  		{ true, engineOpera + mini, foo },
  		{ true, engineOpera + mobi, foo },
  		{ false, mini + mobi, foo },
  		{ false, engineOpera, foo },
  		{ false, mini, foo },
  		{ false, mobi, foo },
  		
  		{ true, engineNetfront, foo },
  		{ true, engineUpBrowser, foo },
  		{ true, engineOpenWeb, foo },
  		

        //detectDangerHiptop()detectMidpCapable
		{ true, deviceDanger + deviceHiptop, foo },
		{ true, deviceDanger, foo },
		{ true, deviceHiptop, foo },

		//detectMidpCapable()
		{ true, deviceMidp, deviceMidp },
		{ true, foo, deviceMidp },
		{ true, deviceMidp, foo },

		//detectMaemoTablet()
		{ true, maemo, foo },
		{ true, linux + deviceTablet, foo },

		{ false, linux, foo },
		{ false, deviceTablet, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceTablet + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceTablet, foo },
		{ false, linux + deviceTablet + deviceTablet + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp, foo },

		//detectArchos()
		{ true, deviceArchos, foo },
  		
  		//devicePda & ! disUpdate
		{ true, devicePda, foo },
		{ false, devicePda + disUpdate, foo },
		
		//mobile
		{ true, mobile, foo },
		
		//detectKindle()
		{ true, deviceKindle, foo },

		{ false, deviceAndroid + deviceGoogleTV, foo },
		{ false, deviceAndroid, foo },
		{ false, deviceGoogleTV, foo },
		{ true, deviceHtcFlyer, foo },

		{ false, deviceAndroid + deviceGoogleTV + deviceKindle, foo },
		{ false, deviceAndroid + deviceKindle, foo },
		{ false, deviceGoogleTV + deviceKindle, foo },
		{ true, deviceHtcFlyer + deviceKindle, foo },

		
		//detectAmazonSilk()
		{ true, engineSilk, foo },

    };    
    static Object[][] detectGameConsole = {
		{ false, foo, foo }, 

		{ true, deviceNintendo + deviceWii + deviceNintendoDs, foo },
		{ true, deviceNintendo, foo },
		{ true, deviceWii, foo },
		{ true, deviceNintendoDs, foo },
		
		{ true, devicePlaystation, foo },
		{ true, deviceXbox, foo },
    };
    static Object[][] detectMaemoTablet = {
		{ false, foo, foo }, 

		{ true, maemo, foo },
		{ true, linux + deviceTablet, foo },

		{ false, linux, foo },
		{ false, deviceTablet, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceTablet + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceTablet, foo },
		{ false, linux + deviceTablet + deviceTablet + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp, foo },

	};
	static Object[][] detectArchos = {
		{ false, foo, foo }, 
		{ true, deviceArchos, foo }
	};
	static Object[][] detectIPhone = {
    	{ false, foo, foo  }, 
    	{ true, deviceIphone, foo  },
  		{ true, deviceIpod, foo  },
  		{ true, deviceIphone + deviceIpod, foo  }, 
  		{ false, deviceIpad, foo  },
	};

	
	static Object[][] detectWindowsMobile = {

		{ false, foo, foo }, 
		{ false, deviceWinPhone7, foo }, 

		/////////////////////////////////
		{ true, deviceWinMob, foo },
		{ true, deviceIeMob, foo },
		{ true, enginePie, foo },
		/////////////////////////////////
		// (userAgent.indexOf(manuHtc) != -1 && userAgent.indexOf(deviceWindows) != -1) 
		// manuHtc && deviceWindows 
		{ true, manuHtc + deviceWindows, foo },
		{ false, manuHtc, foo },
		{ false, deviceWindows, foo },
		/////////////////////////////////
		// (detectWapWml() && userAgent.indexOf(deviceWindows) != -1)) {
		// ( vndwap || wml ) && deviceWindows
		
		{ true, deviceWindows, wml },
		{ true, deviceWindows, vndwap },
		{ true, deviceWindows, wml + vndwap },
		
		{ false, foo, wml},
		{ false, foo, vndwap },
		{ false, foo, wml + vndwap },
		/////////////////////////////////
		
		{ false, devicePpc + deviceMacPpc, foo },
		{ true, devicePpc, foo },
		{ false, deviceMacPpc, foo }
    };
	
	
	
    static Object[][] detectBlackBerryWebKit = {

		{ false, foo, foo }, 
		{ true, deviceBB + engineWebKit, vndRIM }, 
		{ true, deviceBB + engineWebKit, foo }, 
		{ true, engineWebKit, vndRIM }, 

		{ false, deviceBB, vndRIM }, 
		{ false, deviceBB , foo }, 
		{ false, foo, vndRIM }, 
    };
    static Object[][] detectBlackBerry = {
		{ false, foo, foo  }, 
		{ true, deviceBB, vndRIM }, 
		{ true, deviceBB, foo }, 
		{ true, foo, vndRIM }, 
    };
    static Object[][] detectBlackBerryTouch = {

        { false, foo, foo  }, 
		{ true, deviceBBStorm, foo }, 
		{ true, deviceBBTorch, foo }, 
		{ true, deviceBBBoldTouch, foo }, 
		{ true, deviceBBCurveTouch, foo }
    };
    static Object[][] detectBlackBerryHigh = {

    	{ false, foo, foo  }, 
		//!detectBlackBerryWebKit()
        { false, deviceBB + engineWebKit, vndRIM }, 
		{ false, deviceBB + engineWebKit, foo }, 
		{ false, engineWebKit, vndRIM }, 

		//BlackBerry() && { BlackBerryTouch() || deviceBBBold || deviceBBTour || deviceBBCurve }
		
		//BlackBerry()
		//{ true, deviceBB, vndRIM }, 
		//{ true, deviceBB, foo }, 
		//{ true, foo, vndRIM }, 

		//BlackBerryTouch()
		//{ true, deviceBBStorm, foo }, 
		//{ true, deviceBBTorch, foo }, 
		//{ true, deviceBBBoldTouch, foo }, 
		//{ true, deviceBBCurveTouch, foo }, 

		
		//BlackBerry() & BlackBerryTouch()
		{ true, deviceBB + deviceBBStorm, vndRIM }, 
		{ true, deviceBB + deviceBBStorm, foo }, 
		{ true, foo + deviceBBStorm, vndRIM }, 

		{ true, deviceBB + deviceBBTorch, vndRIM }, 
		{ true, deviceBB + deviceBBTorch, foo }, 
		{ true, foo + deviceBBTorch, vndRIM }, 

		{ true, deviceBB + deviceBBBoldTouch, vndRIM }, 
		{ true, deviceBB + deviceBBBoldTouch, foo }, 
		{ true, foo + deviceBBBoldTouch, vndRIM }, 

		{ true, deviceBB + deviceBBCurveTouch, vndRIM }, 
		{ true, deviceBB + deviceBBCurveTouch, foo }, 
		{ true, foo + deviceBBCurveTouch, vndRIM }, 

		//BlackBerry() && {deviceBBBold || deviceBBTour || deviceBBCurve }
		{ true, deviceBB + deviceBBBold, vndRIM }, 
		{ true, deviceBB + deviceBBBold, foo }, 
		{ true, foo + deviceBBBold, vndRIM }, 

		{ true, deviceBB + deviceBBTour, vndRIM }, 
		{ true, deviceBB + deviceBBTour, foo }, 
		{ true, foo + deviceBBTour, vndRIM }, 

		{ true, deviceBB + deviceBBCurve, vndRIM }, 
		{ true, deviceBB + deviceBBCurve, foo }, 
		{ true, foo + deviceBBCurve, vndRIM }, 
		
		//!BlackBerry()
		{ false, deviceBB, vndRIM }, 
		{ false, deviceBB, foo }, 
		{ false, foo, vndRIM }, 

    };
    static Object[][] detectBlackBerryLow = {
				
		{ false, foo, foo  }, 
		
		//! detectBlackBerryWebKit()
		{ false, deviceBB + engineWebKit, vndRIM }, 
		{ false, deviceBB + engineWebKit, foo }, 
		{ false, engineWebKit, vndRIM }, 
		
		//detectBlackBerry() && detectBlackBerryTouch() && (deviceBBBold || deviceBBTour || deviceBBCurve)
		{ true, deviceBB, vndRIM }, 
		{ true, deviceBB, foo }, 
		{ true, foo, vndRIM }, 
		
		{ false, deviceBB + deviceBBStorm + deviceBBTorch + deviceBBBoldTouch + deviceBBCurveTouch, vndRIM }, 
		{ false, deviceBB + deviceBBStorm + deviceBBTorch + deviceBBBoldTouch + deviceBBCurveTouch, foo }, 
		{ false, deviceBBStorm + deviceBBTorch + deviceBBBoldTouch + deviceBBCurveTouch, vndRIM }, 

    };
    static Object[][] detectMidpCapable = {
		{ false, foo, foo }, 
		{ true, deviceMidp, deviceMidp },
		{ true, foo, deviceMidp },
		{ true, deviceMidp, foo },
    };
    static Object[][] detectTierIphone = {

		{ false, foo, foo }, 
    	//detectIPhone
    	{ true, deviceIphone, foo  },
  		{ true, deviceIpod, foo  },
  		{ true, deviceIphone + deviceIpod, foo  }, 
  		{ false, deviceIpad, foo  },
  		//detectAndroidPhone
    	{ false, foo, foo  }, 
    	{ true, deviceAndroid + mobile, foo  },
  		{ false, deviceAndroid, foo  },
  		{ false, mobile, foo  },
  		{ true, engineOpera + deviceAndroid + mobi, foo  },
  		{ true, deviceHtcFlyer, foo  },
  		
		//detectBlackBerryWebKit & detectBlackBerryTouch
		{ false, deviceBB + engineWebKit, vndRIM }, 
		{ false, deviceBB + engineWebKit, foo }, 
		{ false, engineWebKit, vndRIM }, 

		{ false, deviceBB, vndRIM }, 
		{ false, deviceBB , foo }, 
		{ false, foo, vndRIM }, 
		 
		//////////////////////////////////////
		
		{ false, deviceBB, vndRIM }, 
		{ false, deviceBB, foo }, 
		{ false, foo, vndRIM }, 

		{ false, deviceBB + deviceBBStorm, vndRIM }, 
		{ false, deviceBB + deviceBBStorm, foo }, 
		{ false, deviceBBStorm, vndRIM }, 

		{ false, deviceBB + deviceBBTorch, vndRIM }, 
		{ false, deviceBB + deviceBBTorch, foo }, 
		{ false, deviceBBTorch, vndRIM }, 

		{ false, deviceBB + deviceBBBoldTouch, vndRIM }, 
		{ false, deviceBB + deviceBBBoldTouch, foo }, 
		{ false, deviceBBBoldTouch, vndRIM }, 

		{ false, deviceBB + deviceBBCurveTouch, vndRIM }, 
		{ false, deviceBB + deviceBBCurveTouch, foo }, 
		{ false, deviceBBCurveTouch, vndRIM }, 
		
		//detectWindowsPhone7
		{ true, deviceWinPhone7, foo },

        //detectPalmWebOS
		{ true, deviceWebOS, foo },

		
        //detectGarminNuvifone
		{ true, deviceNuvifone, foo },
		
    };
    static Object[][] detectSmartphone = {
		
    	//detectIPhone,
    	{ false, foo, foo  }, 
    	{ true, deviceIphone, foo  },
  		{ true, deviceIpod, foo  },
  		{ true, deviceIphone + deviceIpod, foo  }, 
  		{ false, deviceIpad, foo  },
    	//detectAndroidPhone,
    	{ false, foo, foo  }, 
    	{ true, deviceAndroid + mobile, foo  },
  		{ false, deviceAndroid, foo  },
  		{ false, mobile, foo  },
  		{ true, engineOpera + deviceAndroid + mobi, foo  },
  		{ true, deviceHtcFlyer, foo  },

    	////////////////isTierIphone
		//isIPhone
		//isAndroidPhone
		//detectBlackBerryWebKit && detectBlackBerryTouch
		//see TestUAgentInfoFullCoverage
		//detectBlackBerryWebKit & detectBlackBerryTouch
		//BlackBerry() & BlackBerryTouch()
		{ true, deviceBB + deviceBBStorm, vndRIM }, 
		{ true, deviceBB + deviceBBStorm, foo }, 
		{ true, foo + deviceBBStorm, vndRIM }, 
		
		{ true, deviceBB + deviceBBTorch, vndRIM }, 
		{ true, deviceBB + deviceBBTorch, foo }, 
		{ true, foo + deviceBBTorch, vndRIM }, 
		
		{ true, deviceBB + deviceBBBoldTouch, vndRIM }, 
		{ true, deviceBB + deviceBBBoldTouch, foo }, 
		{ true, foo + deviceBBBoldTouch, vndRIM }, 
		
		{ true, deviceBB + deviceBBCurveTouch, vndRIM }, 
		{ true, deviceBB + deviceBBCurveTouch, foo }, 
		{ true, foo + deviceBBCurveTouch, vndRIM }, 
		
		//BlackBerry() && {deviceBBBold || deviceBBTour || deviceBBCurve }
		{ true, deviceBB + deviceBBBold, vndRIM }, 
		{ true, deviceBB + deviceBBBold, foo }, 
		{ true, foo + deviceBBBold, vndRIM }, 
		
		{ true, deviceBB + deviceBBTour, vndRIM }, 
		{ true, deviceBB + deviceBBTour, foo }, 
		{ true, foo + deviceBBTour, vndRIM }, 
		
		{ true, deviceBB + deviceBBCurve, vndRIM }, 
		{ true, deviceBB + deviceBBCurve, foo }, 
		{ true, foo + deviceBBCurve, vndRIM }, 
		
		//!BlackBerry()
		//{ false, deviceBB, vndRIM }, 
		//{ false, deviceBB, foo }, 
		//{ false, foo, vndRIM }, 
		//detectWindowsMobile
		//TODO?????
		
		//detectWindowsPhone7
		{ true, deviceWinPhone7, foo },
	
		//detectPalmWebOS
		{ true, deviceWebOS, foo },
		
		//detectGarminNuvifone
		{ true, deviceNuvifone, foo },
    };
    static Object[][] detectMobileLong = {
    	
    	/////////////////////////////////////////////detectMobileQuick()
		//!isTierTablet
		{ false, deviceIpad + engineWebKit, foo }, 
		
		//detectWapWml()
    	{ true, foo, vndwap },
    	{ true, foo, wml },
    	{ false, foo, foo },
    	//detectBrewDevice()
		{ true, deviceBrew, foo },
		//detectOperaMobile()
  		{ false, foo, foo }, 
  		{ true, engineOpera + mini + mobi, foo },
  		{ true, engineOpera + mini, foo },
  		{ true, engineOpera + mobi, foo },
  		{ false, mini + mobi, foo },
  		{ false, engineOpera, foo },
  		{ false, mini, foo },
  		{ false, mobi, foo },
  		
  		{ true, engineNetfront, foo },
  		{ true, engineUpBrowser, foo },
  		{ true, engineOpenWeb, foo },
  		

        //detectDangerHiptop()detectMidpCapable
		{ true, deviceDanger + deviceHiptop, foo },
		{ true, deviceDanger, foo },
		{ true, deviceHiptop, foo },

		//detectMidpCapable()
		{ true, deviceMidp, deviceMidp },
		{ true, foo, deviceMidp },
		{ true, deviceMidp, foo },

		//detectMaemoTablet()
		{ true, maemo, foo },
		{ true, linux + deviceTablet, foo },

		{ false, linux, foo },
		{ false, deviceTablet, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceTablet + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceTablet, foo },
		{ false, linux + deviceTablet + deviceTablet + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp + deviceAndroid, foo },
		{ false, linux + deviceTablet + deviceWebOShp, foo },

		//detectArchos()
		{ true, deviceArchos, foo },
  		
  		//devicePda & ! disUpdate
		{ true, devicePda, foo },
		{ false, devicePda + disUpdate, foo },
		
		//mobile
		{ true, mobile, foo },
		
		//detectKindle()
		{ true, deviceKindle, foo },

		{ false, deviceAndroid + deviceGoogleTV, foo },
		{ false, deviceAndroid, foo },
		{ false, deviceGoogleTV, foo },
		{ true, deviceHtcFlyer, foo },

		{ false, deviceAndroid + deviceGoogleTV + deviceKindle, foo },
		{ false, deviceAndroid + deviceKindle, foo },
		{ false, deviceGoogleTV + deviceKindle, foo },
		{ true, deviceHtcFlyer + deviceKindle, foo },

		
		//detectAmazonSilk()
		{ true, engineSilk, foo },

    	
    	//////////////////////////////////detectGameConsole()
		{ true, deviceNintendo + deviceWii + deviceNintendoDs, foo },
		{ true, deviceNintendo, foo },
		{ true, deviceWii, foo },
		{ true, deviceNintendoDs, foo },
		
		{ true, devicePlaystation, foo },
		{ true, deviceXbox, foo },

    	
    	//////////////////////////////////detectSonyMylo()
  		{ false, foo, foo }, 
  		{ true, qtembedded + manuSony, foo },
  		{ true, mylocom2 + manuSony, foo },
  		{ false, qtembedded, foo },
  		{ false, mylocom2, foo },
  		{ false, manuSony, foo },

    	
		{ true, uplink, foo },
		{ true, manuSonyEricsson, foo },
		{ true, manuericsson, foo },
		{ true, manuSamsung1, foo },
		{ true, svcDocomo, foo },
		{ true, svcKddi, foo },
		{ true, svcVodafone, foo },
    };
	static Object[][] detectBrewDevice = {   
		{ false, foo, foo }, 
		{ true, deviceBrew, foo },
	};
	static Object[][] detectDangerHiptop = {   
		{ false, foo, foo }, 
		{ true, deviceDanger + deviceHiptop, foo },
		{ true, deviceDanger, foo },
		{ true, deviceHiptop, foo },
		
	};
	static Object[][] detectOperaAndroidTablet = {
		{ false, foo, foo }, 
		{ true, engineOpera + deviceAndroid + deviceTablet, foo },
		{ false, engineOpera + deviceAndroid, foo },
		{ false, deviceAndroid + deviceTablet, foo },
		{ false, engineOpera + deviceTablet, foo },
		{ false, engineOpera, foo },
		{ false, deviceAndroid, foo },
		{ false, deviceTablet, foo },
	};
	static Object[][] detectKindle = {
		{ false, foo, foo }, 
		{ true, deviceKindle, foo },
	
		{ false, deviceAndroid + deviceGoogleTV, foo },
		{ false, deviceAndroid, foo },
		{ false, deviceGoogleTV, foo },
		{ false, deviceHtcFlyer, foo },
	
		{ false, deviceAndroid + deviceGoogleTV + deviceKindle, foo },
		{ false, deviceAndroid + deviceKindle, foo },
		{ false, deviceGoogleTV + deviceKindle, foo },
		{ false, deviceHtcFlyer + deviceKindle, foo },
	};
	static Object[][] detectAmazonSilk = {
		{ false, foo, foo }, 
		{ true, engineSilk, foo },
	};
	static Object[][] detectSonyPlaystation = {
		{ false, foo, foo },
		{ true, devicePlaystation, foo },
	};
	static Object[][] detectNintendo = {
		{ false, foo, foo }, 
		{ true, deviceNintendo + deviceWii + deviceNintendoDs, foo },
		{ true, deviceNintendo, foo },
		{ true, deviceWii, foo },
		{ true, deviceNintendoDs, foo },
	};
	static Object[][] detectXbox = {
		{ false, foo, foo }, 
		{ true, deviceXbox, foo },
	};
    static Object[][] detectWindowsPhone7 = {
		{ false, foo, foo }, 
		{ true, deviceWinPhone7, foo },
    };
    static Object[][] detectBlackBerryTablet = {
		{ false, foo, foo }, 
		{ true, deviceBBPlaybook, foo },
    };
    static Object[][] detectPalmWebOS = {
		{ false, foo, foo }, 
		{ true, deviceWebOS, foo },
    };
    static Object[][] detectAndroidWebKit = {
		{ false, foo, foo }, 

		{ true, deviceAndroid  + engineWebKit, foo },
		{ true, deviceGoogleTV + engineWebKit, foo },
		{ true, deviceHtcFlyer + engineWebKit, foo },

		{ false, deviceAndroid, foo },
		{ false, deviceGoogleTV, foo },
		{ false, deviceHtcFlyer, foo }
   };
    static Object[][] detectS60OssBrowser = {
		{ false, foo, foo }, 

		{ true, deviceSymbian  + engineWebKit, foo },
		{ true, deviceS60 + engineWebKit, foo },
		{ false, deviceSymbian, foo },
		{ false, deviceS60, foo },
		{ false, engineWebKit, foo }
   };
    static Object[][] detectSymbianOS = {
		{ false, foo, foo }, 

		{ true, deviceSymbian, foo },
		{ true, deviceS60, foo },
		{ true, deviceS70, foo },
		{ true, deviceS80, foo },
		{ true, deviceS90, foo }
    };
    static Object[][] detectOperaAndroidPhone = {
   		{ false, foo, foo }, 
		{ true, engineOpera + deviceAndroid + mobi, foo },
		{ false, mobi, foo },
		{ false, deviceAndroid, foo },
		{ false, deviceAndroid + mobi, foo },
		{ false, engineOpera, foo },
		{ false, engineOpera + mobi, foo },
		{ false, engineOpera + deviceAndroid, foo }
    };
	static Object[][] detectAndroidPhone = {
    	{ false, foo, foo }, 
    	{ true, deviceAndroid + mobile, foo },
  		{ false, deviceAndroid, foo },
  		{ false, mobile, foo  },
  		{ true, engineOpera + deviceAndroid + mobi, foo },
  		{ true, deviceHtcFlyer, foo },
	};
    static Object[][] detectAndroidTablet = {
    	 
    	{ false, foo, foo }, 
		
 		//detectOperaMobile
			// ! ( X  && ( Y || Z ))
         { false, engineOpera + mini + mobi, foo },
 		{ false, engineOpera + mini, foo },
 		{ false, engineOpera + mobi, foo },
 		{ false, mini + mobi, foo },
 		{ false, engineOpera, foo },
 		{ false, mini, foo },
 		{ false, mobi, foo },
 		
        { false, engineOpera + mini + mobi + deviceAndroid + deviceGoogleTV, foo },
 		{ false, engineOpera + mini + deviceAndroid + deviceGoogleTV, foo },
 		{ false, engineOpera + mobi + deviceAndroid + deviceGoogleTV, foo },

 		
 		{ false, deviceHtcFlyer, foo },

 		//Google: it's a tablet if it matches Android and NOT 'mobile'
 		{ true, deviceAndroid + deviceGoogleTV, foo },
 		{ true, deviceAndroid, foo  },
 		{ true, deviceGoogleTV, foo },

 		{ false, deviceAndroid + deviceGoogleTV + mobile, foo },
 		{ false, deviceAndroid  + mobile, foo },
 		{ false, deviceGoogleTV + mobile, foo },
 		{ false, deviceHtcFlyer + mobile, foo },

 		{ false, engineOpera + mobile, foo },
 		{ false, mobile, foo }   
    };
    static Object[][] detectGarminNuvifone = {
    	{ false, foo, foo },
		{ false, foo, foo }, 
		{ true, deviceNuvifone, foo },
    };
    static Object[][] detectWebOSTablet = {
		{ false, foo, foo }, 
		{ true, deviceWebOShp + deviceTablet, foo },
		{ false, deviceWebOShp, foo },
		{ false, deviceTablet, foo },
    };
    static Object[][] detectPalmOS = {
		{ false, foo, foo }, 
		{ true, devicePalm, foo },
		{ true, engineBlazer, foo },
		{ true, engineXiino, foo },

		{ false, devicePalm + deviceWebOS, foo },
		{ false, engineBlazer + deviceWebOS, foo },
		{ false, engineXiino + deviceWebOS, foo },
    };
    static Object[][] detectIos = {
   		{ false, foo, foo }, 
		{ true, deviceIphone + deviceIpod + deviceIpad, foo }, 
		{ true, deviceIphone + deviceIpod, foo }, 
		{ true, deviceIphone + deviceIpad, foo }, 
		{ true, deviceIpod + deviceIpad, foo }, 
		{ true, deviceIphone, foo }, 
		{ true, deviceIpod, foo }, 
		{ true, deviceIpad + engineWebKit, foo }, 
		{ false, deviceIpad, foo }
    };
    static Object[][] detectGoogleTV = {
		{ false, foo, foo }, 
		{ false, foo, foo }, 
		{ true, deviceGoogleTV, foo }
    };
    static Object[][] detectAndroid = {
		{ false, foo, foo }, 
		{ true, deviceAndroid + deviceGoogleTV, foo },
		{ true, deviceAndroid, foo  },
		{ true, deviceGoogleTV, foo },
		{ true, deviceHtcFlyer, foo }
    };
    static Object[][] detectIpod = {
 		{ false, foo, foo  }, 
 		{ true, deviceIpod, foo  }
    };
    static Object[][] detectIpad = {
		{ false, foo, foo }, 
		{ true, deviceIpad + engineWebKit, foo }, 
		{ false, deviceIpad, foo }, 
		{ false, engineWebKit, foo }
     };
    static Object[][] detectIphoneOrIpod = {
		{ false, foo, foo }, 
		{ true, deviceIphone + deviceIpod, foo }, 
		{ true, deviceIphone, foo }, 
		{ true, deviceIpod, foo }
    };
    static Object[][] detectWebkit = {
		{ false, foo, foo }, 
		{ true, engineWebKit, foo } 
    };
    static Object[][] detectIphone = {
		{ false, foo, foo }, 
		{ true, deviceIphone, foo },
		{ false, deviceIpad + deviceIpad, foo },
		{ false, deviceIpad + deviceIpod, foo },
		{ false, deviceIphone + deviceIpad + engineWebKit, foo },
		{ false, deviceIphone + deviceIpod, foo }
   };

    public TestUAgentInfoFullCoverage(boolean expect, String userAgent, String httpAccept)
    {
    	super(expect, userAgent, httpAccept);
    }
    
    @RunWith(Parameterized.class) public static class detectMobileLong extends TestUAgentInfoFullCoverage {
        public detectMobileLong(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectMobileLong );
        }
     	@Test public void tdetectMobileLong() {
    		assertEquals( detectMobileLong(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectWindowsMobile extends TestUAgentInfoFullCoverage {
        public detectWindowsMobile(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectWindowsMobile );
        }
     	@Test public void tdetectWindowsMobile() {
    		assertEquals( detectWindowsMobile(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectBlackBerry extends TestUAgentInfoFullCoverage {
        public detectBlackBerry(boolean pass, String userAgent, String httpAccept) { super(pass, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectBlackBerry );
        }
     	@Test public void tdetectBlackBerry() {
    		assertEquals( detectBlackBerry(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectBlackBerryWebKit extends TestUAgentInfoFullCoverage {
        public detectBlackBerryWebKit(boolean pass, String userAgent, String httpAccept) { super(pass, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectBlackBerryWebKit );
        }
     	@Test public void tdetectBlackBerryWebKit() {
    		assertEquals( detectBlackBerryWebKit(), expect );
    	}
    }
 
    @RunWith(Parameterized.class) public static class detectBlackBerryTouch extends TestUAgentInfoFullCoverage {
        public detectBlackBerryTouch(boolean pass, String userAgent, String httpAccept) { super(pass, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectBlackBerryTouch );
        }
     	@Test public void tdetectBlackBerryTouch() {
    		assertEquals( detectBlackBerryTouch(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectBlackBerryHigh extends TestUAgentInfoFullCoverage {
        public detectBlackBerryHigh(boolean pass, String userAgent, String httpAccept) { super(pass, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectBlackBerryHigh );
        }
     	@Test public void tdetectBlackBerryHigh() {
    		assertEquals( detectBlackBerryHigh(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectBlackBerryLow extends TestUAgentInfoFullCoverage {
        public detectBlackBerryLow(boolean pass, String userAgent, String httpAccept) { super(pass, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectBlackBerryLow );
        }
     	@Test public void tdetectBlackBerryLow() {
    		assertEquals( detectBlackBerryLow(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectMidpCapable extends TestUAgentInfoFullCoverage {
        public detectMidpCapable(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectMidpCapable );
        }
     	@Test public void tdetectMidpCapable() {
    		assertEquals( detectMidpCapable(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectTierIphone extends TestUAgentInfoFullCoverage {
        public detectTierIphone(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectTierIphone );
        }
     	@Test public void tdetectTierIphone() {
    		assertEquals( detectTierIphone(), expect );
    	}
    }

    //TODO
    @RunWith(Parameterized.class) public static class detectSmartphone extends TestUAgentInfoFullCoverage {
        public detectSmartphone(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectSmartphone );
        }
     	@Test public void tdetectSmartphone() {
     		assertEquals( detectSmartphone(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectWapWml extends TestUAgentInfoFullCoverage {
        public detectWapWml(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectWapWml );
        }
        
     	@Test public void tdetectWapWml() {
     		assertEquals( detectWapWml(), expect );
 
    	}
    }

    @RunWith(Parameterized.class) public static class detectGameConsole extends TestUAgentInfoFullCoverage {
		public detectGameConsole(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
		@Parameterized.Parameters public static List<Object[]> data() {
			return Arrays.asList( detectGameConsole );
		}
	   	@Test public void tdetectGameConsole() {
	  		assertEquals( detectGameConsole(), expect );
	  	}
    }

    @RunWith(Parameterized.class) public static class detectMaemoTablet extends TestUAgentInfoFullCoverage {
    	public detectMaemoTablet(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
    	@Parameterized.Parameters public static List<Object[]> data() {
    		return Arrays.asList( detectMaemoTablet );
    	}
	   	@Test public void tdetectMaemoTablet() {
			assertEquals( detectMaemoTablet(), expect );
	   	}
    }
  
    @RunWith(Parameterized.class) public static class detectArchos extends TestUAgentInfoFullCoverage {
    	public detectArchos(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
    	@Parameterized.Parameters public static List<Object[]> data() {
    		return Arrays.asList( detectArchos );
    	}
    	@Test public void tdetectArchos() {
			assertEquals( detectArchos(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectSonyMylo extends TestUAgentInfoFullCoverage {
	    public detectSonyMylo(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectSonyMylo );
	    }
	 	@Test public void tdetectSonyMylo() {
				assertEquals( detectSonyMylo(), expect );
		}
    }

	//TODO
	@RunWith(Parameterized.class) public static class detectMobileQuick extends TestUAgentInfoFullCoverage {
	    public detectMobileQuick(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectMobileQuick );
	    }
	 	@Test public void tdetectMobileQuick() {
				assertEquals( detectMobileQuick(), expect );
		}
	}

	@RunWith(Parameterized.class) public static class detectOperaMobile extends TestUAgentInfoFullCoverage {
	    public detectOperaMobile(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectOperaMobile );
	    }
	 	@Test public void tdetectOperaMobile() {
			assertEquals( detectOperaMobile(), expect );
		}
	}

	@RunWith(Parameterized.class) public static class detectTierTablet extends TestUAgentInfoFullCoverage {
	    public detectTierTablet(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectTierTablet );
	    }
	 	@Test public void tdetectTierTablet() {
				assertEquals( detectTierTablet(), expect );
		}
	}

	@RunWith(Parameterized.class) public static class detectTierRichCss extends TestUAgentInfoFullCoverage {
	    public detectTierRichCss(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectTierRichCss );
	    }
	 	@Test public void tdetectTierRichCss() {
			assertEquals( detectTierRichCss(), expect );
		}
	}
	
	@RunWith(Parameterized.class) public static class detectBrewDevice extends TestUAgentInfoFullCoverage {
	    public detectBrewDevice(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectBrewDevice );
	    }
	 	@Test public void tdetectBrewDevice() {
			assertEquals( detectBrewDevice(), expect );
		}
	}
	
	@RunWith(Parameterized.class) public static class detectDangerHiptop extends TestUAgentInfoFullCoverage {
	    public detectDangerHiptop(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectDangerHiptop );
	    }
	 	@Test public void tdetectDangerHiptop() {
			assertEquals( detectDangerHiptop(), expect );
		}
	}
	
	@RunWith(Parameterized.class) public static class detectOperaAndroidTablet extends TestUAgentInfoFullCoverage {
	    public detectOperaAndroidTablet(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectOperaAndroidTablet );
	    }
	 	@Test public void tdetectOperaAndroidTablet() {
			assertEquals( detectOperaAndroidTablet(), expect );
		}
	}
	
	@RunWith(Parameterized.class) public static class detectKindle extends TestUAgentInfoFullCoverage {
	    public detectKindle(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectKindle );
	    }
	 	@Test public void tdetectKindle() {
			assertEquals( detectKindle(), expect );
		}
	}
	 
	@RunWith(Parameterized.class) public static class detectAmazonSilk extends TestUAgentInfoFullCoverage {
	    public detectAmazonSilk(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectAmazonSilk );
	    }
	 	@Test public void tdetectAmazonSilk() {
			assertEquals( detectAmazonSilk(), expect );
		}
	}
	
	@RunWith(Parameterized.class) public static class detectSonyPlaystation extends TestUAgentInfoFullCoverage {
	    public detectSonyPlaystation(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectSonyPlaystation );
	    }
	 	@Test public void tdetectSonyPlaystation() {
			assertEquals( detectSonyPlaystation(), expect );
		}
	}
	
	@RunWith(Parameterized.class) public static class detectNintendo extends TestUAgentInfoFullCoverage {
	    public detectNintendo(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectNintendo );
	    }
	 	@Test public void tdetectNintendo() {
			assertEquals( detectNintendo(), expect );
		}
	}

	@RunWith(Parameterized.class) public static class detectXbox extends TestUAgentInfoFullCoverage {
	    public detectXbox(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
	    @Parameterized.Parameters public static List<Object[]> data() {
	        return Arrays.asList( detectXbox );
	    }
	 	@Test public void tdetectXbox() {
			assertEquals( detectXbox(), expect );
		}
	}
    
	@RunWith(Parameterized.class) public static class detectGarminNuvifone  extends TestUAgentInfoFullCoverage {
        public detectGarminNuvifone (boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectGarminNuvifone );
        }
     	@Test public void tdetectGarminNuvifone() {
    		assertEquals( detectGarminNuvifone(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectWebOSTablet extends TestUAgentInfoFullCoverage {
    	
        public detectWebOSTablet(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }

        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectWebOSTablet );
        }
        
     	@Test public void tdetectWebOSTablet() {
    		assertEquals( detectWebOSTablet(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectPalmOS extends TestUAgentInfoFullCoverage {
        public detectPalmOS(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectPalmOS );
        }
     	@Test public void tdetectPalmOS() {
    		assertEquals( detectPalmOS(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectWindowsPhone7 extends TestUAgentInfoFullCoverage {
        public detectWindowsPhone7(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectWindowsPhone7 );
        }
     	@Test public void tdetectWindowsPhone7() {
    		assertEquals( detectWindowsPhone7(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectBlackBerryTablet extends TestUAgentInfoFullCoverage {
        public detectBlackBerryTablet(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectBlackBerryTablet );
        }
        
     	@Test public void tdetectBlackBerryTablet() {
    		assertEquals( detectBlackBerryTablet(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectPalmWebOS extends TestUAgentInfoFullCoverage {
        public detectPalmWebOS(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectPalmWebOS );
        }
     	@Test public void tdetectPalmWebOS() {
    		assertEquals( detectPalmWebOS(), expect );
    	}
    }

    @RunWith(Parameterized.class) 
    public static class detectAndroidWebKit extends TestUAgentInfoFullCoverage {
        public detectAndroidWebKit(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectAndroidWebKit );
        }
     	@Test public void tdetectAndroidWebKit() {
    		assertEquals( detectAndroidWebKit(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectS60OssBrowser extends TestUAgentInfoFullCoverage {
        public detectS60OssBrowser(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectS60OssBrowser );
        }
     	@Test public void tdetectS60OssBrowser() {
    		assertEquals( detectS60OssBrowser(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectOperaAndroidPhone extends TestUAgentInfoFullCoverage {
        public detectOperaAndroidPhone (boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectOperaAndroidPhone );
        }
     	@Test public void tdetectOperaAndroidPhone() {
    		assertEquals( detectOperaAndroidPhone(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectAndroidPhone extends TestUAgentInfoFullCoverage {
        public detectAndroidPhone(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectAndroidPhone );
        }
     	@Test public void tdetectAndroidPhone() {
    		assertEquals( detectAndroidPhone(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectAndroidTablet extends TestUAgentInfoFullCoverage {
        public detectAndroidTablet(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectAndroidTablet );
        }
     	@Test public void tdetectAndroidTablet() {
    		assertEquals( detectAndroidTablet(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectSymbianOS extends TestUAgentInfoFullCoverage {
        public detectSymbianOS(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectSymbianOS );
        }
     	@Test public void tdetectSymbianOS() {
    		assertEquals( detectSymbianOS(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectIos extends TestUAgentInfoFullCoverage {
        public detectIos(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectIos );
        }
     	@Test public void tDetectIos() {
    		assertEquals( detectIos(), expect );
    	}
    }
   
    @RunWith(Parameterized.class) public static class detectGoogleTV extends TestUAgentInfoFullCoverage {
        public detectGoogleTV(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectGoogleTV );
        }
     	@Test public void tDetectGoogleTV() {
    		assertEquals( detectGoogleTV(), expect );
    	}
    }
   
    @RunWith(Parameterized.class) public static class detectAndroid extends TestUAgentInfoFullCoverage {
        public detectAndroid(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectAndroid );
        }
     	@Test public void tdetectAndroid() {
    		assertEquals( detectAndroid(), expect );
    	}
    }
    
   @RunWith(Parameterized.class) public static class detectIpod extends TestUAgentInfoFullCoverage {
        public detectIpod(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectIpod );
        }
     	@Test public void tdetectIpod() {
    		assertEquals( detectIpod(), expect );
    	}
    }

   @RunWith(Parameterized.class) public static class detectIpad extends TestUAgentInfoFullCoverage {
        public detectIpad(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectIpad );
        }
     	@Test public void tdetectIpad() {
    		assertEquals( detectIpad(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectIphoneOrIpod extends TestUAgentInfoFullCoverage {
        public detectIphoneOrIpod(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( detectIphoneOrIpod );
        }
     	@Test public void tdetectIphoneOrIpod() {
    		assertEquals( detectIphoneOrIpod(), expect );
    	}
    }
    
    @RunWith(Parameterized.class) public static class detectWebkit extends TestUAgentInfoFullCoverage {
        public detectWebkit(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() { 
        	return Arrays.asList( detectWebkit );
        }
     	@Test public void tdetectWebkit() {
    		assertEquals( detectWebkit(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class detectIphone extends TestUAgentInfoFullCoverage {
        public detectIphone(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() { 
        	return Arrays.asList( detectIphone );
        }
     	@Test public void tdetectIphone() {
    		assertEquals( detectIphone(), expect );
    	}
    }

    @RunWith(Parameterized.class) public static class isTierMulti extends TestUAgentInfoFullCoverage {
        public isTierMulti(boolean expect, String userAgent, String httpAccept) { super(expect, userAgent, httpAccept); }
        @Parameterized.Parameters public static List<Object[]> data() {
            return Arrays.asList( isTierMulti );
        }
        @Test public void tgetIsIphone() {
    		assertEquals( getIsIphone(), expect );
    	}
    	@Test public void tgetIsTierTablet() {
    		assertEquals( getIsTierTablet(), expect );
    	}
    	@Test public void tgetIsTierIphone() {
    		assertEquals( getIsTierIphone(), expect );
    	}
    	@Test public void tgetIsTierRichCss() {
    		assertEquals( getIsTierRichCss(), expect );
    	}
    	@Test public void tgetIsTierGenericMobile() {
    		assertEquals( getIsTierGenericMobile(), expect );
    	}

    }

}

