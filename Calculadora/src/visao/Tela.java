package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import modelo.Memoria;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Canvas;
import javax.swing.UIManager;

public class Tela extends JFrame {
	String textoDisplay = "0";
	String valor1, valor2;
	int FzrOpe = 0;//contador de numero na operacao, quando atinge 2 ele realiza uma operacao
	boolean PodeSimb = false;
	boolean PodeNum = true;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Tela frame = new Tela();
				frame.setVisible(true);
				frame.setResizable(false);
				
			}
		});
	}
	

	public Tela() {
		setTitle("CALCULADORA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// display
		JPanel display = new JPanel();
		display.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		display.setBackground(Color.BLACK);
		display.setForeground(Color.BLACK);
		display.setBounds(0, 0, 361, 117);
		contentPane.add(display);
		display.setLayout(null);

		JLabel TexDisplay = new JLabel(textoDisplay);
		TexDisplay.setBounds(10, 34, 341, 50);
		TexDisplay.setFont(new Font("Consolas", Font.PLAIN, 30));
		TexDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		TexDisplay.setForeground(Color.WHITE);
		display.add(TexDisplay);

		// botoes teclado
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 116, 371, 342);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton bAc = new JButton("AC");
		bAc.setFocusable(false);
		bAc.setFocusTraversalKeysEnabled(false);
		bAc.setFocusPainted(false);
		bAc.setRequestFocusEnabled(false);
		bAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TexDisplay.setText("0");
				PodeSimb=false;
				FzrOpe=0;
				PodeNum=true;
			}
		});
		bAc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bAc.setForeground(Color.WHITE);
		bAc.setFont(new Font("Consolas", Font.PLAIN, 25));
		bAc.setBackground(new Color(72, 61, 139));
		bAc.setBounds(0, 0, 270, 66);
		panel.add(bAc);

		JButton b7 = new JButton("7");
		b7.setFocusable(false);
		b7.setFocusTraversalKeysEnabled(false);
		b7.setFocusPainted(false);
		b7.setRequestFocusEnabled(false);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0" )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;
			}
		});
		b7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b7.setForeground(Color.WHITE);
		b7.setFont(new Font("Consolas", Font.PLAIN, 25));
		b7.setBackground(new Color(72, 61, 139));
		b7.setBounds(0, 66, 90, 66);
		panel.add(b7);

		JButton b4 = new JButton("4");
		b4.setFocusable(false);
		b4.setFocusTraversalKeysEnabled(false);
		b4.setFocusPainted(false);
		b4.setRequestFocusEnabled(false);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0"  )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Consolas", Font.PLAIN, 25));
		b4.setBackground(new Color(72, 61, 139));
		b4.setBounds(0, 132, 90, 66);
		panel.add(b4);

		JButton b1 = new JButton("1");
		b1.setFocusable(false);
		b1.setFocusTraversalKeysEnabled(false);
		b1.setFocusPainted(false);
		b1.setRequestFocusEnabled(false);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0" )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Consolas", Font.PLAIN, 25));
		b1.setBackground(new Color(72, 61, 139));
		b1.setBounds(0, 198, 90, 66);
		panel.add(b1);

		JButton b0 = new JButton("0");
		b0.setFocusable(false);
		b0.setFocusTraversalKeysEnabled(false);
		b0.setFocusPainted(false);
		b0.setRequestFocusEnabled(false);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0" )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b0.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b0.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		b0.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b0.setForeground(Color.WHITE);
		b0.setFont(new Font("Consolas", Font.PLAIN, 25));
		b0.setBackground(new Color(72, 61, 139));
		b0.setBounds(0, 264, 180, 66);
		panel.add(b0);

		JButton b8 = new JButton("8");
		b8.setFocusable(false);
		b8.setFocusTraversalKeysEnabled(false);
		b8.setFocusPainted(false);
		b8.setRequestFocusEnabled(false);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0"  )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b8.setForeground(Color.WHITE);
		b8.setFont(new Font("Consolas", Font.PLAIN, 25));
		b8.setBackground(new Color(72, 61, 139));
		b8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b8.setBounds(90, 66, 90, 66);
		panel.add(b8);

		JButton b5 = new JButton("5");
		b5.setFocusable(false);
		b5.setFocusTraversalKeysEnabled(false);
		b5.setFocusPainted(false);
		b5.setRequestFocusEnabled(false);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0"  )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b5.setForeground(Color.WHITE);
		b5.setFont(new Font("Consolas", Font.PLAIN, 25));
		b5.setBackground(new Color(72, 61, 139));
		b5.setBounds(90, 132, 90, 66);
		panel.add(b5);

		JButton b2 = new JButton("2");
		b2.setFocusable(false);
		b2.setFocusTraversalKeysEnabled(false);
		b2.setFocusPainted(false);
		b2.setRequestFocusEnabled(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0"  )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Consolas", Font.PLAIN, 25));
		b2.setBackground(new Color(72, 61, 139));
		b2.setBounds(90, 198, 90, 66);
		panel.add(b2);

		JButton b9 = new JButton("9");
		b9.setFocusable(false);
		b9.setFocusTraversalKeysEnabled(false);
		b9.setFocusPainted(false);
		b9.setRequestFocusEnabled(false);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0"  )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b9.setForeground(Color.WHITE);
		b9.setFont(new Font("Consolas", Font.PLAIN, 25));
		b9.setBackground(new Color(72, 61, 139));
		b9.setBounds(180, 66, 90, 66);
		panel.add(b9);

		JButton b6 = new JButton("6");
		b6.setFocusable(false);
		b6.setFocusTraversalKeysEnabled(false);
		b6.setFocusPainted(false);
		b6.setRequestFocusEnabled(false);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0" )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Consolas", Font.PLAIN, 25));
		b6.setBackground(new Color(72, 61, 139));
		b6.setBounds(180, 132, 90, 66);
		panel.add(b6);

		JButton b3 = new JButton("3");
		b3.setFocusable(false);
		b3.setFocusTraversalKeysEnabled(false);
		b3.setFocusPainted(false);
		b3.setRequestFocusEnabled(false);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() == "0"  )
					TexDisplay.setText(botao.getText());
				else if(PodeNum){
					TexDisplay.setText(TexDisplay.getText() + botao.getText());					
				}
				PodeSimb = true;

			}
		});
		b3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Consolas", Font.PLAIN, 25));
		b3.setBackground(new Color(72, 61, 139));
		b3.setBounds(180, 198, 90, 66);
		panel.add(b3);

		JButton bPonto = new JButton(".");
		bPonto.setFocusable(false);
		bPonto.setFocusTraversalKeysEnabled(false);
		bPonto.setFocusPainted(false);
		bPonto.setRequestFocusEnabled(false);
		bPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() != "0" && PodeSimb == true)
					TexDisplay.setText(TexDisplay.getText() + botao.getText());
				PodeSimb = false;

			}
		});
		bPonto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bPonto.setForeground(Color.WHITE);
		bPonto.setFont(new Font("Consolas", Font.PLAIN, 25));
		bPonto.setBackground(new Color(72, 61, 139));
		bPonto.setBounds(180, 264, 90, 66);
		panel.add(bPonto);

		// OPERACOES
		JButton bDi = new JButton("/");
		bDi.setFocusable(false);
		bDi.setFocusTraversalKeysEnabled(false);
		bDi.setFocusPainted(false);
		bDi.setRequestFocusEnabled(false);
		bDi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FzrOpe >= 1 && PodeSimb)
					TexDisplay.setText(Memoria.getMemoria().FazerCalculo(TexDisplay.getText()));
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() != "0" && PodeSimb == true) {
					TexDisplay.setText(TexDisplay.getText() + " " + botao.getText() + " ");
				    PodeSimb = false;
				    FzrOpe++;
				    PodeNum=true;

				}
			}
		});
		bDi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bDi.setForeground(Color.WHITE);
		bDi.setFont(new Font("Consolas", Font.PLAIN, 25));
		bDi.setBackground(Color.RED);
		bDi.setBounds(270, 0, 90, 66);
		panel.add(bDi);

		JButton bMult = new JButton("*");
		bMult.setFocusable(false);
		bMult.setFocusTraversalKeysEnabled(false);
		bMult.setFocusPainted(false);
		bMult.setRequestFocusEnabled(false);
		bMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FzrOpe >= 1 && PodeSimb)
					TexDisplay.setText(Memoria.getMemoria().FazerCalculo(TexDisplay.getText()));
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() != "0" && PodeSimb == true) {
					TexDisplay.setText(TexDisplay.getText() + " " + botao.getText() + " ");
				    PodeSimb = false;
				    FzrOpe++;
				    PodeNum=true;
				}
			}
		});
		bMult.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bMult.setForeground(Color.WHITE);
		bMult.setFont(new Font("Consolas", Font.PLAIN, 25));
		bMult.setBackground(Color.RED);
		bMult.setBounds(270, 66, 90, 66);
		panel.add(bMult);

		JButton bSo = new JButton("+");
		bSo.setFocusable(false);
		bSo.setFocusTraversalKeysEnabled(false);
		bSo.setFocusPainted(false);
		bSo.setRequestFocusEnabled(false);
		bSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FzrOpe >= 1 && PodeSimb)
					TexDisplay.setText(Memoria.getMemoria().FazerCalculo(TexDisplay.getText()));
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() != "0" && PodeSimb == true) {
					TexDisplay.setText(TexDisplay.getText() + " " + botao.getText() + " ");
				    PodeSimb = false;
				    FzrOpe++;
				    PodeNum=true;

				}
			}
		});
		bSo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bSo.setForeground(Color.WHITE);
		bSo.setFont(new Font("Consolas", Font.PLAIN, 25));
		bSo.setBackground(Color.RED);
		bSo.setBounds(270, 132, 90, 66);
		panel.add(bSo);

		JButton bSub = new JButton("-");
		bSub.setFocusable(false);
		bSub.setFocusTraversalKeysEnabled(false);
		bSub.setFocusPainted(false);
		bSub.setRequestFocusEnabled(false);
		bSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FzrOpe >= 1 && PodeSimb)
					TexDisplay.setText(Memoria.getMemoria().FazerCalculo(TexDisplay.getText()));
				JButton botao = (JButton) e.getSource();
				if (TexDisplay.getText() != "0" && PodeSimb == true) {
					TexDisplay.setText(TexDisplay.getText() + " " + botao.getText() + " ");
				    PodeSimb = false;
				    FzrOpe++;
				    PodeNum=true;

				}
			}
		});
		bSub.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bSub.setForeground(Color.WHITE);
		bSub.setFont(new Font("Consolas", Font.PLAIN, 25));
		bSub.setBackground(Color.RED);
		bSub.setBounds(270, 198, 90, 66);
		panel.add(bSub);

		JButton bIgual = new JButton("=");
		bIgual.setFocusable(false);
		bIgual.setFocusTraversalKeysEnabled(false);
		bIgual.setFocusPainted(false);
		bIgual.setRequestFocusEnabled(false);
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FzrOpe >= 1) {
					TexDisplay.setText(Memoria.getMemoria().FazerCalculo(TexDisplay.getText()));
					PodeSimb = true;
					PodeNum=false;
				}
			}
		});
		bIgual.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bIgual.setForeground(Color.WHITE);
		bIgual.setFont(new Font("Consolas", Font.PLAIN, 25));
		bIgual.setBackground(Color.RED);
		bIgual.setBounds(270, 264, 90, 66);
		panel.add(bIgual);
	}
}
