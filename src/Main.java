import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPF = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPJ = new ArrayList<>();
        PessoaJuridica metodosPJ = new PessoaJuridica();
        PessoaFisica metodosPF = new PessoaFisica();
        JOptionPane.showMessageDialog(null, "Bem Vindo ao sistema de cadastro de pessoas fisicas e pessoas juridicas!");
        int op;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("Digite qual opção desejada:  \n 1-Pessoa Fisica \n 2-Pessoa Juridica \n 0-Fechar o Sistema"));

            switch(op){
                case 1:
                    JOptionPane.showMessageDialog(null, "Voce escolheu a opcao 1 - Pessoa Fisica\n");
                    int opPF;
                    do{
                        opPF=Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opcao:\n1-Cadastrar Pessoa Fisica\n2-Listar Pessoa Fisica\n0-Voltar"));
                        switch(opPF){
                            case 1:
                                PessoaFisica novaPF = new PessoaFisica();
                                Endereco novoEndPF = new Endereco();
                                novaPF.nome=JOptionPane.showInputDialog("Digite o nome da Pessoa Fisica");
                                novaPF.cpf=JOptionPane.showInputDialog("Digite o CPF");
                                novaPF.rendimento=Integer.parseInt(JOptionPane.showInputDialog("Digite o rendimento mensal (Digite somente Numeros)"));
                                LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Nascimento no formato dd/MM/aaaa"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo =  Period.between(date, LocalDate.now());
                                novaPF.dataNascimento = date;
                                if(periodo.getYears() >= 18){
                                    JOptionPane.showMessageDialog(null, "A Pessoa tem mais de 18 anos");
                                }else{
                                    JOptionPane.showMessageDialog(null, "A Pessoa tem menos de 18 anos.\nRetornando ao menu...");
                                    break;
                                }
                                novoEndPF.logradouro=JOptionPane.showInputDialog("Digite o Logradouro");
                                novoEndPF.numero=JOptionPane.showInputDialog("Digite o Numero");
                                String endCom;
                                endCom= String.valueOf(JOptionPane.showConfirmDialog(null, "O endereco e Comercial?", "Selecione uma Opcao", JOptionPane.YES_NO_OPTION));
                                if (endCom.equalsIgnoreCase("0")){
                                    novoEndPF.enderecoComercial = true;
                                }else {
                                    novoEndPF.enderecoComercial = false;
                                }
                                novaPF.endereco = novoEndPF;
                                listaPF.add(novaPF);
                                JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!!");
                                break;
                            case 2:
                                if(listaPF.size() > 0){
                                    for (PessoaFisica cadaPF : listaPF){
                                        JOptionPane.showMessageDialog(null,
                                                "Nome: "+cadaPF.nome +
                                                "\nCPF: "+ cadaPF.cpf+
                                                "\nEndereco: "+cadaPF.endereco.logradouro+", "+ cadaPF.endereco.numero +
                                                "\nData de Nascimento: "+ cadaPF.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                                                "\nImposto a ser Pago: R$" + metodosPF.calcularImposto(cadaPF.rendimento));

                                    }
                                    opPF = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 para continuar"));
                                }else{
                                    JOptionPane.showMessageDialog(null, "Nao ha pessoas fisicas cadastradas!");
                                }
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "Voltando ao menu anterior");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Valor nao encontrado, por favor coloque um valor valido ");
                                break;
                        }
                    }while(opPF != 0);

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Voce escolheu a opcao 2 - Pessoa Juridica\n");
                    int opPJ;
                    do{
                        opPJ=Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opcao:\n1-Cadastrar Pessoa Juridica\n2-Listar Pessoa Juridica\n0-Voltar"));
                        switch (opPJ){
                            case 1:
                                PessoaJuridica novaPJ = new PessoaJuridica();
                                Endereco novoEndPJ = new Endereco();
                                novaPJ.nome=JOptionPane.showInputDialog("Digite o nome da Pessoa Juridica");
                                novaPJ.cnpj=JOptionPane.showInputDialog("Digite o CNPJ");
                                novaPJ.rendimento=Integer.parseInt(JOptionPane.showInputDialog("Digite o rendimento mensal (Digite somente Numeros)"));
                                novaPJ.razaoSocial=JOptionPane.showInputDialog("Digite a Razao Social");
                                novoEndPJ.logradouro=JOptionPane.showInputDialog("Digite o Logradouro");
                                novoEndPJ.numero=JOptionPane.showInputDialog("Digite o Numero");
                                String endCom;
                                endCom= String.valueOf(JOptionPane.showConfirmDialog(null, "O endereco e Comercial?", "Selecione uma Opcao", JOptionPane.YES_NO_OPTION));
                                if (endCom.equalsIgnoreCase("0")){
                                    novoEndPJ.enderecoComercial = true;
                                }else {
                                    novoEndPJ.enderecoComercial = false;
                                }
                                novaPJ.endereco = novoEndPJ;
                                listaPJ.add(novaPJ);
                                JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!!");
                                break;
                            case 2:
                                if(listaPJ.size() > 0){
                                    for (PessoaJuridica cadaPJ : listaPJ){
                                        JOptionPane.showMessageDialog(null,
                                                "Nome: "+cadaPJ.nome +
                                                        "\nCNPJ: "+ cadaPJ.cnpj+
                                                        "\nEndereco: "+cadaPJ.endereco.logradouro+", "+ cadaPJ.endereco.numero +
                                                        "\nRazao Social: "+ cadaPJ.razaoSocial+
                                                        "\nImposto a ser Pago: R$" + metodosPJ.calcularImposto(cadaPJ.rendimento));

                                    }
                                    opPJ = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 para continuar"));
                                }else{
                                    JOptionPane.showMessageDialog(null, "Nao ha Pessoas Juridicas cadastradas!");
                                }
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "Voltando ao menu anterior");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Valor nao encontrado, por favor coloque um valor valido ");
                                break;

                        }
                    }while(opPJ != 0);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado por usar nosso Sistema!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Valor nao encontrado, por favor coloque um valor valido ");
                    break;
            }

        }while (op != 0);


    }
}