package git.oop.banco.modelo;

public class ContaInvestimento extends Conta {
  public ContaInvestimento(Person titular, int agencia, int numero) {
    super(titular, agencia, numero);
  }

  public void creditarRendimentos(double percentualJuros) {
    double valorRendimentos = getSaldo() * percentualJuros / 100;
    depositar(valorRendimentos);
  }

}