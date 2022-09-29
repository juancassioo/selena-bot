package br.com.juan.factory;

public interface Selena {
    
    public void delay(int delay);
    public void moverMouse(int x, int y);
    public void cliqueMouse();
    public void moverEClicar(int x, int y);
    public void trocarTela();
    public void copiar(int x, int y);
    public void colar(int x, int y);
    public void salvarPasso();
    public void proximoProduto();
    public void limparPlanilha(int vezes);
    public void chamarNovoProduto();
 
}
