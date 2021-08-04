import javax.swing.JPanel;


public class ChangePanel {
	public static void ChangePanel(MainFrame mf, JPanel op, JPanel np) {
		mf.remove(op);
		mf.add(np);
		mf.revalidate();
		mf.repaint();
		
	}

}
