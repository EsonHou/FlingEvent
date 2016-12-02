package com.example.eson.flingevent;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;

public class OnScroll_Activity extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private ImageView[] tips;
    private ImageView[] wallpaper;
    private String[] imageName = new String[]{"Spring", "Summer", "Fall", "Winter", "Happy", "Care", "TryEverything"};
    private String[] imageDes = new String[]{"在泰国举行的谷歌开发者论坛上，谷歌为我们介绍了一个名叫 Glide 的图片加载库，作者是bumptech", "这个库被广泛的运用在google的开源项目中，包括2014年google I/O大会上发布的官方app。", "它的成功让我非常感兴趣。我花了一整晚的时间把玩，决定分享一些自己的经验。在开始之前我想说，Glide和Picasso有90%的相似度，准确的说，就是Picasso的克隆版本", "Android RecyclerView part 1 blog -->RecyclerView使用详解（一）", "Android RecyclerView part 2 blog -->RecyclerView使用详解（二） Android RecyclerView part 3 blog -->RecyclerView使用详解（三", "概述 setShader(Shader shader)中传入的自然是shader对象了，shader类是Android在图形变换中非常重要的一个类。Shader在三维软件中我们称之为着色器，其作用是来给图像着色。", "在做一个view背景特效的时候被坐标的各个获取方法搞晕了，几篇抄来抄去的博客也没弄很清楚。 现在把整个总结一下。 其实只要把下面这张图看明白就没问题了。"};
    private int[] petureid;
    private int number = 0;
    private WallpaperManager wallpapermanager = null;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_scroll_);


        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.layoutview);
        viewPager = (ViewPager) findViewById(R.id.viewpaper);

        petureid = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.imd5, R.drawable.img6, R.drawable.img7};

        tips = new ImageView[petureid.length];
        for (int i = 0; i < petureid.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.img9);
            } else {
                tips[i].setBackgroundResource(R.drawable.img8);
            }

            /**
             * new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
             * --不写死大小，FILL_PARENT，即填满（和父容器一样大小），WRAP_CONTENT，即包裹住组件就好
             */
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);

            layoutParams.leftMargin = 5;//设定作间距
            layoutParams.rightMargin = 5;//设定右间距
            viewGroup.addView(imageView, layoutParams);
        }

        wallpaper = new ImageView[petureid.length];
        for (int i = 0; i < petureid.length; i++) {
            ImageView imageView = new ImageView(this);
            wallpaper[i] = imageView;
            imageView.setBackgroundResource(petureid[i]);
        }

        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem((wallpaper.length) * 100);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        number = position % wallpaper.length;
        TextView wallId = (TextView) findViewById(R.id.wallpaperid);
        TextView waiiDes = (TextView) findViewById(R.id.wallDes);
        Button button = (Button) findViewById(R.id.setwall);
        wallId.setText(imageName[number]);
        waiiDes.setText(imageDes[number]);
        wallpaper[number].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {//设置长按监听，将图片设为壁纸
                try {
                    OnScroll_Activity.this.clearWallpaper();
                    OnScroll_Activity.this.setWallpaper(OnScroll_Activity.this.getResources().openRawResource(petureid[number]));

                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    OnScroll_Activity.this.startActivity(intent);

                    Toast.makeText(OnScroll_Activity.this, "设置壁纸成功", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(OnScroll_Activity.this, "设置壁纸失败", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    wallpapermanager = WallpaperManager.getInstance(OnScroll_Activity.this);
                    Drawable before = wallpapermanager.getDrawable();//获取当前系统壁纸
                    OnScroll_Activity.this.clearWallpaper();
                    OnScroll_Activity.this.setWallpaper(OnScroll_Activity.this.getResources().openRawResource(petureid[number]));


                    Drawable after = wallpapermanager.getDrawable();
                    if (before.equals(after)) {
                        Toast.makeText(OnScroll_Activity.this, "设置壁纸失败", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intent);
                        Toast.makeText(OnScroll_Activity.this, "设置壁纸成功", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    Toast.makeText(OnScroll_Activity.this, "设置壁纸失败", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        setImageBackground(position % wallpaper.length);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {

            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(wallpaper[position % wallpaper.length]);
            //super.destroyItem(container, position, object);
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(wallpaper[position % wallpaper.length], 0);

            return wallpaper[position % wallpaper.length];
        }
    }

    public void setImageBackground(int selectitem) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectitem) {
                tips[i].setBackgroundResource(R.drawable.img9);
            } else {
                tips[i].setBackgroundResource(R.drawable.img8);
            }
        }
    }
}
