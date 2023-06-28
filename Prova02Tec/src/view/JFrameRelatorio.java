package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JFrameRelatorio extends JFrame{
	private DefaultTableModel modelo;
	private JTable jt;
	
	public JFrameRelatorio(String[] strDeDados, Component parentComponent) {
		
		this.setSize(1000,500);
		this.setResizable(false);
		this.setTitle("Relatorio Das Partidas");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		modelo = new DefaultTableModel();
		
	 	modelo.addColumn("Jogador");
	 	modelo.addColumn("Celulas Vazias");
	 	modelo.addColumn("Pontuacao Geral");
	 	modelo.addColumn("Alunos Resgatados");
	 	modelo.addColumn("Bugs Encontrados");
	 	modelo.addColumn("Rodadas");
	 	modelo.addColumn("Robo Andador");
	 	modelo.addColumn("Robo Cavalo");
	 	modelo.addColumn("Robo Rei");
	 	
	 	for (String linhaDeDados : strDeDados) {
			String dados[] = linhaDeDados.split(";");
			modelo.addRow(dados);
		}
	 	
		jt = new JTable(modelo);
		
		jt.setBackground(Color.LIGHT_GRAY);
		this.add(new JScrollPane(jt));
		this.setVisible(true);
	}
	
}

