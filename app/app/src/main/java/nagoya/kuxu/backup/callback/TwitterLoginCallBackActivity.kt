package nagoya.kuxu.backup.callback

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import nagoya.kuxu.backup.R

internal class TwitterLoginCallBackActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter_login_callback)
    }


    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        val viewModel = ViewModelProviders.of(this).get(TwitterLoginCallBackActivityViewModel::class.java)

        val oauthToken = intent.dataString?.toUri()?.getQueryParameter("oauth_token")
        viewModel.postOAuthToken(oauthToken)

        viewModel.isLoginFaildLiveData.observeForever {
            if (it) {
                Toast.makeText(applicationContext, "Login Success: ${oauthToken}", Toast.LENGTH_LONG).show()
            }
        }

        return super.onCreateView(name, context, attrs)
    }
}