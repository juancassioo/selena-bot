package br.com.juan.factory;

import br.com.juan.model.CorFluxo;
import java.awt.Color;
import javax.swing.JOptionPane;

public class FluxoSelena extends SelenaFactory {
    
    public void fluxoPrincipal() {
        
        int contador = 0;
        
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
        
        int contador = 0;
        
        moverEClicar(660, 273);
        Color corRobo = robot.getPixelColor(660, 273);
        
        if(corRobo.equals(CorFluxo.POR_CATEGORIA)){
            contador++;
            limparPlanilha();
            delay(1000);
            fluxoPadrao();
            pegarDadosPlanilha();
            delay(500);
            moverEClicar(885, 372);
            delay(1000);
            colar(715, 369);
            delay(500);
            mouseArrastar(648, 448, 1068, 453);
            delay(500);
            trocarTela();
              
        } else if (corRobo.equals(CorFluxo.POR_PRODUTO)){
            contador++;
            limparPlanilha();
            delay(1000);
            fluxoPadrao();
            trocarTela();
            moverEClicar(660, 273);
            
            corRobo = robot.getPixelColor(660, 273);
            
            while (corRobo.equals(CorFluxo.PRODUTO_INDIVIDUAL)){
                copiar(660, 273);
                limparPlanilha();
                delay(1000);
                trocarTela();
                delay(1000);
                moverEClicar(886, 645);
                delay(500);
                colar(709, 645);
                delay(1000);
                mouseArrastar(745, 724, 1068, 727);
                delay(500);
                trocarTela();
                corRobo = robot.getPixelColor(660, 273);
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Foi executado " + contador + " vezes");
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
            
        } else if (corRobo.equals(CorFluxo.SOMAR_VALORES)) {
            delay(200);
            limparPlanilha();
            delay(200);
            trocarTela();
            delay(1000);
            moverEClicar(508, 880);
            delay(200);
            moverEClicar(388, 957);
            
        } else if (corRobo.equals(CorFluxo.MEDIA_PRODUTOS)) {
            delay(200);
            limparPlanilha();
            delay(200);
            trocarTela();
            delay(1000);
            moverEClicar(508, 880);
            delay(200);
            moverEClicar(382, 981);
        
        } else if (corRobo.equals(CorFluxo.IGNORAR_PRECO)) {
            delay(200);
            limparPlanilha();
            delay(200);
            trocarTela();
            delay(1000);
            moverEClicar(508, 880);
            delay(200);
            moverEClicar(426, 1005);
            
        }else {
            JOptionPane.showMessageDialog(null, "Cor divergente" + corRobo);  
        }
    }
    
    private void salvar(){
        delay(500);
        moverEClicar(1879, 1029);
        moverEClicar(1819, 1005);
    }

}
