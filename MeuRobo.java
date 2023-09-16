import robocode.*;
import java.awt.Color;

public class MeuRobo extends AdvancedRobot {
    private boolean moveRight = true; // Variável para alternar entre mover para a direita e para a esquerda

    public void run() {
        setColors(Color.blue, Color.red, Color.green); // Defina as cores do seu robô

        while (true) {
            if (moveRight) {
                setTurnRight(90); // Gire para a direita
                setAhead(100); // Mova para a direita
            } else {
                setTurnLeft(90); // Gire para a esquerda
                setAhead(100); // Mova para a esquerda
            }

            // Alterne a direção de movimento
            moveRight = !moveRight;

            // Ajuste a mira para o inimigo
            turnGunRight(getRadarTurnRemaining());

            // Execute os comandos definidos acima
            execute();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        // Quando um robô é detectado, atire com potência máxima
        fire(3);
    }
}

