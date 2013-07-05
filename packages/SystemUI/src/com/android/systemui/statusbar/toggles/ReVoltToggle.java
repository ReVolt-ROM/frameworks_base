
package com.android.systemui.statusbar.toggles;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.android.systemui.R;

public class ReVoltToggle extends BaseToggle {

    @Override
    public void init(Context c, int style) {
        super.init(c, style);
        setIcon(R.drawable.ic_qs_revolt);
        setLabel(R.string.quick_settings_revolt_label);
    }

    @Override
    public void onClick(View v) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(ComponentName
                    .unflattenFromString("com.revolt.control/.ReVoltControlActivity"));
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(Intent.FLAG_FLOATING_WINDOW);
            collapseStatusBar();
            dismissKeyguard();
            startActivity(intent);
        } catch(NullPointerException e) {
            // No intent found for activity component
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(ComponentName
                .unflattenFromString("com.revolt.control/.ReVoltControlActivity"));
        intent.addCategory("android.intent.category.LAUNCHER");

        dismissKeyguard();
        collapseStatusBar();
        startActivity(intent);
        return super.onLongClick(v);
    }

}
