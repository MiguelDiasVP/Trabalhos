package Exercios;
//LógicaMatemática: (P && Q) || R => \LIBERA\ - login (P), Senha(Q) e Senha de recuperação extra(R).
import java.util.Scanner;

public class SistemaLogin {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        String login;
        String senha;
        boolean logado = false;
        int maxTentativas = 3;

        System.out.println("=== SISTEMA DE ACESSO RESTRITO ===");
        for (int tentativas = 1; tentativas <= maxTentativas; tentativas++) {
        
        System.out.println("\nTentativa " + tentativas + " de " + maxTentativas);

        System.out.print("\nDigite seu login: ");
        login = scn.nextLine().trim();
        //Limitar apenas para letras
            if (!login.matches("[\\p{L} \\-]+")) {
            System.out.println(">>Erro: Somente letras são permitidas no login!");
                tentativas--;
                continue;
            }
            //Limitar apenas para números
        System.out.print("\nDigite a senha: ");
        senha = scn.nextLine();
            if (!senha.matches("\\d+")) {
            System.out.println(">>Erro: Somente números são permitidos na senha!");
            tentativas--;
                continue;
            }

        if (login.equals("Miguel DiasVP") && senha.equals("23032007")) {
            System.out.println("Login realizado com sucesso! Bem-vindo."); 
            logado = true;
            break;
            } 
        else {        
            System.out.println("Acesso negado! login ou senha incorreto(s).");
            }
        } if (!logado){
            System.err.println("\n[BLOQUEADO]! Você excedeu o limite de 3 tentativas.");
    scn.close();
        }
    }
}