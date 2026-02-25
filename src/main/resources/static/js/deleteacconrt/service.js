const profileService = (() => {
    const leaveMember = async (callback) => {
        try {
            const response = await fetch('/api/profile/settings/leave', {
                method: 'DELETE'
            });

            if (response.ok) {
                // 성공 시 콜백 실행
                if (callback) callback();
            } else {
                console.error("탈퇴 못함");
                alert("오류확인좀");
            }
        } catch (error) {
            console.error("서버 오류:", error);
        }
    };
    return { leaveMember: leaveMember };
})();