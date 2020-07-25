package agoge.com.br.hv1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorld extends Activity {

	Button button1;
	TextView tv1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        
        button1=(Button)this.findViewById(R.id.button1);
        tv1=(TextView)this.findViewById(R.id.textView1);
        
        button1.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		
        		tv1.setText("Agoge Sistemas - Android Project");

        		}
        		});

    }
    
    
    public void clicou(View view){
    	TextView tv;
    	tv=(TextView)this.findViewById(R.id.textView2);
    	tv.setText("IMEI: " + findDeviceID());
    }
    
    public void manda(View view){
		  try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage("+553191990751", null, "IMEI: " + findDeviceID(), null, null);
			Toast.makeText(getApplicationContext(), "SMS Sent!",
						Toast.LENGTH_LONG).show();
		  } catch (Exception e) {
			Toast.makeText(getApplicationContext(),
				"SMS faild, please try again later!",
				Toast.LENGTH_LONG).show();
			e.printStackTrace();
		  }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hello_world, menu);
        return true;
    }
    
    
    public String findDeviceID() {
    	
    	try{
    		    	
        TelephonyManager m = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return m.getDeviceId();
    	}
    	catch (Exception e)
    	{
    		return e.toString();
    	}

   }
}
