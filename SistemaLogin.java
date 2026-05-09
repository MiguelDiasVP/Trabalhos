import java.util.Scanner;

public class SistemaLogin {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String loginCadastrado = "";
        String senhaCadastrada = "";

        int opcao = 0;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("3 - Como criar uma senha forte");
            System.out.println("4 - Sair");
            System.out.print("\nEscolha uma opção: ");

            if (scn.hasNextInt()) {
            opcao = scn.nextInt();
            scn.nextLine();

            } else {
                System.out.println("Erro: Digite apenas números");
            scn.nextLine();
            opcao = 0;
            continue;
            }

            switch (opcao) {

                case 1:
                    System.out.println("\n=== CADASTRO ===");

                    System.out.print("Digite o login: ");
                    String login = scn.nextLine().trim();

                    if (!login.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                        System.out.println("Login inválido! Use apenas letras.");
                        break;
                    }
        
                    System.out.println("\n=== SENHA FORTE === ");

                    System.out.println("A senha deve conter no minimo 8 caracteres.");
                    System.out.println("Use números e simbolos.");
                    
                    boolean SenhaValida = false;
                    String senha = "";

                    while (!SenhaValida) {
                    System.out.print("\nDigite a senha: ");
                    senha = scn.nextLine();
                    
                        //Validação 1: Mínimo de 8 caracteres
                    if (senha.length() < 8) {
                        System.out.println(">>Senha inválida! Mínimo 8 caracteres.");
                    continue;
                    }

                        //Validação 2: Números e simbolos
                    if (!senha.matches(".*[0-9].*")) {
                            System.out.println(">>A senha deve conter pelo menos um número.");
                    continue;
                    }
                    if (!senha.matches(".*[\\W].*")) {
                        System.out.println(">>A senha deve conter pelo menos um símbolo.");
                    continue;
                    }

                        //Validação 3: Maiúsculas e minúsculas
                    if (!senha.matches(".*[A-Z].*")) {
                            System.out.println(">>A senha deve conter letra maiúscula.");
                    continue;
                    }
                    if (!senha.matches(".*[a-z].*")) {
                        System.out.println(">>A senha deve conter letra minúscula.");
                        continue;
                    }
                
                    SenhaValida = true;
                }
                    loginCadastrado = login;
                    senhaCadastrada = senha;

                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                

                case 2:
                    if (loginCadastrado.equals("")) {
                        System.out.println("Nenhum usuário cadastrado!");
                        break;
                    }

                    System.out.println("\n=== LOGIN ===");

                    boolean logado = false;

                    for (int i = 1; i <= 3; i++) {

                        System.out.println("\nTentativa " + i + " de 3");

                        System.out.print("Login: ");
                        String loginTentativa = scn.nextLine();

                        System.out.print("Senha: ");
                        String senhaTentativa = scn.nextLine();

                        if (loginTentativa.equalsIgnoreCase(loginCadastrado)
                                && senhaTentativa.equals(senhaCadastrada)) {

                            System.out.println("Bem-vindo ao sistema!");
                            logado = true;
                            break;
                        } else {
                            System.out.println("Dados incorretos!");
                        }
                    }

                    if (!logado) {
                        System.out.println("!!!ACESSO BLOQUEADO!!!");
                    }
                    break;

                case 3:
                    System.out.println("\n=== DICAS PARA UMA SENHA FORTE ===");
                    System.out.println("1. Deve conter no mínimo 8 caracteres.");
                    System.out.println("2. Não coloque datas de aniversário.");
                    System.out.println("3. Coloque números (1, 2, 3...) ou símbolos (@, #, !, ?).");
                    System.out.println("4. Misture letras maiúsculas e minúsculas.");
                    System.out.println("5. Faça associações/referências com algo próprio para melhor lembrança.");
                    break;
                        
                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println(">>> ERRO... Escolha Opção de 1 a 4.");
            }

        } while (opcao != 4);

        scn.close();
    }
}