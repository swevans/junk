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

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Color;
import android.os.Handler;

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

    public static final String ACTION_IS_SUPPORTED = "isSupported";
	public static final String ACTION_IS_IMMERSIVE_MODE_SUPPORTED = "isImmersiveModeSupported";
	public static final String ACTION_IMMERSIVE_WIDTH = "immersiveWidth";
	public static final String ACTION_IMMERSIVE_HEIGHT = "immersiveHeight";
	public static final String ACTION_LEAN_MODE = "leanMode";
	public static final String ACTION_SHOW_SYSTEM_UI = "showSystemUI";
	public static final String ACTION_SHOW_UNDER_STATUS_BAR = "showUnderStatusBar";
	public static final String ACTION_SHOW_UNDER_SYSTEM_UI = "showUnderSystemUI";
	public static final String ACTION_IMMERSIVE_MODE = "immersiveMode";

    private CallbackContext context;
	private Activity activity;
	private Window window;
	private View decorView;
	private int mLastSystemUIVisibility = 0;

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

        //this.context = cordova.getActivity().getApplicationContext();
		this.activity = cordova.getActivity();
		this.window = this.activity.getWindow();
		this.decorView = this.window.getDecorView();

        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                new AlertDialog.Builder(activity)
                    .setTitle("Your Alert")
                    .setMessage("Your Message")
                    .setCancelable(false)
                    .setPositiveButton("ok", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Whatever...
                        }
                    }).show();

                /*
                final int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                deorView.setSystemUiVisibility(uiOptions);
                */
            }
        });
    }

    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        return true;
    }

    protected void resetWindow()
	{
		decorView.setOnFocusChangeListener(null); 
		decorView.setOnSystemUiVisibilityChangeListener(null);
		
		window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
	}

}
