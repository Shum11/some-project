package space.lotonin.milur_gsm_config;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

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
    SharedPreferences sPref;
    Toolbar toolbar;
    final String SAVED_TEXT = "saved_text";
    final String SAVED_TEXT0 = "saved_text0";
    final String SAVED_TEXT1 = "saved_text1";
    final String SAVED_TEXT2 = "saved_text2";
    final String SAVED_TEXT3 = "saved_text3";
    final String SAVED_TEXT4 = "saved_text4";
    final String SAVED_TEXT5 = "saved_text5";
    final String SAVED_TEXT6 = "saved_text6";
    final String SAVED_TEXT7 = "saved_text7";
    final String SAVED_TEXT8 = "saved_text8";
    final String SAVED_TEXT9 = "saved_text9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        init();
        loadText();

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
                    Toast.makeText(MainActivity.this, "Введите Пароль", Toast.LENGTH_SHORT).show();
                }
                else if(ip.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Введите IP адресс", Toast.LENGTH_SHORT).show();
                }
                else if(phone_number.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Введите номер телефона", Toast.LENGTH_SHORT).show();
                }

                else {
                    p = ";";
                    message = "#*,";
                    String a = pass.getText().toString().trim();
                    if (!a.isEmpty()) message = (message + a);
                    String b = ip.getText().toString().trim();
                    if (!b.isEmpty()) message = (message + p + b);
                    String c = port.getText().toString().trim();
                    if (!c.isEmpty()) message = (message + p + c);
                    String d = name_gprs.getText().toString().trim();
                    if (!d.isEmpty()) message = (message + p + d);
                    String e = pass_gprs.getText().toString().trim();
                    if (!e.isEmpty()) message = (message + p + e);
                    String f = apn_gprs.getText().toString().trim();
                    if (!f.isEmpty()) message = (message + p + f);
                    String i = mode.getText().toString().trim();
                    if (!i.isEmpty()) message = (message + p + i);
                    String u = mode_gsm.getText().toString().trim();
                    if (!u.isEmpty()) message = (message + p + u);
                    String m = res_ip.getText().toString().trim();
                    if (!m.isEmpty()) message = (message + p + m);
                    String n = res_port.getText().toString().trim();
                    if (!n.isEmpty()) message = (message + p + n);
                    message = message + "&";
                    String phone =phone_number.getText().toString().trim();
                    if(checkPermission(Manifest.permission.SEND_SMS)) {
                        smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phone, null, message, null, null);
                        Toast.makeText(MainActivity.this, "Сообщение Отправлено", Toast.LENGTH_SHORT).show();
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
    private void init () {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    }

    private void saveText () {
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
        String phone =phone_number.getText().toString().trim();


        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT,a);
        ed.putString(SAVED_TEXT0,b);
        ed.putString(SAVED_TEXT1,c);
        ed.putString(SAVED_TEXT2,d);
        ed.putString(SAVED_TEXT3,e);
        ed.putString(SAVED_TEXT4,f);
        ed.putString(SAVED_TEXT5,i);
        ed.putString(SAVED_TEXT6,u);
        ed.putString(SAVED_TEXT7,m);
        ed.putString(SAVED_TEXT8,n);
        ed.putString(SAVED_TEXT9,phone);
        ed.commit();

    }
    private void loadText () {
        sPref = getPreferences(MODE_PRIVATE);
        String a= sPref.getString(SAVED_TEXT, "");
        String b = sPref.getString(SAVED_TEXT0, "");
        String c = sPref.getString(SAVED_TEXT1, "");
        String d = sPref.getString(SAVED_TEXT2, "");
        String e = sPref.getString(SAVED_TEXT3, "");
        String f = sPref.getString(SAVED_TEXT4, "");
        String i = sPref.getString(SAVED_TEXT5, "");
        String u = sPref.getString(SAVED_TEXT6, "");
        String m = sPref.getString(SAVED_TEXT7, "");
        String n = sPref.getString(SAVED_TEXT8, "");
        String phone = sPref.getString(SAVED_TEXT9, "");

        pass.setText(a);
        ip.setText(b);
        port.setText(c);
        name_gprs.setText(d);
        pass_gprs.setText(e);
        apn_gprs.setText(f);
        mode_gsm.setText(i);
        mode.setText(u);
        res_ip.setText(m);
        res_port.setText(n);
        phone_number.setText(phone);

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.clear){
            pass.setText("");
            ip.setText("");
            port.setText("");
            name_gprs.setText("");
            pass_gprs.setText("");
            apn_gprs.setText("");
            mode_gsm.setText("");
            mode.setText("");
            res_ip.setText("");
            res_port.setText("");
            phone_number.setText("");
        }
        return super.onOptionsItemSelected(item);
    }
}