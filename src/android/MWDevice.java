package com.mbientlab.metawear.cordova;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import android.content.ServiceConnection;
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
import com.mbientlab.metawear.MetaWearBleService;

/**
 *
 * Created by Lance Gleason of Polyglot Programming LLC. on 10/11/2015.
 * http://www.polyglotprogramminginc.com
 * https://github.com/lgleasain
 * Twitter: @lgleasain
 *
 */

public class MWDevice extends CordovaPlugin {

    private MetaWearBleService.LocalBinder serviceBinder;

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
    }

    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        cordova.requestPermission(this, 0, Manifest.permission.ACCESS_FINE_LOCATION);
        final int duration = Toast.LENGTH_SHORT;
    }

    @Override
    public void onCreate(){
        
    }

    @Override
    public void onDestroy(){
        cordova.getActivity().getApplicationContext().unbindService(this);
    }

}
