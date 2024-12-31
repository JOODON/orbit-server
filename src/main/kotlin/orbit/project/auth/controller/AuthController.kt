package orbit.project.auth.controller

import orbit.project.auth.http.LoginRequest
import orbit.project.auth.http.VerifyCodeRequest
import orbit.project.auth.service.AuthService
import orbit.project.auth.service.VerificationService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService,
    private val verificationService: VerificationService,
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Mono<Any> {
        return authService.authLogin(loginRequest)
    }

    @PostMapping("/sendCode")
    fun sendVerificationCode(@RequestParam email: String): Mono<Any> {
        return verificationService.sendVerificationEmailCode(email)
    }

    @PostMapping("/verifyCode")
    fun verifyCode(@RequestBody request: VerifyCodeRequest): Mono<Any> {
        return verificationService.verifyCode(request.email, request.code , request.requestTime)
    }

}