package br.com.juan.factory;

import br.com.juan.model.CorFluxo;
import java.awt.Color;
import javax.swing.JOptionPane;

public class FluxoSelena extends SelenaFactory {

    public void fluxoPrincipal() {
        
        // SELECIONA O PRODUTO
        delay(2000);
        moverEClicar(1653, 292);
        delay(2000);
        moverEClicar(512, 278);
        delay(200);
        moverEClicar(1312, 271);
        delay(200);
        pegarDadosPlanilha();
        colar(1158, 270);
        delay(1000);
        moverEClicar(1108, 349);
        delay(1000);
        
        // VERIFICAR COR DO PASSO
        trocarTela();
        delay(1000);
        
        porProdutoOuCategoria();
        
        
    }

    

    private void fluxoPadrao() {
        
        copiar(660, 273);
        delay(200);
        limparPlanilha();
        delay(200);
        trocarTela();
        delay(1000);

        colar(177, 463);
        delay(200);
        
        moverEClicar(164, 628);
        delay(200);
        
        moverEClicar(171, 694);
        delay(200);
        inserirTexto("SELECIONE");
        delay(200);
        
        pegarDadosPlanilha();
        delay(200);
        
        colar(178, 759);
        delay(200);
        
        pegarDadosPlanilha();
        delay(200);
        
        colar(370, 759);
        delay(200);
        
        trocarTela();
        delay(1000);
        
        metodoLancamento();
                

    }

    private void pegarDadosPlanilha() {

        trocarTela();
        delay(200);
        copiar(660, 273);
        delay(200);

        limparPlanilha();
        delay(200);

        trocarTela();
        delay(200);
        

    }
    
    
    public void porProdutoOuCategoria(){
        
        Color corRobo = robot.getPixelColor(660, 273);
        moverEClicar(660, 273);
        
        if(corRobo.equals(CorFluxo.POR_CATEGORIA)){
            limparPlanilha();
            delay(1000);
            fluxoPadrao();
            
        } else if (corRobo.equals(CorFluxo.POR_PRODUTO)){
            System.out.println("null");
        }
    }
    
    public void metodoLancamento(){
        
        Color corRobo = robot.getPixelColor(660, 273);
        moverEClicar(660, 273);
        if(corRobo.equals(CorFluxo.MAIOR_VALOR)){
            delay(200);
            limparPlanilha();
            delay(200);
            trocarTela();
            delay(1000);
            moverEClicar(508, 880);
            delay(200);
            moverEClicar(303, 933);
            
            
        }else {
            JOptionPane.showMessageDialog(null, "Cor não é a mesma" + corRobo);  
        }
    }

}
