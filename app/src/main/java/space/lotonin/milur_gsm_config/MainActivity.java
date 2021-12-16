package space.lotonin.milur_gsm_config;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int SEND_SMS_PERMISSION_REQUEST_CODE = 111;
    private EditText pass;
    private EditText ip;
    private EditText port;
    private EditText name_gprs;
    private EditText pass_gprs;
    private EditText apn_gprs;
    private EditText mode_gsm;
    private EditText mode;
    private EditText res_ip;
    private EditText res_port;
    private EditText phone_number;
    private Button send;
    private String message;
    private String p;
    private SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        pass = findViewById(R.id.pass);
        ip = findViewById(R.id.ip);
        port = findViewById(R.id.port);
        name_gprs = findViewById(R.id.name_gprs);
        pass_gprs = findViewById(R.id.pass_gprs);
        apn_gprs = findViewById(R.id.apn_gprs);
        mode_gsm = findViewById(R.id.mode_gsm);
        mode = findViewById(R.id.mode);
        res_ip = findViewById(R.id.res_ip);
        res_port = findViewById(R.id.res_port);
        phone_number = findViewById(R.id.phone_number);
        send = findViewById(R.id.send);

        send.setEnabled(false);
        if (checkPermission(Manifest.permission.SEND_SMS)){
            send.setEnabled(true);
        }
        else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS},
                    SEND_SMS_PERMISSION_REQUEST_CODE);
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.pass, Toast.LENGTH_SHORT).show();
                }
                else if(ip.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.ip, Toast.LENGTH_SHORT).show();
                }

                else {
                    p = ";";
                    String a = pass.getText().toString().trim();
                    String b = ip.getText().toString().trim();
                    String c = port.getText().toString().trim();
                    String d = name_gprs.getText().toString().trim();
                    String e = pass_gprs.getText().toString().trim();
                    String f = apn_gprs.getText().toString().trim();
                    String i = mode.getText().toString().trim();
                    String u = mode_gsm.getText().toString().trim();
                    String m = res_ip.getText().toString().trim();
                    String n = res_port.getText().toString().trim();
                    message = ("#*,"+a+p+b+p+c+p+d+p+e+p+f+p+u+p+i+p+m+p+n+"&");
                    String phone =phone_number.getText().toString().trim();
                    if(checkPermission(Manifest.permission.SEND_SMS)) {
                        smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phone, null, message, null, null);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Разрешите отправку смс", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean checkPermission(String permission) {
        int checkPermission = ContextCompat.checkSelfPermission(this, permission);
        return (checkPermission == PackageManager.PERMISSION_GRANTED);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case SEND_SMS_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    send.setEnabled(true);
                }
                return;
            }
        }
    }
}