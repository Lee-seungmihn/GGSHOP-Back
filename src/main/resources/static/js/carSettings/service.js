// 차서비스 모듈
const CarService = (() => {
    // 차 정보 조회
    const getCarInfo = async () => {
        try {
            const response = await fetch("/json/car_data.json");
            if (!response.ok) throw new Error("JSON 로드 실패");
            return await response.json();
        } catch (error) {
            console.error("json 에러:", error);
            return []; // null 대신 빈 배열 리턴 (some 에러 방지)
        }
    };

    // 차량 정보 등록
    const registerCar = async (carData) => {
        try {
            const response = await fetch("/profile/settings/register-car", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(carData)
            });
            return response;
        } catch (error) { return null; }
    };

    // 차량 정보 삭제
    const deleteCar = async () => {
        try {
            const response = await fetch("/profile/settings/delete-car", { method: "POST" });
            return response;
        } catch (error) { return null; }
    };

    return {
        carInfo : getCarInfo,
        registerCar : registerCar,
        deleteCar : deleteCar
    };
})();