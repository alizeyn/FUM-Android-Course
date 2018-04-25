package ir.alizeyn.s10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {


    EditText etFirstName, etLastName;
    RadioButton rbMan, rbWoman, rbOther;
    RegisterHelper registerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerHelper = RegisterHelper.getInstance(this);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        rbMan = findViewById(R.id.rbMan);
        rbWoman = findViewById(R.id.rbWoman);
        rbOther = findViewById(R.id.rbOther);
    }

    public void register(View view) {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String gender = (rbMan.isChecked() ? "man" : rbWoman.isChecked() ? "woman" : "other");
        registerHelper.addUser(firstName, lastName, gender);
        registerHelper.setRegister(true);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
