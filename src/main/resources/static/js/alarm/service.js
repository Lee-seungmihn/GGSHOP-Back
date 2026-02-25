const alarmService = (() => {
    const confirm = async (alarmData) => {
        try {
            const response = await fetch("/api/alarm/confirm", {
                method: "POST",
                body: JSON.stringify(alarmData),
                headers: {
                    "Content-Type": "application/json"
                }
            });
            return response;
        } catch(error) {
            console.error("에러:", error);
        }
    }
    return { confirm };
})();