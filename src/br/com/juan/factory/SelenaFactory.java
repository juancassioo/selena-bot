package br.com.juan.factory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SelenaFactory implements Selena {

    static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delay(int intervalo) {
        robot.delay(intervalo);

    }

    @Override
    public void moverMouse(int x, int y) {
        robot.mouseMove(x, y);
    }

    @Override
    public void cliqueMouse() {
        delay(100);
        robot.mousePress(MouseEvent.getMaskForButton(MouseEvent.BUTTON1));
        delay(100);
        robot.mouseRelease(MouseEvent.getMaskForButton(MouseEvent.BUTTON1));
    }

    @Override
    public void moverEClicar(int x, int y) {
        delay(100);
        moverMouse(x, y);
        delay(100);
        cliqueMouse();
    }

    private static void mouseGlide(int x1, int y1, int x2, int y2, int t, int n) {

        try {
            Robot r = new Robot();
            double dx = (x2 - x1) / ((double) n);
            double dy = (y2 - y1) / ((double) n);
            double dt = t / ((double) n);
            for (int step = 1; step <= n; step++) {
                Thread.sleep((int) dt);
                r.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
            }
        } catch (AWTException | InterruptedException e) {
        }
    }

    public void mouseArrastar(int xComeco, int yComeco, int xFinal, int yFinal) {
        moverMouse(xComeco, yComeco);
        delay(500);
        robot.mousePress(MouseEvent.getMaskForButton(MouseEvent.BUTTON1));
        robot.delay(500);
        mouseGlide(xComeco, yComeco, xFinal, yFinal, 500, 5);
        robot.delay(500);
        robot.mouseRelease(MouseEvent.getMaskForButton(MouseEvent.BUTTON1));
    }

    @Override
    public void copiar(int x, int y) {
        moverEClicar(x, y);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
    }

    @Override
    public void colar(int x, int y) {
        moverEClicar(x, y);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

    }

    @Override
    public void trocarTela() {
        delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_TAB);
        delay(1000);

    }

    @Override
    public void proximoProduto() {
        moverEClicar(1010, 250);
    }

    @Override
    public void limparPlanilha(int vezes) {

        for (int x = 1; vezes >= x; x++) {
            robot.delay(200);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public void limparPlanilha() {

        robot.delay(200);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_9);
        robot.keyRelease(KeyEvent.VK_9);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Override
    public void chamarNovoProduto() {
        moverEClicar(1009, 250);
        robot.delay(1200);

    }

    public void inserirTexto(String keys) {
        for (char c : keys.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException(
                        "Key code not found for character '" + c + "'");
            }
            robot.keyPress(keyCode);
            robot.delay(100);
            robot.keyRelease(keyCode);
            robot.delay(100);
        }

    }

}
