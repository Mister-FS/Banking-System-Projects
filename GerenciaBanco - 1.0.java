/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author FAGNER S
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        // Objeto da classe Scanner
        Scanner scanner = new Scanner(System.in);
        ContaCliente cliente = new ContaCliente();
        ConsultaDados consultadados = new ConsultaDados();
        OperacoesBancarias operacoesbancarias = new OperacoesBancarias();

        int escolha = 0;
        int escolha2 = 0;
        
        

        // Loop Do...While para manter o menu em execução
        do {
            try {
                System.out.println("===Auto-Atendimento===");
                System.out.println("Insira seus dados antes de prosseguir!");
                System.out.print("Insira seu nome: ");
                cliente.setNome(scanner.nextLine());
                System.out.print("Insira seu sobrenome: ");
                cliente.setSobrenome(scanner.nextLine());
                System.out.print("Insira seu CPF: ");
               cliente.setCpf(scanner.nextLong());
               System.out.print("Confirmar 1. Sim | 2. Nao:");
               escolha = scanner.nextInt();
               scanner.nextLine(); // Consome a quebra de linha
            
            } catch (Exception e) {
                System.out.println("Por favor insira dados validos!\n");
                scanner.nextLine();
            }
            
        
            
        } while (escolha != 1);
            
            
       // Loop para manter a execução do menu de operações bancárias
        
        do {
             System.out.println("\nBem-vindo(a) a tela de Operacoes , " + cliente.getNome() + "!");
             System.out.println("\n1. Consultar Saldo");     
             System.out.println("2. Realizar Deposito");
             System.out.println("3. Realizar Saque");
             
             System.out.println("4. Cancelar");
             
             escolha2 = scanner.nextInt();
            
             // Switch para verificar qual opção foi escolhida pelo usuário
             switch (escolha2) {
                 case 1:
                     System.out.println("Voce escolheu a opcao: 1");
                     operacoesbancarias.consultaSaldo(cliente);
                     System.out.println("Operacao finalizada!");
                     
                     break;
                 
                 case 2:
                     System.out.println("Voce escolheu a opcao: 2");
                     operacoesbancarias.deposito(cliente, scanner);
                     System.out.println("Operacao finalizada!");
                     break;
                     
                 case 3:
                     System.out.println("Voce escolheu a opcao 3");
                     operacoesbancarias.saque(cliente, scanner);
                     System.out.println("Operacao finalizada!");
                     break;
                     
             }
            
            
            
        } while (escolha2 != 4);
       
    }
}

// Classe ContaCliente contendo os dados pessoais do Cliente e valor de saldo
class ContaCliente {
    private String nome;
    private String sobrenome;
    private long cpf;
    private float saldo = 500.00f; // valor do saldo

    // Métodos Get e Set para possibilitar a consulta e a modificação dos valores das atributos
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // Permite controle sobre a variável sobrenome
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
   // Permite controle sobre a variável cpf
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    // Permite controle sobre a variavel saldo
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}

// Classe vazia apenas para manter a referência no main
class ConsultaDados {
}

// Classe de operações bancárias
class OperacoesBancarias {
    public static void exibirtela(ContaCliente cliente ) {
    }
    // Método que possibilita a consulta do atributo saldo da classe ContaCliente
    public static void consultaSaldo(ContaCliente cliente) {
        System.out.println("Saldo Atual:  " + cliente.getSaldo());
    }
    
   // Método para depósito 
    public static void deposito(ContaCliente cliente, Scanner scanner) {
        // Espaço reservado
        System.out.print("Digite o valor do deposito: ");
        // Espaço reservado
        // Lê o valor digitado pelo usuário
        float valorDeposito = scanner.nextFloat();
        
        if (valorDeposito > 0) {
            // Soma do saldo com o depósito do cliente
            float novoSaldo = cliente.getSaldo() + valorDeposito;
            cliente.setSaldo(novoSaldo);
            
            System.out.println("Deposito de " + valorDeposito + " adicionado a conta");
            System.out.println("Saldo atual: " + cliente.getSaldo());
        } else {
            System.out.println("Valor invalido, Insira um valor acima de zero");
        }
    }
    
    // Método para Saque
    public static void saque(ContaCliente cliente, Scanner scanner) {
        System.out.print("Insira o valor de saque: ");
        float valorDeposito = scanner.nextFloat();
        if (valorDeposito > 0) {
            float novoValor = cliente.getSaldo() - valorDeposito;
            cliente.setSaldo(valorDeposito);
            System.out.println("Saldo atual: " + novoValor);
            
            
        } else {
            System.out.println("Valor de saque invalido");
        }
    }
    
}
