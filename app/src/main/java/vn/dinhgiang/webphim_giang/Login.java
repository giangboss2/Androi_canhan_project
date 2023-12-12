package vn.dinhgiang.webphim_giang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Khởi tạo Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Lấy tham chiếu từ XML
        emailEditText = findViewById(R.id.editTextTextPersonName);
        passwordEditText = findViewById(R.id.editTextTextPersonName2);
        ConstraintLayout signInButton = findViewById(R.id.constraintLayout2);
        TextView registerLink = findViewById(R.id.textView5);

        // Xử lý sự kiện đăng nhập
        signInButton.setOnClickListener(view -> performLogin());

        // Xử lý chuyển hướng đến màn hình đăng ký
        registerLink.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });
    }

    private void performLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Đăng nhập thành công, chuyển hướng đến màn hình chính
                            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                            // Tại đây, bạn có thể chuyển hướng đến MainActivity hoặc một Activity khác
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);

                            // Kết thúc Activity hiện tại để người dùng không trở lại màn hình đăng nhập
                            // bằng nút back
                            finish();
                        } else {
                            // Đăng nhập thất bại, hiển thị thông báo
                            Toast.makeText(Login.this, "Đăng nhập thất bại: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        } else {
            // Hiển thị thông báo lỗi nếu email hoặc mật khẩu trống
            Toast.makeText(Login.this, "Email và mật khẩu không được để trống", Toast.LENGTH_LONG).show();
        }
    }
}
