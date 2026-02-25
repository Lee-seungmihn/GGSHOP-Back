const profileService = (() => {

    // 프로필 사진 변경 부분 서비스
    const updateImage = async (formData) => {
        try {
            const response = await fetch("/profile/update", {
                method: "POST",
                body: formData
            });
            return response;
        } catch (error) {
            console.error("에러:", error);
            return null;
        }
    };

    // 닉네임 변경 부분 서비스
    const updateNickname = async (nickname) => {
        try {
            const response = await fetch("/profile/update-nickname", {
                method: "POST",
                body: JSON.stringify({memberNickname: nickname}),
                headers: {
                    "Content-Type": "application/json"
                }
            });
            return response;
        } catch(error) {
            console.error("에러:", error);
            return null;
        }

    }

    // 패스워드 변경 부분 서비스
    const updatePassword = async (newPassword) => {
        try {
            const response = await fetch("/profile/update-password", {
                method: "POST",
                body: JSON.stringify({memberPassword: newPassword}),
                headers: {
                    "Content-Type": "application/json"
                }
            });
            return response;
        } catch(error) {
            console.error("에러:", error);
            return null;
        }
    }

    // 주소 변경 부분 서비스
    const updateAddress = async (newAddress) => {
        try {
            const response = await fetch("/profile/update-address", {
                method: "POST",
                body: JSON.stringify({memberAddress: newAddress}),
                headers: {
                    "Content-Type": "application/json"
                }
            });
            return response;
        } catch(error) {
            console.error("에러:", error);
            return null;
        }

    }
    return {
        updateImage: updateImage,
        updateNickname: updateNickname,
        updatePassword: updatePassword,
        updateAddress: updateAddress
    };
})();


