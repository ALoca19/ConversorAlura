import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class Prueba extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int diferenciador=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean esNumero(String texto) {
        try {
            double numero = Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	private void convertirDato(int primeraOpcion, double valorIntroducido, String monedaDestino)
	{
		double res = 0;
		
		switch (primeraOpcion) 
		{
	        case 1: //peso
		        	if(monedaDestino.equals("Pesos"))
		            {
		        		res = valorIntroducido;
		            }
		            else if(monedaDestino.equals("Dolar"))
		            {
		            	res =  valorIntroducido*0.059;
		            }
		            else if(monedaDestino.equals("Euro"))
		            {
		            	res =  valorIntroducido*0.053;
		            }
		            else if(monedaDestino.equals("Yen Japones"))
		            {
		            	res =  valorIntroducido*8.30;
		            }
		            else
		            {
		            	res =  0;
		            }
		        	textField_1.setText(""+res);
		        	
	            break;
	            
	        case 2: //dolar
		        	if(monedaDestino.equals("Pesos"))
		            {
		        		res = valorIntroducido*17.08;
		            }
		            else if(monedaDestino.equals("Dolar"))
		            {
		            	res =  valorIntroducido;
		            }
		            else if(monedaDestino.equals("Euro"))
		            {
		            	res =  valorIntroducido*0.91;
		            }
		            else if(monedaDestino.equals("Yen Japones"))
		            {
		            	res =  valorIntroducido*141.75;
		            }
		            else
		            {
		            	res =  0;
		            }
		        	textField_1.setText(""+res);
	            break;
	        case 3: //euro
		        	if(monedaDestino.equals("Pesos"))
		            {
		        		res = valorIntroducido*18.80;
		            }
		            else if(monedaDestino.equals("Dolar"))
		            {
		            	res =  valorIntroducido*1.10;
		            }
		            else if(monedaDestino.equals("Euro"))
		            {
		            	res =  valorIntroducido;
		            }
		            else if(monedaDestino.equals("Yen Japones"))
		            {
		            	res =  valorIntroducido*156.31;
		            }
		            else
		            {
		            	res =  0;
		            }
		        	textField_1.setText(""+res);
	            break;
	        case 4: //yen
		        	if(monedaDestino.equals("Pesos"))
		            {
		        		res = valorIntroducido*0.12;
		            }
		            else if(monedaDestino.equals("Dolar"))
		            {
		            	res =  valorIntroducido*0.0071;
		            }
		            else if(monedaDestino.equals("Euro"))
		            {
		            	res =  valorIntroducido*0.0064;
		            }
		            else if(monedaDestino.equals("Yen Japones"))
		            {
		            	res =  valorIntroducido;
		            }
		            else
		            {
		            	res =  0;
		            }
		        	textField_1.setText(""+res);
	            break;
	        default:
	            System.out.println("Opción no válida.");
	            break;
		}
		
	}
	
	private double resultadoFinal(double valor, String moneda)
	{
		if(moneda.equals("Pesos"))
        {
        	return valor;
        }
        else if(moneda.equals("Dolar"))
        {
        	return valor*0.059;
        }
        else if(moneda.equals("Euro"))
        {
        	return valor*0.053;
        }
        else if(moneda.equals("Yen Japones"))
        {
        	return valor*8.30;
        }
        else
        {
        	return 0;
        }
	}

	/**
	 * Create the frame.
	 */
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pesos", "Dolar", "Euro", "Yen Japones"}));
		comboBox_1.setBounds(127, 112, 69, 21);
		contentPane.add(comboBox_1);
		
		final JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Pesos", "Dolar", "Euro", "Yen Japones"}));
		comboBox_1_1.setBounds(357, 113, 69, 21);
		contentPane.add(comboBox_1_1);
		comboBox_1_1.setSelectedItem("Dolar");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Monedas", "Temperatura"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String seleccionConversion = (String) comboBox.getSelectedItem();
				if(seleccionConversion.equals("Monedas"))
				{
					comboBox_1.removeAllItems();
					comboBox_1_1.removeAllItems();
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pesos", "Dolar", "Euro", "Yen Japones"}));
					comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Pesos", "Dolar", "Euro", "Yen Japones"}));
					comboBox_1_1.setSelectedItem("Dolar");
			
	                diferenciador = 0;
				
				}
				else if(seleccionConversion.equals("Temperatura"))
				{
					comboBox_1.removeAllItems();
					comboBox_1_1.removeAllItems();
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
					comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
					comboBox_1_1.setSelectedItem("Fahrenheit");
					diferenciador = 1;
				}
					
				
			}
		});
		comboBox.setBounds(181, 43, 103, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Conversor de");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblNewLabel.setBounds(75, 0, 326, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Convertir");
		lblNewLabel_1.setBounds(72, 90, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(21, 113, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(206, 116, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(251, 114, 96, 19);
		contentPane.add(textField_1);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Resultado");
		lblNewLabel_1_1.setBounds(323, 90, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Convertir");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textoEntrada = textField.getText();
				
				if(esNumero(textoEntrada))
				{
					String conversor = (String) comboBox.getSelectedItem();
					
					String monedaOrigen = (String) comboBox_1.getSelectedItem();
	                String monedaDestino = (String) comboBox_1_1.getSelectedItem();

	                double valorIntroducido = Double.parseDouble(textoEntrada);
					if(conversor.equals("Monedas"))
					{ 
	                	
		                if(monedaOrigen.equals("Pesos"))
		                {
		                	convertirDato(1, valorIntroducido, monedaDestino);
		                }
		                else if(monedaOrigen.equals("Dolar"))
		                {
		                	convertirDato(2, valorIntroducido, monedaDestino);
		                }
		                else if(monedaOrigen.equals("Euro"))
		                {
		                	convertirDato(3, valorIntroducido, monedaDestino);
		                }
		                else if(monedaOrigen.equals("Yen Japones"))
		                {
		                	convertirDato(4, valorIntroducido, monedaDestino);
		                }
					}
					else if(conversor.equals("Temperatura"))
					{
						if(monedaOrigen.equals("Celsius"))
						{
							if(monedaDestino.equals("Celsius"))
							{
								textField_1.setText(""+valorIntroducido);
							}
							else if(monedaDestino.equals("Fahrenheit"))
			                {
								textField_1.setText(""+( (valorIntroducido*(9/5))+32 ));
			                }
			                else if(monedaDestino.equals("Kelvin"))
			                {
			                	textField_1.setText(""+(valorIntroducido+273.15));
			                }
						}
						else if(monedaOrigen.equals("Fahrenheit"))
		                {
							if(monedaDestino.equals("Celsius"))
							{
								textField_1.setText(""+ ((valorIntroducido-32)*(5/9)) );
							}
							else if(monedaDestino.equals("Fahrenheit"))
			                {
								textField_1.setText(""+valorIntroducido);
			                }
			                else if(monedaDestino.equals("Kelvin"))
			                {
			                	textField_1.setText(""+( ((valorIntroducido-32)*(5/9)) +273.15  ));
			                
			                }
		                }
		                else if(monedaOrigen.equals("Kelvin"))
		                {
		                	if(monedaDestino.equals("Celsius"))
							{
								textField_1.setText(""+ (valorIntroducido-273.15) );
							}
							else if(monedaDestino.equals("Fahrenheit"))
			                {
								textField_1.setText(""+( ((valorIntroducido-273.15)*(9/5)) +32  ));	
			                }
			                else if(monedaDestino.equals("Kelvin"))
			                {
			                	textField_1.setText(""+valorIntroducido);
			                }
		                }
					}
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce un dato valido");
				}
				
				
			}
		});
		
		
		
		btnNewButton.setBounds(172, 157, 112, 34);
		contentPane.add(btnNewButton);
	}
}
