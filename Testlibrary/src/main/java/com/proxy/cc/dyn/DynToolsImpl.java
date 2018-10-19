package com.proxy.cc.dyn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/18.
 */

public class DynToolsImpl implements IDynTools {

    @Override
    public void showDialog(final Context context) {
        new AlertDialog
                .Builder(context)
                .setTitle("DynToolsImpl title.")
                .setMessage("DynToolsImpl msg.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"DynToolsImpl click.",Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

}
