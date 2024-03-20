package br.com.fiap.folhapagamento.model.dominio;

public final class INSS extends Imposto {
	
	public INSS()
	{
		
	}
	
	public INSS(float faixaInicial, float faixaFinal, float aliquota)
	{
		super.setFaixaInicial(faixaInicial);
		super.setFaixaFinal(faixaFinal);
		super.setAliquota(aliquota);	
	}

	@Override
	Imposto obterFaixa(float valor) {
		
		for(Imposto item : super.tabela)
		{
			if(item.getFaixaInicial() >= valor && valor <= item.getFaixaFinal())
				return item;
			
			if(item.valorPertenceAFaixa(valor))
				return item;
			
		}
		
		return null;
	}

	@Override
	float calcularDesconto(float valor, Imposto faixaDesconto) {
			return valor * faixaDesconto.getAliquota();
	}

	
	/*
	   Até R$1.302,00 – 7,5%
	   De R$1.302,00 até R$2.571,29 – 9%
	   De R$2.571,30 até R$3.856,94 – 12%
	   De R$3.856,95 até R$7.507,49 – 14%
	 */
	
	@Override
	void popularTabela() {
		super.tabela.add(new INSS(0, 1301.99f, 0.07f));
		super.tabela.add(new INSS(1302, 2571.29f, 0.09f));
		super.tabela.add(new INSS(2571.30f, 3856.94f, 0.12f));
		super.tabela.add(new INSS(3856.95f, 7507.49f, 0.14f));
	}

}
