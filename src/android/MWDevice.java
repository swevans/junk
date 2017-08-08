package com.mbientlab.metawear.cordova;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.content.ComponentName;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.util.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import android.Manifest;

import android.os.IBinder;

/**
 *
 * Created by Lance Gleason of Polyglot Programming LLC. on 10/11/2015.
 * http://www.polyglotprogramminginc.com
 * https://github.com/lgleasain
 * Twitter: @lgleasain
 *
 */

public class MWDevice extends CordovaPlugin {

    /**
     * Constructor.
     */
    public MWDevice() {}

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        /*
        cordova.getActivity().getApplicationContext().bindService(
                                       new Intent(cordova.getActivity(),
                                                  MetaWearBleService.class),
                                       this, Context.BIND_AUTO_CREATE
                                       );
        */

        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                try
				{
					resetWindow();
					
					final int uiOptions = 
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_FULLSCREEN
						| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
					
					window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
					decorView.setSystemUiVisibility(uiOptions);
					
					decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() 
					{
						@Override
						public void onFocusChange(View v, boolean hasFocus) 
						{
							if (hasFocus)
							{
								decorView.setSystemUiVisibility(uiOptions);
							}
						}
					});
					
					decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
					{
						@Override
						public void onSystemUiVisibilityChange(int visibility) 
						{
							decorView.setSystemUiVisibility(uiOptions);
						}
					});
					
					context.success();
				}
				catch (Exception e)
				{
					context.error(e.getMessage());
				}
            }
        });
    }

    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        return false;
    }

}
