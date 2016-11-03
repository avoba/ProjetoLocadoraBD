package view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Controller.AcessorioController;
import model.Controller.CidadeController;
import model.Controller.CondPagamentoController;
import model.Controller.EmpresaController;
import model.Controller.MarcaController;
import model.Controller.MultaController;
import model.Controller.NotaFiscalController;
import model.Controller.PessoaController;
import model.Controller.ReservaController;
import model.Controller.TipoVeiculoController;
import model.Controller.VeiculoAcessorioController;
import model.Controller.VeiculoController;
import model.classes.Acessorio;
import model.classes.Cidade;
import model.classes.CondPagamento;
import model.classes.Empresa;
import model.classes.Marca;
import model.classes.Multa;
import model.classes.NotaFiscal;
import model.classes.Pessoa;
import model.classes.Reserva;
import model.classes.TipoVeiculo;
import model.classes.Veiculo;
import model.classes.VeiculoAcessorio;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        Menu M = new Menu();
        
        Acessorio ac = new Acessorio();
        Cidade ci = new Cidade();
        CondPagamento cp = new CondPagamento();
        Empresa em = new Empresa();
        Marca ma = new Marca();
        Multa mu = new Multa();
        NotaFiscal nf = new NotaFiscal();
        Pessoa pe = new Pessoa();
        Reserva re = new Reserva();
        TipoVeiculo tv = new TipoVeiculo();
        Veiculo ve = new Veiculo();
        VeiculoAcessorio va = new VeiculoAcessorio();

        AcessorioController controllerAC = new AcessorioController();
        CidadeController controllerCI = new CidadeController();
        CondPagamentoController controllerCP = new CondPagamentoController();
        EmpresaController controllerEM = new EmpresaController();
        MarcaController controllerMA = new MarcaController();
        MultaController controllerMU = new MultaController();
        NotaFiscalController controllerNF = new NotaFiscalController();
        PessoaController controllerPE = new PessoaController();
        ReservaController controllerRE = new ReservaController();
        TipoVeiculoController controllerTV = new TipoVeiculoController();
        VeiculoController controllerVE = new VeiculoController();
        VeiculoAcessorioController controllerVA = new VeiculoAcessorioController();

        //--------------CREATE
        
        ac.setNomeAcessorio("zinabre");
        controllerAC.create(ac);
        
        ci.setNomeCidade("orleans");
        controllerCI.create(ci);
        
        
        
        
        
        //--------------READ

        
        for (Acessorio acessorio : controllerAC.read()) {
            System.out.println("ID: " + acessorio.getIdAcessorio() + "| NOME ACESSÓRIO: " + acessorio.getNomeAcessorio());
        }
           for (Marca marca : controllerMA.read()) {
            System.out.println("ID MARCA: " + marca.getIdMarca());
        }
           
           for (Multa multa : controllerMU.read()) {
            System.out.println("ID MULTA: " + multa.getIdMulta());
        }
           
           for (NotaFiscal notaFiscal : controllerNF.read()) {
            System.out.println("ID NF: " + nf.getIdNotaFiscal());
        }
           
           for (Pessoa pessoa : controllerPE.read()) {
            System.out.println("ID PESSOA: " + pessoa.getIdPessoa());
        }
           
           for (Reserva reserva : controllerRE.read()) {
            System.out.println("ID Reserva : " + reserva.getIdReserva());
        }
           
           for (TipoVeiculo tipoVeiculo : controllerTV.read()) {
            System.out.println("ID Tipo Veiculo: " + tipoVeiculo.getIdTipoVeiculo());
        }
           for (Veiculo veiculo : controllerVE.read()) {
            System.out.println("ID Veiculo: " + veiculo.getIdVeiculo());
        }

           for (VeiculoAcessorio veiculoAcessorio : controllerVA.read()) {
            System.out.println("ID VeiculoAcessorio: " + veiculoAcessorio.getIdAcessorios());
        }
           
           int op = 0;
           
           while(op!=5){
              op = M.menuPrincipal();
            switch(op){
                case 1:
                    //CREATE
                case 2:
                case 3:
                case 4:
                    
                
                
                
            }
           }
           
        //--------------UPDATE
//        /* Update Acessorios */
//        a.setIdAcessorio(2);
//        a.setNomeAcessorio("Roda de Liga Leve");
//        controller.update(a);
//

        //--------------DELETE


//        /* Deletar  Acessorios */
//        a.setIdAcessorio(4);
//        controller.delete(a);




//------------MENU PRINCIPAL

        

        

    }

}
