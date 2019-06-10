package nagoya.kuxu.backup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW, "https://twitter-backup-singin.herokuapp.com/auth/twitter".toUri())
            )
        }
    }
}
