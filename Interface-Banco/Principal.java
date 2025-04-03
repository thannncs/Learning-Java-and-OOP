import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ContaBancaria> listaContas = new ArrayList<>();
        String contaNome, contaNum;
        ContaBancaria novaAcc;

        boolean handler = true;
        int opt1;
        while (handler) {
            System.out.print("Bem vindo ao banco Tacacá \nPara utilizar o sistema insira uma das opções na linha de comando\n" +
                    "\n" +
                    "1-Cadastrar nova Conta\n" +
                    "2-Sacar Valor de uma Conta\n" +
                    "3–Atualizar Poupança\n" +
                    "4–Depositar Valor\n" +
                    "5–Mostrar Saldo\n" +
                    "6-Calcular Tributos\n" +
                    "7-Calcular Taxa de Administração\n" +
                    "8-SAIR\n\n");

            opt1 = sc.nextInt();
            switch (opt1) {

                case 1:
                    System.out.println("Qual tipo de conta deseja cadastrar ?" + "\n" + "1-Conta Corrente" + "\n" + "2-Conta Poupança" + "\n" + "3-Conta Investimento");
                    int tipoconta = sc.nextInt();
                    switch (tipoconta) {
                        case 1:
                            System.out.println("Informe o nome do Cliente" + "\n");
                            contaNome = sc.next();
                            System.out.println("Informe o número da conta" + "\n");
                            contaNum = sc.next();
                            System.out.println("Defina o Limite de crédito para a Conta" + "\n");
                            double limite = sc.nextDouble();
                            novaAcc = new ContaCorrente(contaNome, contaNum, BigDecimal.valueOf(limite));

                            boolean contaCorrenteJaCadastrada = false;
                            for (ContaBancaria conta : listaContas) {
                                if (conta.getNumeroConta().equals(contaNum)) {
                                    System.out.println("Esse número de conta já está cadastrado em outra conta");
                                    contaCorrenteJaCadastrada = true;
                                    break; // Encerrar o loop assim que uma correspondência for encontrada
                                }
                            }

                            if (!contaCorrenteJaCadastrada) {
                                listaContas.add(novaAcc);
                                System.out.println("Conta Corrente cadastrada com sucesso!");
                            }
                            break;
                        case 2:
                            System.out.println("Informe o nome do Cliente" + "\n");
                            contaNome = sc.next();
                            System.out.println("Informe o número da conta" + "\n");
                            contaNum = sc.next();
                            System.out.println("Defina o Rendimento Diário para a Conta" + "\n");
                            int diaRendimento = sc.nextInt();
                            novaAcc = new ContaPoupanca(contaNome, contaNum, diaRendimento);

                            boolean contaPoupancaJaCadastrada = false;
                            for (ContaBancaria conta : listaContas) {
                                if (conta.getNumeroConta().equals(contaNum)) {
                                    System.out.println("Esse número de conta já está cadastrado em outra conta");
                                    contaPoupancaJaCadastrada = true;
                                    break; // Encerrar o loop assim que uma correspondência for encontrada
                                }
                            }

                            if (!contaPoupancaJaCadastrada) {
                                listaContas.add(novaAcc);
                                System.out.println("Conta Poupança cadastrada com sucesso!");
                            }
                            break;

                        case 3:
                            System.out.println("Informe o nome do Cliente" + "\n");
                            contaNome = sc.next();
                            System.out.println("Informe o número da conta" + "\n");
                            contaNum = sc.next();
                            novaAcc = new ContaInvestimento(contaNome, contaNum);

                            boolean contaInvestimentoJaCadastrada = false;
                            for (ContaBancaria conta : listaContas) {
                                if (conta.getNumeroConta().equals(contaNum)) {
                                    System.out.println("Esse número de conta já está cadastrado em outra conta");
                                    contaInvestimentoJaCadastrada = true;
                                    break; // Encerrar o loop assim que uma correspondência for encontrada
                                }
                            }

                            if (!contaInvestimentoJaCadastrada) {
                                listaContas.add(novaAcc);
                                System.out.println("Conta Investimento cadastrada com sucesso!");
                            }
                            break;

                        default:
                            System.out.println("OPERAÇÃO INVÁLIDA");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Informe o número da conta que deseja realizar o saque");
                    contaNum = sc.next();
                    for (ContaBancaria conta : listaContas) {
                        if (conta.getNumeroConta().equals(contaNum)) {
                            System.out.println("Digite o valor a ser sacado");
                            BigDecimal saque = sc.nextBigDecimal();
                            conta.sacar(saque);
                        } else {
                            System.out.println("Conta não Cadastrada");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Informe o número da conta que deseja atualizar o Rendimento");
                    contaNum = sc.next();
                    for (ContaBancaria conta : listaContas) {
                        if (conta.getNumeroConta().equals(contaNum)) {
                            if (conta instanceof ContaPoupanca) {
                                System.out.println("Defina a Taxa de Rendimento em decimais.Ex:40% = 1.4");
                                BigDecimal rendimento = sc.nextBigDecimal();
                                if (rendimento.compareTo(BigDecimal.ZERO) == 1) {
                                    ((ContaPoupanca) conta).calculaNovoSaldo(rendimento);
                                } else {
                                    System.out.println("Rendimento Inválido");
                                }
                            } else {
                                System.out.println("A conta não é uma Poupança!");
                            }
                        } else {
                            System.out.println("Conta não Cadastrada");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Informe o número da conta que deseja realizar o depósito");
                    contaNum = sc.next();
                    for (ContaBancaria conta : listaContas) {
                        if (conta.getNumeroConta().equals(contaNum)) {
                            System.out.println("Insira o valor a ser depositado");
                            BigDecimal deposito = sc.nextBigDecimal();
                            conta.depositar(deposito);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Informe o número da conta que deseja verificar o saldo");
                    contaNum = sc.next();
                    for (ContaBancaria conta : listaContas) {
                        if (conta.getNumeroConta().equals(contaNum)) {
                            if(conta instanceof ContaPoupanca){
                            System.out.println("Cliente:" + conta.getClienteConta()+"\nSaldo: "+ conta.getNumeroConta() +  " reais"+"\nTipo de conta: Poupança");
                        } else if (conta instanceof ContaInvestimento) {
                                System.out.println("Cliente:" + conta.getClienteConta()+"\nSaldo: "+ conta.getNumeroConta() +  " reais"+"\nTipo de conta: Investimento");
                            } else if (conta instanceof ContaCorrente) {
                                System.out.println("Cliente:" + conta.getClienteConta()+"\nSaldo: "+ conta.getNumeroConta() +  " reais"+"\nTipo de conta: Corrente");

                            }
                        }
                        }
                    break;

                case 6:
                    System.out.println("Informe o número da conta que deseja calcular os tributos");
                    contaNum = sc.next();
                    for (ContaBancaria conta : listaContas) {
                        if (conta.getNumeroConta().equals(contaNum)) {
                            if (conta instanceof ContaInvestimento) {
                                System.out.println("Defina a Taxa de Rendimento em decimais.Ex:40% = 1.4");
                                BigDecimal venture = sc.nextBigDecimal();
                                System.out.println("Os tributos da conta " + conta.getNumeroConta() + " são de " + ((ContaInvestimento) conta).calcularTributo(venture) + " reais");
                            } else {
                                System.out.println("A conta informada não é de investimento");
                            }
                        } else {
                            System.out.println("A conta informada não está cadastrada");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Informe o número da conta que deseja calcular a taxa de Administração");
                    contaNum = sc.next();
                    for (ContaBancaria conta : listaContas) {
                        if (conta.getNumeroConta().equals(contaNum)) {
                            if (conta instanceof ContaInvestimento) {
                                System.out.println("Defina a Taxa de Rendimento em decimais.Ex:40% = 1.4");
                                BigDecimal admTax = sc.nextBigDecimal();
                                System.out.println("A taxa de administração da conta " + conta.getNumeroConta() + " é de " + ((ContaInvestimento) conta).calcularTaxaAdministracao(admTax) + " reais");
                            } else {
                                System.out.println("A conta informada não é de investimento");
                            }
                        } else {
                            System.out.println("A conta informada não está cadastrada");
                        }
                    }
                    break;

                case 8:
                    handler = false;
                    break;

                default:
                    break;
            }
        }
    }
}
