
document.addEventListener("DOMContentLoaded", () => {
    const checkboxes = document.querySelectorAll("input[type=checkbox]");

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener("change", async (e) => {
            const isChecked = e.target.checked ? "READ" : "UNREAD";
            const targetId = e.target.id;
            let idRegex = /Alarm/g;

            const alarmData = {
                [targetId.replace('Alarm', 'Status')]: isChecked
            };

            const response = await alarmService.confirm(alarmData);
            const result = await response.text();

            if(result === "success") {
                console.log("설정 저장 완료");
            } else {
                alert("로그인이 필요하거나 설정 저장에 실패했습니다.");
                e.target.checked = !e.target.checked;
            }
        });
    });
});