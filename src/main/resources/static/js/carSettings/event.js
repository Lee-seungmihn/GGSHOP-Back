document.addEventListener("DOMContentLoaded", () => {

    // 정규식
    const carRegex = /^\d{2,3}[가-힣]\d{4}$/;

    // 상태 업데이트 (버튼 활성화/비활성화)
    const updateButtonState = () => {
        // 활성화된 모달에서 찾기, 없으면 document에서
        const activeModal = document.querySelector('.modal.active') || document;

        const carPlateInput = activeModal.querySelector(".CardInfoForm_cardInput");
        const regInput = activeModal.querySelector("input[name='register']");
        const changeInput = activeModal.querySelector("input[name='change']");

        const ownerNameInput = regInput || changeInput;
        // registerButton과 changeButton만 타겟팅
        const submitBtn = activeModal.querySelector(".registerButton, .changeButton");

        if (!carPlateInput || !ownerNameInput || !submitBtn) return;

        const isCarValid = carRegex.test(carPlateInput.value.replace(/\s/g, ""));
        const isOwnerValid = ownerNameInput.value.trim().length > 0;
        const isValid = isCarValid && isOwnerValid;

        // 버튼 비활성화 상태
        submitBtn.disabled = !isValid;
        submitBtn.classList.toggle('Button_disabled', !isValid);
    };

    // BD 전송 핸들러
    const handleCarSubmit = async (btn) => {
        if (btn.disabled || btn.classList.contains('Button_disabled')) return; // 비활성화 상태면 아래 실행 금지

        const modal = btn.closest('.modal') || document;
        const carInput = modal.querySelector(".CardInfoForm_cardInput");
        const regOwner = modal.querySelector("input[name='register']");
        const changeOwner = modal.querySelector("input[name='change']");

        const ownerInput = regOwner || changeOwner; // 둘 중 하나 대입
        if (!carInput || !ownerInput) return; // 차와 유저 입력칸이 없으면 아래 실행 금지

        const inputPlateNumber = carInput.value.trim().replace(/\s/g, ""); // 전체에서 공백 제거
        const inputOwnerName = ownerInput.value.trim();

        // 차량 정보 조회
        const carList = await CarService.carInfo();
        const foundCar = carList.find(car =>
            car.carPlateNumber.replace(/\s/g, "") === inputPlateNumber &&
            car.userName === inputOwnerName
        );

        // json에 있는 차량번호화 소유주 확인
        if (!foundCar) {
            alert("에러: 차량번호와 소유주 json에서 보고 tbl_member.sql에서 select로 찾아서 확인해보세요.");
            return;
        }

        // 변경 버튼이면 기존 차량 제거(소프트 델리트)
        if (btn.classList.contains("changeButton")) {
            await CarService.deleteCar();
        }

        // 차량 등록
        const response = await CarService.registerCar({
            carPlateNumber: foundCar.carPlateNumber,
            carFilter: foundCar.carFilter
        });

        if (response && response.ok) {
            const result = await response.text();
            if (result === "success") {
                alert(`성공성공성공성공성공!!!!!!!!!!!!!!`);
                location.reload(); // 처리하기 귀찮으니 그냥 넣음
            }
        }
    };

    // 입력시 상태 감지
    document.addEventListener("input", (e) => {
        if (e.target.matches(".CardInfoForm_cardInput, input[name='register'], input[name='change']")) {
            updateButtonState();
        }
    });

    // 모달 완료 버튼
    document.addEventListener("click", (e) => {
        const btn = e.target.closest(".registerButton, .changeButton");
        if (btn) {
            e.preventDefault();
            handleCarSubmit(btn);
        }
        setTimeout(updateButtonState, 100); // 클릭 후 정보 업데이트를 위해 지연
    });

    // 차량 정보 화면에 뿌려주는 곳
    const initCarDisplay = async () => {
        if (typeof dbPlateNumber === 'undefined' || !dbPlateNumber) return;
        const carList = await CarService.carInfo();
        const myCar = carList.find(car => car.carPlateNumber === dbPlateNumber);
        if (myCar) CarLayout.updateCarDisplay(myCar.carModel);
    };
    initCarDisplay();

    // setInterval(updateButtonState, 500);
    // 에러나고 짜증나면 활성화해서 볼 것
});

// 삭제
const carDelete = async () => {
    if (!confirm("차량을 삭제하시겠습니까?")) return;
    const response = await CarService.deleteCar();
    if (response && response.ok) {
        location.reload();
    }
};


// document.addEventListener("DOMContentLoaded", async () => {
//     if (typeof dbPlateNumber === 'undefined' || !dbPlateNumber) return;
//     const carList = await CarService.carInfo();
//     if (carList) {
//         const myCar = carList.find(car => car.carPlateNumber === dbPlateNumber);
//         if (myCar) {
//             CarLayout.updateCarDisplay(myCar.carModel);
//         }
//     }
// });

// const carDelete = async () => {
//     if (!confirm("차량을 삭제하시겠습니까?")) return;
//     const response = await CarService.deleteCar();
//     if (response && response.ok) {
//         location.reload();
//     }
// };