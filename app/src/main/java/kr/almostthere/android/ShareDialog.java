package kr.almostthere.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.kakao.kakaolink.AppActionBuilder;
import com.kakao.kakaolink.AppActionInfoBuilder;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;

public class ShareDialog extends Dialog {

    private Activity context;
    private String roomId;
    public ShareDialog(Activity context, String roomId) {
        super(context);
        this.context = context;
        this.roomId = roomId;
    }

    KakaoLink kakaoLink;
    KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;

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
                try {
                    kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder, getContext());
                } catch (KakaoParameterException e) {
                    e.printStackTrace();
                }
            }
        });

        mBtFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "http://www.almostthere.kr/"+roomId);
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        mBtUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.setClipBoardLink(context, "http://www.almostthere.kr/" + roomId);
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

        try {
            kakaoLink = KakaoLink.getKakaoLink(getContext());
            kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
            String text = "약속을 공유합니다.";
            kakaoTalkLinkMessageBuilder.addText(text);
            kakaoTalkLinkMessageBuilder.addAppButton("앱으로 이동",
                    new AppActionBuilder()
                            .addActionInfo(AppActionInfoBuilder
                                    .createAndroidActionInfoBuilder()
                                    .setExecuteParam("join="+roomId)
                                    .setMarketParam("referrer=kr.almostthere.android")
                                    .build())
                            .addActionInfo(AppActionInfoBuilder
                                    .createiOSActionInfoBuilder()
                                    .setExecuteParam("join="+roomId)
                                    .build())
//                            .setUrl("http://almostthere.kr") // PC 카카오톡 에서 사용하게 될 웹사이트 주소
                            .build());
        } catch (KakaoParameterException e) {
            e.printStackTrace();
        }
    }

}
