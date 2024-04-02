package Game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import Game.Commons;
public class Host extends JFrame{
    public Host(){
        initialise();
    }

    private void initialise(){
        add(new Board());

        setTitle("I'm not safe");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            var ex = new Host();
            ex.setVisible(true);
            }
        );
    }

}
