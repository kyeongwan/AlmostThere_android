package kr.almostthere.android;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ShareDialog extends Dialog {
 
    public ShareDialog(Context context) {
        super(context);
    }

    private Button mBtKakao;
    private Button mBtFacebook;
    private Button mBtUrl;
    private Button mBtDone;

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_sharelayout);

        init();
        setEventListner();
    }

    private void setEventListner() {
        mBtKakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void init() {
        mBtKakao = (Button) findViewById(R.id.bt_dialog_kakao);
        mBtFacebook = (Button) findViewById(R.id.bt_dialog_facebook);
        mBtUrl = (Button) findViewById(R.id.bt_dialog_url);
        mBtDone = (Button) findViewById(R.id.bt_dialog_done);
    }

}
