function pesquisacep(valor){
    var cep = valor.replace(/\D/g,'');

    if(cep != ""){

        var validacep = /^[0-9]{8}$/;

        if(validacep.test(cep)){
            document.getElementById('rua').value = "...";
            document.getElementById('bairro').value = "...";
            document.getElementById('cidade').value = "...";
            document.getElementById('uf').value = "...";  
            document.getElementById('regiao').value = "..."; 
            document.getElementById('ibge').value = "..."; 
            document.getElementById('gia').value = "..."; 
            document.getElementById('ddd').value = "..."; 
            document.getElementById('siafi').value = "..."; 

            fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then(response => {
                if(!response.ok){
                    throw new Error ('Erro na requisição');
                }
                return response.json();
            })
            .then(conteudo =>{
                if(!conteudo.erro){
                    document.getElementById('rua').value = conteudo.logradouro;
                    document.getElementById('bairro').value = conteudo.bairro;
                    document.getElementById('cidade').value = conteudo.localidade;
                    document.getElementById('uf').value = conteudo.uf;
                    document.getElementById('regiao').value = conteudo.regiao;
                    document.getElementById('ibge').value = conteudo.ibge;
                    document.getElementById('gia').value = conteudo.gia;
                    document.getElementById('ddd').value = conteudo.ddd;
                    document.getElementById('siafi').value = conteudo.siafi;
                }
            })
        }
    }
}