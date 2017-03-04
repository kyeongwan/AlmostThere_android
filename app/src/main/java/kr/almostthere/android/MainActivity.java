package kr.almostthere.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kakao.kakaolink.AppActionBuilder;
import com.kakao.kakaolink.AppActionInfoBuilder;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;


public class MainActivity extends AppCompatActivity {

    KakaoLink kakaoLink;
    KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;
    MainActivity activity = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            kakaoLink = KakaoLink.getKakaoLink(getApplicationContext());
            kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
            String text = "거의 다왔니 앱에 초대합니다.";
            kakaoTalkLinkMessageBuilder.addText(text);
            kakaoTalkLinkMessageBuilder.addAppButton("앱으로 이동",
                    new AppActionBuilder()
                            .addActionInfo(AppActionInfoBuilder
                                    .createAndroidActionInfoBuilder()
                                    .setExecuteParam("join=1111")
                                    .setMarketParam("referrer=kr.almostthere.android")
                                    .build())
                            .addActionInfo(AppActionInfoBuilder
                                    .createiOSActionInfoBuilder()
                                    .setExecuteParam("join=1111")
                                    .build())
//                            .setUrl("http://almostthere.kr") // PC 카카오톡 에서 사용하게 될 웹사이트 주소
                            .build());
        } catch (KakaoParameterException e) {
            e.printStackTrace();
        }

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                try {
//                    Intent i = new Intent();
//                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder, activity);
//                } catch (KakaoParameterException e) {
//                    e.printStackTrace();
//                }

                startActivity(new Intent(activity, MapsActivity.class));
            }
        });
    }
}
