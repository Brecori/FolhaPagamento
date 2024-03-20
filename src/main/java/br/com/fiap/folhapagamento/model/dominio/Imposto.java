
package br.com.fiap.folhapagamento.model.dominio;
import java.util.List;

public abstract class Imposto {
	
	private float faixaInicial;
	private float faixaFinal;
	private float aliquota;
	
	protected List<Imposto> tabela;
	
	public Imposto()
	{
		this.popularTabela();
	}
	
	public float getFaixaFinal() {
		return faixaFinal;
	}

	public void setFaixaFinal(float faixaFinal) {
		this.faixaFinal = faixaFinal;
	}

	public float getAliquota() {
		return aliquota;
	}

	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}

	public float getFaixaInicial() {
		return faixaInicial;
	}

	public void setFaixaInicial(float faixaInicial) {
		this.faixaInicial = faixaInicial;
	}
	
	abstract Imposto obterFaixa(float valor);
	
	abstract float calcularDesconto(float valor, Imposto faixaDesconto);
	
	
	abstract void popularTabela();
	
	protected boolean valorPertenceAFaixa(float valor)
	{
		return valor >= faixaInicial && valor <= faixaFinal;
	}

		
}
