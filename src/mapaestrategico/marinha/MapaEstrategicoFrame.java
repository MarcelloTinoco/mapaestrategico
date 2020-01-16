package mapaestrategico.marinha;

import javax.swing.JFrame;

public class MapaEstrategicoFrame extends JFrame{

	public MapaEstrategicoFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
    	getContentPane().add(new MapaEstrategicoPanel());
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
	}
	
	public static void main(String args[]){
    	new MapaEstrategicoFrame().setVisible(true);
    	
    }
}
