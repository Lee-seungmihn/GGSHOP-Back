const CarLayout = (() => {
    const updateCarDisplay = (modelName) => {
        const container = document.getElementById("carInfoContainer");
        if (container) {
            const modelNode = document.createTextNode(modelName);
            container.appendChild(modelNode);
        }
    };
    return {
        updateCarDisplay: updateCarDisplay
    };
})();