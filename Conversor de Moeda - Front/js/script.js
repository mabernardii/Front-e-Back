function converter() {
    const valor = document.getElementById('valor').value;
    const origem = document.getElementById('moedaOrigem').value;
    const destino = document.getElementById('moedaDestino').value;
    const resultado = document.getElementById('resultado');

    if (valor === "" || isNaN(valor)) {
        resultado.textContent = "⚠️ Por favor, insira um valor numérico.";
        resultado.style.background = "#ffebee";
        resultado.style.color = "#c62828";
        return;
    }

    fetch(`http://localhost:8080/converter?valor=${valor}&origem=${origem}&destino=${destino}`)
        .then(response => response.text())
        .then(data => {
            resultado.textContent = data;
            resultado.style.background = "#e0f7fa";
            resultado.style.color = "#006064";
        })
        .catch(error => {
            resultado.textContent = "❌ Erro ao conectar com o servidor.";
            resultado.style.background = "#ffebee";
            resultado.style.color = "#c62828";
            console.error(error);
        });
}