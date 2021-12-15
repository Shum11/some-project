package space.lotonin.milur_gsm_config;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private EditText ip;
    private EditText port;
    private EditText name_gprs;
    private EditText pass_gprs;
    private EditText apn_gprs;
    private EditText mode;
    private EditText res_ip;
    private EditText res_port;
    private EditText phone_number;
    private Button send;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass = findViewById(R.id.pass);
        ip = findViewById(R.id.ip);
        port = findViewById(R.id.port);
        name_gprs = findViewById(R.id.name_gprs);
        pass_gprs = findViewById(R.id.pass_gprs);
        apn_gprs = findViewById(R.id.apn_gprs);
        mode = findViewById(R.id.mode);
        res_ip = findViewById(R.id.res_ip);
        res_port = findViewById(R.id.res_port);
        phone_number = findViewById(R.id.phone_number);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.pass, Toast.LENGTH_SHORT).show();
                }
                else if(ip.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.ip, Toast.LENGTH_SHORT).show();
                }
                else if(port.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.port, Toast.LENGTH_SHORT).show();
                }
                else if(name_gprs.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.name_gprs, Toast.LENGTH_SHORT).show();
                }
                else if(pass_gprs.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.pass_gprs, Toast.LENGTH_SHORT).show();
                }
                else if(apn_gprs.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.apn_gprs, Toast.LENGTH_SHORT).show();
                }
                else if(mode.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.mode, Toast.LENGTH_SHORT).show();
                }
                else if(res_ip.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.res_ip, Toast.LENGTH_SHORT).show();
                }
                else if(res_port.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.res_port, Toast.LENGTH_SHORT).show();
                }
                else if(phone_number.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.phone, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}