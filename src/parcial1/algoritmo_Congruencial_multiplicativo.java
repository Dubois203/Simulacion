/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class AlgoritmoCongruencialMultiplicativo extends JFrame
{ 
 private Container contenedor;
 private GridBagLayout esquema;
 private GridBagConstraints restricciones;
 JLabel l1, l2, l3, l4, l5, l6;
 JButton b1,b2;
 JTextField t1,t2, t3, t4, t5, t6;
 JTextArea a1, a2, a3;
 int numero=0, valor1=0, veces=0, cantidad=0, x=0, k=0, g=0, m=1, num=2, a=0;
 String valor, ccuadrado="", sale="", cua="", erre="";
 String cero="0.";
 int[] v;
 double[] r;
    
 public AlgoritmoCongruencialMultiplicativo()
 {
  setSize(350,350);
  setTitle("Algoritmo Congruencial Multiplicativo");
  setVisible(true);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  
  contenedor=getContentPane();
  esquema=new GridBagLayout();
  contenedor.setLayout(esquema);
  
  //**********************************************************
  //-   Permite ingresar imagen de fondo.              -
  //----------------------------------------------------------
  ((JPanel)getContentPane()).setOpaque(false);
  ImageIcon img = new ImageIcon("3.jpg");
  JLabel fondo = new JLabel(img);
  fondo.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
  getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
  //----------------------------------------------------------
  
  restricciones=new GridBagConstraints();  
  restricciones.insets=new Insets(5,5,5,5);
  
  restricciones.fill=GridBagConstraints.BOTH;

   l1=new JLabel("Algoritmo Congruencial Multiplicativo");
   l1.setFont (new Font ("Berlin Sans FB", Font.BOLD, 30));
         l1.setForeground (Color.DARK_GRAY);
         establecerValores(0,0,4,1);
         restricciones.fill=GridBagConstraints.BOTH;
         esquema.setConstraints(l1,restricciones);
         contenedor.add(l1);
   
 // ----- El valor de Xi o Semilla principal -----
 
   l2=new JLabel("Ingresa Valor de Semilla:");
   l2.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   l2.setForeground(Color.DARK_GRAY);
   establecerValores(0,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l2,restricciones);
   contenedor.add(l2);
 
   t1=new JTextField(10);
   t1.setToolTipText("Escribe Numero");
   t1.setBorder(BorderFactory.createLoweredBevelBorder());
   establecerValores(2,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t1,restricciones);
   contenedor.add(t1);
   
 // ----- El valor de la constante K -----

   l3=new JLabel("Valor de Constante 'K':");
   l3.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   l3.setForeground(Color.DARK_GRAY);
   establecerValores(0,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l3,restricciones);
   contenedor.add(l3);
 
   t2=new JTextField(10);
   t2.setToolTipText("Escribe Numero");
   t2.setBorder(BorderFactory.createLoweredBevelBorder());
   establecerValores(2,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t2,restricciones);
   contenedor.add(t2);
   
 // ----- El valor de el modulo -----
   
   l4=new JLabel("Valor de G:");
   l4.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   l4.setForeground(Color.DARK_GRAY);
   establecerValores(0,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);
 
   t3=new JTextField(10);
   t3.setToolTipText("Escribe Numero");
   t3.setBorder(BorderFactory.createLoweredBevelBorder());
   establecerValores(2,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t3,restricciones);
   contenedor.add(t3);
   
 //----- Boton que ejecuta la accion a realizar -----
       
   b1=new JButton("HaCeR");
   b1.setToolTipText("Clic Para Convertir");
   b1.setBorder(new EmptyBorder(10,15,10,15));
   b1.setMnemonic(KeyEvent.VK_H);
   b1.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   b1.setForeground(Color.RED);
   establecerValores(1,7,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b1,restricciones);
   contenedor.add(b1);
   
 //----- Boton que permite la limpieza de todas las cajas de texto -----

   b2=new JButton("LiMpIaR");
   b2.setToolTipText("Clic Para Limpiar Datos");
   b2.setBorder(new EmptyBorder(10,15,10,15));
   b2.setMnemonic(KeyEvent.VK_L);
   b2.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   b2.setForeground(Color.RED);
   establecerValores(3,7,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b2,restricciones);
   contenedor.add(b2);
 
 //----- Area deonde aparecera el resultado de la Xi -----  

   l4=new JLabel("Xi");
   l4.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   l4.setForeground(Color.DARK_GRAY);
   establecerValores(1,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);

   a1=new JTextArea(10,6);
   JScrollPane scrollPane1 = new JScrollPane(a1);
   a1.setEditable(false);
   a1.setBorder(BorderFactory.createLoweredBevelBorder());
   establecerValores(1,9,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(scrollPane1,restricciones);
   contenedor.add(scrollPane1);
   
 //----- Area donde aparecera el resultado de la Ri -----
 
   l5=new JLabel("Ri");
   l5.setFont(new Font("Berlin Sans FB",Font.BOLD,14));
   l5.setForeground(Color.DARK_GRAY);
   establecerValores(2,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l5,restricciones);
   contenedor.add(l5);
         
   a2=new JTextArea(10,8);
   JScrollPane scrollPane2 = new JScrollPane(a2);
   a2.setEditable(false);
   a2.setBorder(BorderFactory.createLoweredBevelBorder());
   establecerValores(2,9,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(scrollPane2,restricciones);
   contenedor.add(scrollPane2);
   
 //----- Escuchador de eventos -----
     
   ManejadorCamposTexto m=new ManejadorCamposTexto();
   b1.addActionListener(m);
   b2.addActionListener(m);
   
   pack();
   
 }

 //----- Posiciones de cada elemento dentro de nuestra ventana----- 
//********************************************************************************************
   public void establecerValores(int columna,int fila, int anchura, int altura)
   {
    restricciones.gridx=columna;
    restricciones.gridy=fila;
    
    restricciones.gridwidth=anchura;
    restricciones.gridheight=altura;
   }
//*******************************************************************************************
      
 public static void main(String args[])
 {
  new AlgoritmoCongruencialMultiplicativo();
 }
 
  private class ManejadorCamposTexto implements ActionListener
 {
  public void actionPerformed(ActionEvent evento)
  {
   if (evento.getSource()==b1)
   {
       //********** Permite verificar si la caja de texto esta vacia **********//
   
    if(t1.getText().equals("")|| t2.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null,"Ingresa dato faltante","error",JOptionPane.ERROR_MESSAGE);
    }
        
    else
    {
         
    try
    {
    x=Integer.parseInt(t1.getText());
    k=Integer.parseInt(t2.getText());
    g=Integer.parseInt(t3.getText());
  
    if(x%2==0)
    {
     JOptionPane.showMessageDialog(null,"X debe ser numero impar","error",JOptionPane.ERROR_MESSAGE);
     t1.setText("");
    }
    
    else
    {
     
    if(x<=0)
    {
     JOptionPane.showMessageDialog(null,"X debe ser valor positivo","error",JOptionPane.ERROR_MESSAGE);
     t1.setText("");
    }     
 
    else
    {
    
    if(k<=0)
    {
     JOptionPane.showMessageDialog(null,"K debe ser mayor a 0","error",JOptionPane.ERROR_MESSAGE);
     t2.setText("");     
    } 
        
    else
    {

    if(g<=0)
    {
     JOptionPane.showMessageDialog(null,"G debe ser mayor a 0","error",JOptionPane.ERROR_MESSAGE);
     t3.setText("");     
    }     
    
    else
    {
     
     for(int j=0; j<g; j++)
      {
       m*=num;
       System.out.println(m);
      }
      
      int cantidad=m/4;
      
      a=5+(8*k); 
            
     for(int i=0; i<cantidad; i++)
     {  
      numero=(a*x)%m;
      
      String n1=String.valueOf(numero);
      x=Integer.parseInt(n1);

      
   v=new int[cantidad];
   r=new double[cantidad];
   v[i]=x;
   r[i]=(v[i]*1.0)/(m-1);   
   sale+="x"+(i+1)+":  "+v[i]+"\n";
 
   String err=String.valueOf(r[i]);
   String yo=String.format("%.5f", r[i]);
   erre+="r"+(i+1)+":  "+yo+"\n";     
     
     }      
     }
    }
    }
    }
     
     a1.setText(sale);
     a2.setText(erre);
     
    }
    
    catch(java.lang.NumberFormatException e)
    {
     JOptionPane.showMessageDialog(null,"Dato invalido","error",JOptionPane.ERROR_MESSAGE);
     t1.setText("");
     t2.setText("");
     t3.setText("");


    }
     
    }
    
   }
   
   if(evento.getSource()==b2)
   {
    t1.setText("");
    t2.setText("");
    t3.setText("");
    a1.setText("");
    a2.setText("");
       m=1;
       num=2;
       
     //----- Permite vaciar el arreglo -----
     
     if(sale != null && erre != null)
     {
      sale="";
      erre="";
     }
     
     if(v != null && r != null)
     {
      for(int l=0; l<cantidad; l++)
      {
       v=null;
       r=null;
      
      }
     }
 
   }
   
  }
 }
 

}