package com.example.duanbaucua;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;




public class Manhinh2 extends AppCompatActivity {


    GridView gridView;
    Custom_Gridview_BanCo adapter;
    Integer[] dsHinh = {R.drawable.bau, R.drawable.cua, R.drawable.tom, R.drawable.ca, R.drawable.ga, R.drawable.nai};
    AnimationDrawable cdXingau1;
    AnimationDrawable cdXingau2;
    AnimationDrawable cdXingau3;
    ImageView hinhxingau1, hinhxingau2, hinhxingau3;
    Random randomXiNgau;
    int giatriXingau1, giatriXingau2, giatriXingau3;

    public static Integer[] gtDatCuoc = new Integer[6];
    int tongtiencu, tongtienmoi;
    TextView tvTien;
    Timer timer = new Timer();
    Handler handler;
    int tienthuong, kiemtra;
    SharedPreferences luuTru;
    Handler.Callback callback = new Handler.Callback()
    {
        @Override
        public boolean handleMessage(Message msg)
        {

            RandomXiNgau1();
            RandomXiNgau2();
            RandomXiNgau3();
            for (int i=0; i < gtDatCuoc.length; i++)
            {
                if (gtDatCuoc[i] !=0)
                {
                    if (i == giatriXingau1 )
                    {
                        tienthuong += gtDatCuoc[i];

                    }
                    if (i == giatriXingau2)
                    {
                        tienthuong +=gtDatCuoc[i];
                    }
                    if (i == giatriXingau3)
                    {
                        tienthuong +=gtDatCuoc[i];
                    }
                    if (i != giatriXingau1 && i != giatriXingau2 && i != giatriXingau3){
                        tienthuong -= gtDatCuoc[i];
                    }

                }
            }
            if(tienthuong >0){
                Toast.makeText(getApplicationContext(),"Bạn đã thắng được " + tienthuong,Toast.LENGTH_SHORT).show();

            }else  if(tienthuong ==0){
                Toast.makeText(getApplicationContext(),"Hên nha mém mất tiền ngu! " ,Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(), "Ôi đen quá mất   " + tienthuong + "rồi T-T", Toast.LENGTH_SHORT).show();
            }

            LuuDuLieuNguoiDung(tienthuong);
            tvTien.setText(String.valueOf(tongtienmoi));
            return false;
        }
    };




    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh2);
        Button btnCancel =  (Button)findViewById(R.id.button2);
        hinhxingau1 = (ImageView) findViewById(R.id.xingau1);
        hinhxingau2 = (ImageView) findViewById(R.id.xingau2);
        hinhxingau3 = (ImageView) findViewById(R.id.xingau3);
        tvTien = (TextView) findViewById(R.id.tvTien);


        btnCancel.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                             cancel(v);
                                         }
                                     }
        );



        gridView = (GridView) findViewById(R.id.gvBanco);
        adapter = new Custom_Gridview_BanCo(this, R.layout.custom_banco, dsHinh);
        gridView.setAdapter(adapter);

        luuTru = getSharedPreferences("lutruthongtin", Context.MODE_PRIVATE);
        tongtiencu = luuTru.getInt("Tongtien", 1000);
        tvTien.setText(String.valueOf(tongtiencu));

        handler = new Handler(callback);


    }
    private void LuuDuLieuNguoiDung(int tienthuong){
        SharedPreferences.Editor edit = luuTru.edit();
        tongtienmoi = tongtiencu + tienthuong;
        edit.putInt("TongTien",tongtienmoi);
        edit.commit();

    }
    public void Lacxingau (View v)
    {
        hinhxingau1.setImageResource(R.drawable.hinhdong);
        hinhxingau2.setImageResource(R.drawable.hinhdong);
        hinhxingau3.setImageResource(R.drawable.hinhdong);
        tvTien = (TextView) findViewById(R.id.tvTien);

        cdXingau1 = (AnimationDrawable) hinhxingau1.getDrawable();
        cdXingau2 = (AnimationDrawable) hinhxingau2.getDrawable();
        cdXingau3 = (AnimationDrawable) hinhxingau3.getDrawable();

        for (int i = 0; i < gtDatCuoc.length; i++){
            kiemtra += gtDatCuoc[i];

        }
        if (kiemtra ==0){
            Toast.makeText(getApplicationContext(),"Bạn vui lòng đặt cược !", Toast.LENGTH_SHORT).show();
        }
        else {
            if (kiemtra > tongtiencu) {
                Toast.makeText(getApplicationContext(),"Bạn không đủ tiền đặt cược !", Toast.LENGTH_SHORT).show();
            }else {
                cdXingau1.start();
                cdXingau2.start();
                cdXingau3.start();


                tienthuong = 0;
                timer.schedule(new Lacxingau(), 1000);

            }
        }





    }
    class  Lacxingau extends TimerTask{

        @Override
        public void run(){
            handler.sendEmptyMessage(0);






        }
    }


    private void  RandomXiNgau1() {
        randomXiNgau = new Random();
        int rd = randomXiNgau.nextInt(6);
        switch (rd) {
            case 0:
                hinhxingau1.setImageResource(dsHinh[0]);
                giatriXingau1 = rd;
                break;
            case 1:
                hinhxingau1.setImageResource(dsHinh[1]);
                giatriXingau1 = rd;
                break;
            case 2:
                hinhxingau1.setImageResource(dsHinh[2]);
                giatriXingau1 = rd;
                break;
            case 3:
                hinhxingau1.setImageResource(dsHinh[3]);
                giatriXingau1 = rd;
                break;
            case 4:
                hinhxingau1.setImageResource(dsHinh[4]);
                giatriXingau1 = rd;
                break;
            case 5:
                hinhxingau1.setImageResource(dsHinh[5]);
                giatriXingau1 = rd;
                break;


        }
    }
    private void  RandomXiNgau2(){
        randomXiNgau = new Random();
        int rd = randomXiNgau.nextInt(6) ;
        switch (rd ){
            case 0:
                hinhxingau2.setImageResource(dsHinh[0]);
                giatriXingau2 = rd;
                break;
            case 1:
                hinhxingau2.setImageResource(dsHinh[1]);
                giatriXingau2 = rd;
                break;
            case 2:
                hinhxingau2.setImageResource(dsHinh[2]);
                giatriXingau2 = rd;
                break;
            case 3:
                hinhxingau2.setImageResource(dsHinh[3]);
                giatriXingau2 = rd;
                break;
            case 4:
                hinhxingau2.setImageResource(dsHinh[4]);
                giatriXingau2 = rd;
                break;
            case 5:
                hinhxingau2.setImageResource(dsHinh[5]);
                giatriXingau2 = rd;
                break;



        }


    }
    private void  RandomXiNgau3(){
        randomXiNgau = new Random();
        int rd = randomXiNgau.nextInt(6) ;
        switch (rd ){
            case 0:
                hinhxingau3.setImageResource(dsHinh[0]);
                giatriXingau3 = rd;
                break;
            case 1:
                hinhxingau3.setImageResource(dsHinh[1]);
                giatriXingau3 = rd;
                break;
            case 2:
                hinhxingau3.setImageResource(dsHinh[2]);
                giatriXingau3 = rd;
                break;
            case 3:
                hinhxingau3.setImageResource(dsHinh[3]);
                giatriXingau3 = rd;
                break;
            case 4:
                hinhxingau3.setImageResource(dsHinh[4]);
                giatriXingau3 = rd;
                break;
            case 5:
                hinhxingau3.setImageResource(dsHinh[5]);
                giatriXingau3 = rd;
                break;



        }
    }
    public void cancel(View v){
        System.exit(0);
    }
}
