//  체크박스 클릭시 버튼 상태 변경
document.addEventListener("DOMContentLoaded", () => {
    const leaveChkInput = document.getElementById('dropConfirm');
    const leaveChkBtn = document.getElementById('btnDropOut');
    const byeBtn = document.getElementById('byeUserBtn');

    leaveChkInput.addEventListener('change', e => {
        leaveChkBtn.disabled = leaveChkInput.checked ? false : true;
    })
    byeBtn.addEventListener('click', e => {
        profileService.leaveMember(() => {
            alert("회원탈퇴ㅇㅇㅇㅇ");
            location.href = "/login/join_update_6";
        });
    })
});

