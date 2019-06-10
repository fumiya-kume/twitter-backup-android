package nagoya.kuxu.backup.callback.domain.repository

import nagoya.kuxu.backup.callback.domain.OAuthTokenRepository

internal class OAuthTokenRepositoryImpl : OAuthTokenRepository {
    override suspend fun storeOauthToken(token: String) {

    }
}