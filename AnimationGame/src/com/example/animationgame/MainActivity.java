package com.example.animationgame;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ImageView mImageView1;
	private Animation mAnim1;
	private ImageView mImageView2;
	private Animation mAnim2;
	Button player1, player2 ;
	TextView tv;
	boolean clicked = false ;
	long startTime;
	long endTime;
	
	boolean cont = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mImageView1 = (ImageView) findViewById(R.id.icon1);
		mImageView2 = (ImageView) findViewById(R.id.icon2);

		mAnim1 = AnimationUtils.loadAnimation(this, R.anim.anim_1);
		mAnim2 = AnimationUtils.loadAnimation(this, R.anim.anim_2);

		player1 = (Button) findViewById(R.id.button1);
		player2 = (Button) findViewById(R.id.button2);
		tv = (TextView) findViewById(R.id.textView1);
		
		
		startTime = System.currentTimeMillis();
		
		
		player1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!clicked){
					whenClicked();
					endTime = System.currentTimeMillis();
					if(endTime - startTime >= 3000){
						player1.setBackgroundColor(0xFF00FF00);
						player1.setText("YOU WON");
					}
					else{
						player1.setBackgroundColor(0xffff0000);
						player1.setText("YOU LOST");
					}
					clicked = true;
				}
			}
		});
		
		player2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!clicked){
					whenClicked();
					endTime = System.currentTimeMillis();
					if(endTime - startTime >= 3000){
						player2.setBackgroundColor(0xFF00FF00);
						player2.setText("YOU WON");
					}
					else{
						player2.setBackgroundColor(0xffff0000);
						player2.setText("YOU LOST");
					}
					clicked = true;
				}
			}
		});
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			mImageView1.startAnimation(mAnim1);
			mImageView2.startAnimation(mAnim2);
		}
	}
	public void whenClicked(){
		mImageView1.clearAnimation();
		mImageView2.clearAnimation();
		tv.setVisibility(View.INVISIBLE);
		
	}

}