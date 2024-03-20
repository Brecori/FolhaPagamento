package br.com.fiap.folhapagamento.model.dominio;

public final class IRFF extends Imposto{
    private double deducao;
    public IRFF(){

    }

    public IRFF(float faixaInicial, float faixaFinal, float aliquota, float deducao) {
        super.setAliquota(aliquota);
        super.setFaixaInicial(faixaInicial);
        super.setFaixaFinal(faixaFinal);
        this.deducao = deducao;
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
	   Até R$1.903,99 – 0 - 0
	   De R$1.903,99 até R$2.826,65 – 7,5% - R$142,80
	   De R$2.826,65 até R$3.751,05 – 15%  - R$354,80
	   De R$3.751,05 até R$4.664,69 – 22,5% - R$636,13
	   Acima de R$4.664,69 - 27,5% - R$869,36
	 */

    @Override
    void popularTabela() {
        super.tabela.add(new INSS(0, 1301.99f, 0.07f));
        super.tabela.add(new INSS(1302, 2571.29f, 0.09f));
        super.tabela.add(new INSS(2571.30f, 3856.94f, 0.12f));
        super.tabela.add(new INSS(3856.95f, 7507.49f, 0.14f));
    }
}
