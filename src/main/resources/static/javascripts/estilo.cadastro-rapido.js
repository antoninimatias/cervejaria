$(function() {

    var modal = $('#modalCadastroRapidoEstilo');
    var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
    var form = modal.find('form');

    form.on('submit', function(event) {
	event.preventDefault()
    });

    var url = form.attr('action');
    var inputNomeEstilo = $('#nomeEstilo');
    var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');

    modal.on('shown.bs.modal', onModalShow);
    modal.on('hide.bs.modal', onModalClose);
    botaoSalvar.on('click', onBotaoSalvarClick);

    /**
     * Coloca focus no input nome
     */
    function onModalShow() {
	inputNomeEstilo.focus();
    }

    /**
     * Se fechar o modal:
     * - O valor do input é apagado
     * - As mensagens de erro são removidas
     * - Has-error removido
     */
    function onModalClose() {
	inputNomeEstilo.val('');
	containerMensagemErro.addClass('hidden');
	form.find('.form-group').removeClass('has-error');
    }

    /**
     * Ao clicar faz uma submissão ao servidor
     */
    function onBotaoSalvarClick() {
	var nomeEstilo = inputNomeEstilo.val().trim();
	$.ajax({
	    url : url,
	    method : 'POST',
	    contentType : 'application/json',
	    data : JSON.stringify({
		nome : nomeEstilo
	    }),
	    error : onErroSalvandoEstilo,
	    success : onEstiloSalvo
	});
    }

    /**
     * Função erro para mostrar erros
     */
    function onErroSalvandoEstilo(obj) {
	var mensagemErro = obj.responseText;
	containerMensagemErro.removeClass('hidden');
	containerMensagemErro.html('<span>' + mensagemErro + '</span>');
	form.find('.form-group').addClass('has-error');
    }

    function onEstiloSalvo(estilo) {
	var comboEstilo = $('#estilo');
	comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome
		+ '</option>');
	comboEstilo.val(estilo.codigo);
	modal.modal('hide');
    }

});