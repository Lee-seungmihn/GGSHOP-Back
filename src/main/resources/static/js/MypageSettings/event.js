// 프로필 사진 부분 이벤트
document.addEventListener("DOMContentLoaded", () => {
    const fileInput = document.getElementById("profileInput");
    const profileImage = document.getElementById("profileImage");
    const fileForm = document.getElementById("profileForm");

    if (!fileInput || !profileImage || !fileForm) return;

    fileInput.addEventListener("change", async (e) => {
        const file = e.target.files[0];
        if (!file) return;

        if (!file.type.match(/^image\/(png|jpeg|jpg)$/)) {
            alert("이미지 파일(png, jpeg, jpg)만 가능합니다");
            fileInput.value = "";
            return;
        }

        const reader = new FileReader();
        reader.onload = (ev) => { profileImage.src = ev.target.result; };
        reader.readAsDataURL(file);

        const formData = new FormData(fileForm);
        if (loggedInMemberId) {
            formData.set("memberId", loggedInMemberId);
        }

        try {
            const response = await profileService.updateImage(formData);
            if (response && response.ok) {
                // console.log("성공!");
                fileInput.value = "";
                // location.reload();
            } else {
                // alert("실패!");
            }
        } catch (error) {
            // console.error("에러:", error);
            // alert("오류");
        }
    });
});

// 닉네임 변경 모달 부분 이벤트
document.addEventListener("DOMContentLoaded", () => {
    const nicknameTextFiled = document.querySelector(".nickname .menuItem_description")
    const nicknameInput = document.getElementById("nickname");
    const nicknameBtn = document.querySelector(".NicknameSetting_nickNameForm .ButtonNickName");
    const nicknameRegex = /^[가-힣a-zA-Z0-9]{1,20}$/;
    nicknameInput.addEventListener("input", (e) => {
        const RegexChk = nicknameRegex.test(e.target.value);
        // 속성 변환
        nicknameBtn.disabled = !RegexChk;
        // 클래스 변환
        RegexChk ? nicknameBtn.classList.remove('Button_disabled') : nicknameBtn.classList.add('Button_disabled');
    })
    nicknameBtn.addEventListener("click", async (e) => {
        e.preventDefault();
        const newNickname = nicknameInput.value.trim();
        const response = await profileService.updateNickname(newNickname);
        if (response && response.ok) {
            const result = await response.text();
            if (result === "success") {
                alert(newNickname);

                nicknameTextFiled.textContent = newNickname;
                onlyClose('nicknameChange');
                // location.reload(); 리로드 할 필요 없이 바로 넣기
            }
        } else {
            // console.log("확인:", response);
            // alert("서버 오류");
        }
    });

});

// 주소 변경 모달 부분 이벤트
document.addEventListener("DOMContentLoaded", () => {
    const addressInput = document.getElementById("addressInput");
    const addressUpdateBtn = document.getElementById("addressUpdateBtn");
    const addressTextFiled = document.querySelector(".address .menuItem_description");

    if (addressUpdateBtn) {
        addressUpdateBtn.addEventListener("click", async () => {
            const newAddress = addressInput.value.trim();
            if (!newAddress) {
                alert("주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다주소가비었다");
                return;
            }
            const response = await profileService.updateAddress(newAddress);

            if (response && response.ok) {
                const result = await response.text();
                if (result === "success") {
                    alert("ㅇㅇㅇㅇㅇㅇㅇ 업데이트완.");
                    if (addressTextFiled) {
                        addressTextFiled.textContent = newAddress;
                    }
                    onlyClose('addressChange');
                }
            } else {
                alert("오류오류오류오류오류오류오류오류오류오류오류오류오류오류오류오류오류오류");
            }
        });
    }
});

// 비밀번호 변경 모달 부분 이벤트
document.addEventListener("DOMContentLoaded", () => {
    const currentPwInput = document.getElementById('currentPassword');
    const newPwInput = document.getElementById('newPassword');
    const confirmPwInput = document.getElementById('newPasswordConfirm');
    const pwBtn = document.querySelector('.button-submit');

    const msg1 = document.getElementById('pwMsg1');
    const msg2 = document.getElementById('pwMsg2');
    const msg3 = document.getElementById('pwMsg3');

    const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*+=-]).{8,}$/;

    const chkAll = () => {
        const currentVal = currentPwInput.value.trim();
        const newVal = newPwInput.value.trim();
        const inputChk = currentVal !== newVal;

        const isCurrentCorrect = currentPwInput.value.trim() === dbPassword;
        const isNewPwValid = pwRegex.test(newPwInput.value);
        const isConfirmValid = newPwInput.value === confirmPwInput.value && confirmPwInput.value !== "";
        const isCurrentFilled = currentPwInput.value.length > 0;

        const chk = isNewPwValid && isConfirmValid && isCurrentFilled && inputChk;
        pwBtn.disabled = !chk;
        chk ? pwBtn.classList.remove('button-disabled') : pwBtn.classList.add('button-disabled');

        (isCurrentFilled && !isCurrentCorrect) ? msg1.classList.remove('none') : msg1.classList.add('none');

        const basicMsg = "영문, 숫자, 특수문자 !@#$%^&*+=-를 조합한 8자 이상으로 입력해주세요.";
        msg2.textContent = (newVal.length > 0 && !inputChk) ? "기존 비밀번호와 다른 비밀번호를 입력해주세요." : basicMsg;

        const currentChk = newVal.length > 0 && (!inputChk || !isNewPwValid);
        msg2.classList.toggle('f-red', currentChk);
    };

    currentPwInput.addEventListener('input', () => {
        msg1.classList.add('none');
        chkAll();
    });

    newPwInput.addEventListener('input', () => {
        const value = newPwInput.value;
        (value.length > 0 && !pwRegex.test(value)) ? msg2.classList.add('f-red') : msg2.classList.remove('f-red');
        if (confirmPwInput.value.length > 0) {
            (value !== confirmPwInput.value) ? msg3.classList.remove('none') : msg3.classList.add('none');
        }
        chkAll();
    });

    confirmPwInput.addEventListener('input', () => {
        (newPwInput.value !== confirmPwInput.value) ? msg3.classList.remove('none') : msg3.classList.add('none');
        chkAll();
    });

    pwBtn.addEventListener("click", async (e) => {
        e.preventDefault();
        const newPwValue = newPwInput.value.trim();
        const response = await profileService.updatePassword(newPwValue);
        if (response && response.ok) {
            const result = await response.text();
            if (result === "success") {
                alert("비밀번호가 변경되었습니다.");
                dbPassword = newPwValue;
                onlyClose('passwordChange');
                [currentPwInput, newPwInput, confirmPwInput].forEach(input => input.value = ""); // 바꾸고 나서 입력칸 비우기
                chkAll();
            }
        }
    });
});