package kr.almostthere.android;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by lk on 2017. 3. 5..
 */

public class Util {

    public static void setClipBoardLink(Context context , String link) {

        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("label", link);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(context, context.getString(R.string.toast_text_clipboard), Toast.LENGTH_SHORT).show();

    }
}
