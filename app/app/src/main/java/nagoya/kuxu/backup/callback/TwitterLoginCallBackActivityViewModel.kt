package nagoya.kuxu.backup.callback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import nagoya.kuxu.backup.callback.domain.OAuthTokenRepository
import nagoya.kuxu.backup.callback.domain.repository.OAuthTokenRepositoryImpl
import kotlin.coroutines.CoroutineContext

internal class TwitterLoginCallBackActivityViewModel(
    private val oAuthTokenRepository: OAuthTokenRepository = OAuthTokenRepositoryImpl()
    ) : ViewModel(), CoroutineScope {

    val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    private val _isLoginFaildLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val isLoginFaildLiveData: LiveData<Boolean> = _isLoginFaildLiveData

    fun postOAuthToken(token: String?) {
        if (token == null) {
            _isLoginFaildLiveData.postValue(false)
            return
        }

        launch {
            oAuthTokenRepository.storeOauthToken(token)
            _isLoginFaildLiveData.postValue(true)
        }
    }
}