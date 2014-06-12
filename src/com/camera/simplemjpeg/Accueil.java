package com.camera.simplemjpeg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Accueil extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
                
        final EditText passField = (EditText)findViewById(R.id.pass);
       
        final String mdp = "";
       
        final Button publicButton = (Button) findViewById(R.id.cameraview);              
        final ImageButton loginButton = (ImageButton) findViewById(R.id.validate);
        loginButton.setOnClickListener(new OnClickListener() {
        
        	@Override
        	public void onClick(View v) {
        		
				String toastMessage = passField.getText().toString();
				Intent intent = new Intent(Accueil.this, MjpegActivity.class);
												
				if (toastMessage.equals(mdp)) {        			
        			startActivity(intent);					
				}
				else {
					Toast.makeText(getApplicationContext(), "Tu t'es gouré, déso !", Toast.LENGTH_SHORT).show();
				}
        		
        	}
        });
        
        publicButton.setOnClickListener(new OnClickListener() {
            
        	@Override
        	public void onClick(View v) {	
        		
				Intent intent = new Intent(Accueil.this, PublicActivity.class);				     			
        		startActivity(intent);					
        	}
        });
    } 
}