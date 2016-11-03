package view;

import javax.swing.JOptionPane;

public class Menu {

    int menuPrincipal() {

        int op = Integer.parseInt(JOptionPane.showInputDialog("--Bem-vindo ao sistema--"
                + "\n Escolha a opção desejada"
                + "\n1.Inserir"
                + "\n2.Listar"
                + "\n3.Atualizar"
                + "\n4.Remover"));

        return op;

    }

    int menuInserir() {
        int op2 = Integer.parseInt(JOptionPane.showInputDialog("--CADASTRO--"
                + "\n Escolha a opção desejada"
                + "\n1.Pessoa"
                + "\n2.Veiculo"
                + "\n3.Reserva"
                + "\n4.Acessorio"
                + "\n5.Voltar"));

        return op2;

    }

   
       
   
    
}
