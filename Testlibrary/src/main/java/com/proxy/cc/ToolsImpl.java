package com.proxy.cc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/17.
 */

public class ToolsImpl implements ITools {

    @Override
    public void showDialog(final Context context) {
        new AlertDialog
                .Builder(context)
                .setTitle("ToolsImpl title.")
                .setMessage("ToolsImpl msg.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"ToolsImpl click.",Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

}
