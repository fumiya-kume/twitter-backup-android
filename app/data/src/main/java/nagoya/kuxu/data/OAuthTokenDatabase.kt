package nagoya.kuxu.data

import nagoya.kuxu.data.entity.OAuthToken

interface OauthTokenDatabase {
    suspend fun save(oAuthToken: OAuthToken)
}