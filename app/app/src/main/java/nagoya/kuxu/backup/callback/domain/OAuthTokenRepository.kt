package nagoya.kuxu.backup.callback.domain

internal interface OAuthTokenRepository {
    suspend fun storeOauthToken(token: String)
}