package orbit.project.auth.http

import java.time.LocalDateTime

data class VerifyCodeRequest(
    val email: String,
    val code: String,
    val requestTime: LocalDateTime
)