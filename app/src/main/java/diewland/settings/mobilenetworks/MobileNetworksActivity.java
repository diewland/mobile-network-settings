package diewland.settings.mobilenetworks;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MobileNetworksActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        	startActivity(getMobileNetworkSettingIntent());
        }
        catch(Exception e){
        	// do nothing
        }
        finish();
    }
    
    private Intent getMobileNetworkSettingIntent(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        if(Build.VERSION.SDK_INT < 16){ // lower than jelly bean
	        intent.setComponent(new ComponentName("com.android.phone", "com.android.phone.Settings"));
        }
        else if(Build.VERSION.SDK_INT < 26){ // lower than oreo
	        intent.setComponent(new ComponentName("com.android.phone", "com.android.phone.MobileNetworkSettings"));
        }
        else { // oreo and upper
            return new Intent("android.settings.DATA_ROAMING_SETTINGS");
        }
        return intent;
    }
}