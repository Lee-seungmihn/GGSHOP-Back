document.addEventListener("DOMContentLoaded", () => {
    /* ==========================================
     * 1. 이메일 유효성 검사 로직
     * ========================================== */
    const emailInput = document.getElementById("username");
    const errorMessage = document.querySelector(".EmailValidationForm-module_error__cbcb7");
    const nextButton = document.querySelector(".Button-module_button__d78c2.Button-module_mint__1c1d6");

    // 이메일 정규식
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    // 요소들이 존재할 때만 이벤트 리스너 추가 (에러 방지)
    if (emailInput && errorMessage && nextButton) {
        emailInput.addEventListener("input", () => {
            const value = emailInput.value.trim();

            if (value === "") {
                errorMessage.style.display = "none";
                nextButton.disabled = true;
                nextButton.classList.add("Button-module_disabled__2ebf2");
                return;
            }

            if (!emailRegex.test(value)) {
                errorMessage.style.display = "block";
                nextButton.disabled = true;
                nextButton.classList.add("Button-module_disabled__2ebf2");
            } else {
                errorMessage.style.display = "none";
                nextButton.disabled = false;
                nextButton.classList.remove("Button-module_disabled__2ebf2");
            }
        });
    }

    /* ==========================================
     * 2. 카카오 로그인 버튼 이벤트
     * ========================================== */
    const kakaoLoginButton = document.getElementById("kakao-login");
    if (kakaoLoginButton) {
        kakaoLoginButton.addEventListener("click", (e) => {
            console.log("카카오 로그인 시도...");
            location.href = "https://kauth.kakao.com/oauth/authorize?client_id=c03e2bc9dd98290165897636f33947f3&redirect_uri=http://localhost:10000/kakao/login&response_type=code";
        });
    }

    /* ==========================================
     * 3. 로그인 실패 및 비밀번호 창 처리
     * ========================================== */
    const failMessage = document.getElementById("login-fail-message");
    if (typeof login !== 'undefined' && login && failMessage) {
        failMessage.classList.add("on");
    }

    const passwordWrapper = document.querySelector('.EmailValidationForm-module_passwordInput__09b02');
    if (passwordWrapper) {
        passwordWrapper.classList.remove('EmailValidationForm-module_hidePassword__4d26c');
    }


});
/* join.js */

document.addEventListener("DOMContentLoaded", () => {
    // '이메일로 시작하기' 버튼 (HTML에서 id="email-login-btn"을 주어야 합니다)
    const emailLoginButton = document.getElementById("email-login-btn");

    if (emailLoginButton) {
        emailLoginButton.addEventListener("click", () => {
            // 컨트롤러의 @GetMapping("/go-email-join")을 호출함
            location.href = "/login/go-email-join";
        });
    }
});