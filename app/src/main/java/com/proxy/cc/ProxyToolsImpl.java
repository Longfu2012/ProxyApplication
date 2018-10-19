package com.proxy.cc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/17.
 */

public class ProxyToolsImpl implements ITools {

    ITools realTools;

    public ProxyToolsImpl(ITools rTools){
        realTools = rTools;
    }

    @Override
    public void showDialog(final Context context) {
        new AlertDialog
                .Builder(context)
                .setTitle("ProxyToolsImpl title.")
                .setMessage("ProxyToolsImpl msg.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"ProxyToolsImpl click.",Toast.LENGTH_SHORT).show();
                        if(null != realTools){
                            realTools.showDialog(context);
                        }
                    }
                })
                .create().show();
    }
}
