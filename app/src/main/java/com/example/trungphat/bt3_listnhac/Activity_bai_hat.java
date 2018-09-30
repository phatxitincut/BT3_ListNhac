package com.example.trungphat.bt3_listnhac;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Activity_bai_hat extends AppCompatActivity {

    TextView txt_tencasy, txt_tenbaihatdangphat, txt_tgdangphat, txt_tgketthuc;
    ImageButton btn_rewind, btn_play, btn_next;
    SeekBar seekBar;
    ListView listview_baihat;

    int vt_dangphat;

    ArrayList<list_baihat> list_baihats;

    MediaPlayer player = new MediaPlayer(); //khai báo biến Media để phát nhạc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);

        Intent intent = getIntent();
        int vitri = intent.getIntExtra("position",0);
        String ten_cs = intent.getStringExtra("tencasy");

        txt_tencasy = (TextView) findViewById(R.id.txt_tencasy);
        txt_tenbaihatdangphat =(TextView) findViewById(R.id.txt_dangphat);
        txt_tgdangphat =(TextView) findViewById(R.id.txt_time_play);
        txt_tgketthuc =(TextView) findViewById(R.id.txt_time_out);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        btn_next=(ImageButton) findViewById(R.id.bt_next);
        btn_play=(ImageButton) findViewById(R.id.bt_pause);
        btn_rewind=(ImageButton) findViewById(R.id.bt_rewind);
        listview_baihat=(ListView) findViewById(R.id.list_nhac);

        txt_tencasy.setText(ten_cs);

        list_baihats = new ArrayList<list_baihat>();


        switch (vitri){
            case 0:
                list_baihats.add(new list_baihat("Âm thầm bên em", time(R.raw.sontung_am_tham_ben_em),R.raw.sontung_am_tham_ben_em ));
                list_baihats.add(new list_baihat("Anh sai rồi", time(R.raw.sontung_anh_sai_roi),R.raw.sontung_anh_sai_roi ));
                list_baihats.add(new list_baihat("Chắc ai đó sẽ về", time(R.raw.sontung_chac_ai_do_se_ve),R.raw.sontung_chac_ai_do_se_ve ));
                list_baihats.add(new list_baihat("Em của ngày hôm qua", time(R.raw.sontung_em_cua_ngay_hom_qua),R.raw.sontung_em_cua_ngay_hom_qua ));
                list_baihats.add(new list_baihat("Nơi này có anh", time(R.raw.sontung_noi_nay_co_anh),R.raw.sontung_noi_nay_co_anh ));
                list_baihats.add(new list_baihat("You of Yesterday", time(R.raw.sontung_you_of_yesterday),R.raw.sontung_you_of_yesterday ));
                break;

            case 1:
                list_baihats.add(new list_baihat("Day Dreams", time(R.raw.soobin_day_dreams), R.raw.soobin_day_dreams ));
                list_baihats.add(new list_baihat("Đẹp nhất là em", time(R.raw.soobin_dep_nhat_la_em), R.raw.soobin_dep_nhat_la_em ));
                list_baihats.add(new list_baihat("I Know You Know", time(R.raw.soobin_i_know_you_know), R.raw.soobin_i_know_you_know ));
                list_baihats.add(new list_baihat("Phía sau một cô gái", time(R.raw.soobin_phia_sau_mot_co_gai), R.raw.soobin_phia_sau_mot_co_gai ));
                list_baihats.add(new list_baihat("Vài lần đón đưa", time(R.raw.soobin_vai_lan_don_dua), R.raw.soobin_vai_lan_don_dua ));
                list_baihats.add(new list_baihat("Xin đừng lặng im", time(R.raw.soobin_xin_dung_lang_im), R.raw.soobin_xin_dung_lang_im ));
                break;

            case 2:
                list_baihats.add(new list_baihat("30 ngày yêu", time(R.raw.dongnhi_30_ngay_yeu), R.raw.dongnhi_30_ngay_yeu ));
                list_baihats.add(new list_baihat("Bối rối", time(R.raw.dongnhi_boi_roi), R.raw.dongnhi_boi_roi ));
                list_baihats.add(new list_baihat("Khóc", time(R.raw.dongnhi_khoc), R.raw.dongnhi_khoc ));
                list_baihats.add(new list_baihat("Lời thú tội ngọt ngào", time(R.raw.dongnhi_loi_thu_toi_ngot_ngao), R.raw.dongnhi_loi_thu_toi_ngot_ngao ));
                list_baihats.add(new list_baihat("Ta là của nhau", time(R.raw.dongnhi_ta_la_cua_nhau), R.raw.dongnhi_ta_la_cua_nhau ));
                list_baihats.add(new list_baihat("Từng thuộc về nhau", time(R.raw.dongnhi_tung_thuoc_ve_nhau), R.raw.dongnhi_tung_thuoc_ve_nhau ));
                break;

            case 3:
                list_baihats.add(new list_baihat("Cho ta gần hơn", time(R.raw.chipu_cho_ta_gan_hon), R.raw.chipu_cho_ta_gan_hon ));
                list_baihats.add(new list_baihat("Đóa hoa hồng", time(R.raw.chipu_doa_hoa_hong), R.raw.chipu_doa_hoa_hong ));
                list_baihats.add(new list_baihat("Em sai rồi anh xin lỗi em đi", time(R.raw.chipu_em_sai_roi_anh_xin_loi_em_di), R.raw.chipu_em_sai_roi_anh_xin_loi_em_di ));
                list_baihats.add(new list_baihat("Talk to me", time(R.raw.chipu_talk_to_me), R.raw.chipu_talk_to_me ));
                list_baihats.add(new list_baihat("Tôi vẫn hát", time(R.raw.chipu_toi_van_hat), R.raw.chipu_toi_van_hat ));
                list_baihats.add(new list_baihat("Từ hôm nay", time(R.raw.chipu_tu_hom_nay), R.raw.chipu_tu_hom_nay ));
                break;

            case 4:
                list_baihats.add(new list_baihat("Complicated", time(R.raw.avril_lavigne_complicated), R.raw.avril_lavigne_complicated ));
                list_baihats.add(new list_baihat("Girlfriend", time(R.raw.avril_lavigne_girlfriend), R.raw.avril_lavigne_girlfriend ));
                list_baihats.add(new list_baihat("I'm with you", time(R.raw.avril_lavigne_im_with_you), R.raw.avril_lavigne_im_with_you ));
                list_baihats.add(new list_baihat("Smile", time(R.raw.avril_lavigne_smile), R.raw.avril_lavigne_smile ));
                list_baihats.add(new list_baihat("What the hell", time(R.raw.avril_lavigne_what_the_hell), R.raw.avril_lavigne_what_the_hell ));
                list_baihats.add(new list_baihat("Wish you were here", time(R.raw.avril_lavigne_wish_you_were_here), R.raw.avril_lavigne_wish_you_were_here ));
                break;
        }

        Adapter_listbaihat adapter_listbaihat = new Adapter_listbaihat(Activity_bai_hat.this, R.layout.list_baihat, list_baihats);
        listview_baihat.setAdapter(adapter_listbaihat);

        //Chương trình nhấn vào bài nào bài đó phát
        listview_baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (player.isPlaying()) {
                    player.stop();
                }
                    vt_dangphat = position;
                    khoitao();

                thoigian_hientai ();

                btn_play.setBackgroundResource(R.drawable.pause_1);
            }
        });

        //Các chương trình nút nhấn
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying()){
                    player.pause();
                    btn_play.setBackgroundResource(R.drawable.play_1);
                }
                else{
                    player.start();
                    btn_play.setBackgroundResource(R.drawable.pause_1);
                }
            }
        });

        btn_rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vt_dangphat --;
                if(vt_dangphat < 0){
                    vt_dangphat = list_baihats.size() - 1;
                }
                player.stop();
                btn_play.setBackgroundResource(R.drawable.pause_1);
                khoitao();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vt_dangphat ++;
                if(vt_dangphat > list_baihats.size()-1)
                {
                    vt_dangphat = 0;
                }
                player.stop();
                btn_play.setBackgroundResource(R.drawable.pause_1);
                khoitao();
            }
        });

        //Chương trình điều khiển seekbar để chỉnh bài hát
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //Kéo tới đâu thực hiện tới đó
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            //Thực hiện khi chạm vào
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            //Thực hiện khi đã kéo và thả ra
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(seekBar.getProgress());
            }
        });

    }

    //Chương trình hiển thị thời gian đang phát hiện tại của bài hát
    void thoigian_hientai (){
        final Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                txt_tgdangphat.setText(simpleDateFormat.format((player.getCurrentPosition())));
                seekBar.setProgress(player.getCurrentPosition());
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        vt_dangphat++;
                        if(vt_dangphat > list_baihats.size()-1){
                            vt_dangphat = 0;
                            player.stop();
                            btn_play.setBackgroundResource(R.drawable.play_1);
                        }
                        else{
                            player.stop();
                            khoitao();
                        }
                    }
                });
                handler.postDelayed(this, 500);

            }
        }, 100);
    }

    //Hàm để hiển thị bài đang phát và thời gian chạy bài đó
    private void khoitao() {

        player = MediaPlayer.create(Activity_bai_hat.this, list_baihats.get(vt_dangphat).diachi_baihat);
        txt_tenbaihatdangphat.setText("Đang phát: " + list_baihats.get(vt_dangphat).tenbaihat);
        txt_tgketthuc.setText(time(list_baihats.get(vt_dangphat).diachi_baihat));
        seekBar.setMax(player.getDuration());
        player.start();
    }

    //Hàm để biết thời lượng của bài hát
    private String time(int diachi_baihat)      //Trả về kiểu dữ liệu String
    {
        String t; //biến chứa thời gian
        MediaPlayer player = new MediaPlayer();
        player = MediaPlayer.create(Activity_bai_hat.this, diachi_baihat);
        SimpleDateFormat tg = new SimpleDateFormat("mm:ss");
        t = tg.format(player.getDuration());
        return t;
    }

    //Hàm để khi bấm sang ca sỹ sẽ tắt bài hát của ca sỹ cũ
    @Override
    protected void onStop() {
        player.stop();
        super.onStop();
    }
}
