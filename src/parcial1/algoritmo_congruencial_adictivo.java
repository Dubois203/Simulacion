/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

class AlgoritmoCongruencialAditivo extends JFrame
{ 
 private Container contenedor;
 private GridBagLayout esquema;
 private GridBagConstraints restricciones;
 JLabel l1, l2, l3, l4, l5, l6;
 JButton b1,b2;
 JTextField t1,t2, t3, t4, t5, t6;
 JTextArea a1, a2, a3;
 int numero=0, valor1=0, veces=0;
 String valor, ccuadrado="", sale="", cua="", erre="", algo="", lfinal="", rtot="";
 LinkedList lista=new LinkedList();
 int n, num1, num2, ta1=0, ta2=0, ta3=0;
 double y;
 
 public AlgoritmoCongruencialAditivo()
 {
  setSize(350,350);
  setTitle("Algoritmo Congruencial Aditivo");
  setVisible(true);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  
  contenedor=getContentPane();
  esquema=new GridBagLayout();
  contenedor.setLayout(esquema);
  
 
/*  
//**********************************************************
  //-   Permite ingresar imagen de fondo.              -
  //----------------------------------------------------------
  ((JPanel)getContentPane()).setOpaque(false);
  ImageIcon img = new ImageIcon("16.jpg");
  JLabel fondo = new JLabel(img);
  fondo.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
  getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
  //----------------------------------------------------------
  
*/

  restricciones=new GridBagConstraints();  
  restricciones.insets=new Insets(5,5,5,5);
  
  restricciones.fill=GridBagConstraints.BOTH;

   l1=new JLabel("Algoritmo Congruencial Aditivo");
   l1.setFont (new Font ("Constantia", Font.BOLD, 25));
         l1.setForeground (Color.BLACK);
         establecerValores(0,0,4,1);
         restricciones.fill=GridBagConstraints.BOTH;
         esquema.setConstraints(l1,restricciones);
         contenedor.add(l1);
         
   //----- Cantidad de datos a ingresar -----
   l2=new JLabel("Ingresa la cantidad de datos:");
   l2.setFont(new Font("Bell MT",Font.PLAIN,14));
   l2.setForeground(Color.BLACK);
   establecerValores(0,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l2,restricciones);
   contenedor.add(l2);
 
   
   t1=new JTextField(10);
   t1.setToolTipText("Escribe Numero");
   t1.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 3, Color.BLACK));
   establecerValores(2,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t1,restricciones);
   contenedor.add(t1);
   
   //----- Valor del modulo -----
   l3=new JLabel("Valor del modulo (m)");
   l3.setFont(new Font("Bell MT",Font.PLAIN,14));
   l3.setForeground(Color.BLACK);
   establecerValores(0,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l3,restricciones);
   contenedor.add(l3);
 
   t2=new JTextField(10);
   t2.setToolTipText("Escribe Numero");
   t2.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 3, Color.BLACK));
   establecerValores(2,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t2,restricciones);
   contenedor.add(t2);
   
   //----- Cantidad de numeros a generar -----
   l4=new JLabel("Ingresa la cantidad de datos a generar:");
   l4.setFont(new Font("Bell MT",Font.PLAIN,14));
   l4.setForeground(Color.BLACK);
   establecerValores(0,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);
 
   t3=new JTextField(10);
   t3.setToolTipText("Escribe Numero");
   t3.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 3, Color.BLACK));
   establecerValores(2,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t3,restricciones);
   contenedor.add(t3);
      
   b1=new JButton("Calcular");
   b1.setBorder(new EmptyBorder(10,15,10,15));
   b1.setMnemonic(KeyEvent.VK_H);
   b1.setFont(new Font("Bell MT",Font.PLAIN,14));
   b1.setForeground(Color.BLACK);
   establecerValores(1,7,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b1,restricciones);
   contenedor.add(b1);

   b2=new JButton(" Borrar");
   b2.setBorder(new EmptyBorder(10,15,10,15));
   b2.setMnemonic(KeyEvent.VK_L);
   b2.setFont(new Font("Bell MT",Font.PLAIN,14));
   b2.setForeground(Color.BLACK);
   establecerValores(3,7,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b2,restricciones);
   contenedor.add(b2);  

   l4=new JLabel("Numeros Ingresados");
   l4.setFont(new Font("Bell MT",Font.PLAIN,14));
   l4.setForeground(Color.BLACK);
   establecerValores(1,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);

   a1=new JTextArea(2,15);
   a1.setEditable(false);
   a1.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK));
   establecerValores(1,9,3,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a1,restricciones);
   contenedor.add(a1);

   l5=new JLabel("Xi");
   l5.setFont(new Font("Bell MT",Font.PLAIN,14));
   l5.setForeground(Color.BLACK);
   establecerValores(2,10,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l5,restricciones);
   contenedor.add(l5);
         
   a2=new JTextArea(10,6);
   a2.setEditable(false);
   a2.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK));
   establecerValores(2,11,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a2,restricciones);
   contenedor.add(a2);
      
   l6=new JLabel("Ri");
   l6.setFont(new Font("Bell MT",Font.PLAIN,14));
   l6.setForeground(Color.BLACK);
   establecerValores(3,10,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l6,restricciones);
   contenedor.add(l6);
         
   a3=new JTextArea(10,6);
   a3.setEditable(false);
   a3.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK));
   establecerValores(3,11,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a3,restricciones);
   contenedor.add(a3);
     
   ManejadorCamposTexto m=new ManejadorCamposTexto();
   b1.addActionListener(m);
   b2.addActionListener(m);
   
   pack();
 }
 
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
  new AlgoritmoCongruencialAditivo();
 }
 
  private class ManejadorCamposTexto implements ActionListener
 {
  public void actionPerformed(ActionEvent evento)
  {
   if (evento.getSource()==b1)
   {
    if(t1.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null,"Ingresa la cantidad de datos");
    }

    if(t2.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null,"Ingresa modulo");
    }

    if(t3.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null,"Ingresa la cantidad de datos a generar");
    }
            
    else
    {
         
    try
    {
    int datos=Integer.parseInt(t1.getText());
    int modulo=Integer.parseInt(t2.getText());
    int cantidad=Integer.parseInt(t3.getText());
    
     if(datos<=0)
     {
      JOptionPane.showMessageDialog(null,"El numero de datos debe ser \nmayorr a 0","error",JOptionPane.ERROR_MESSAGE);
      t1.setText("");
     }
     
     else
     {
      
     if(modulo<=0)
     {
      JOptionPane.showMessageDialog(null,"El numero modulo debe ser \nmayor a 0","error",JOptionPane.ERROR_MESSAGE);
      t2.setText("");      
     }
     
     else
     {

     if(cantidad<=0)
     {
      JOptionPane.showMessageDialog(null,"El numero de datos debe ser \nmayor a 0","error",JOptionPane.ERROR_MESSAGE);
      t3.setText("");      
     }
     
     else
     {     
        
     for(int i=0; i<datos; i++)
     {  
      
      n=Integer.parseInt(JOptionPane.showInputDialog("Ingresa dato "+(i+1)+" : "));
      lista.addLast(n);
      sale+=n+" "; 
       
       ta1++;         
     }
     
     for(int i=0; i<cantidad; i++)
     {       
       String dat1=String.valueOf(lista.get(datos-1+i));
       int da1=Integer.parseInt(dat1);
       
       String dat2=String.valueOf(lista.get(i));
       int da2=Integer.parseInt(dat2);
       
        ta2++;
        ta3=ta1+ta2;
        
       n=(da1+da2)% modulo;
       lista.addLast(n);
       lfinal+="x"+ta3+":  "+n+"\n";
       
       y=n*1.0/(modulo-1);
       String yt=String.format("%.5f",y);
       rtot+="r"+i+": "+yt+"\n";
     }
     
     a1.setText(sale);
     a2.setText(lfinal);
     a3.setText(rtot);

     
    }
     }
    }
     }
     
    catch(java.lang.NumberFormatException e)
    {
     JOptionPane.showMessageDialog(null,"Dato invalido");
     t1.setText("");
     t2.setText("");
     t3.setText("");
     t4.setText("");


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
    a3.setText("");
    
     //----- Permite vaciar el arreglo -----
     
     if(sale != null && lfinal != null && rtot != null)
     {
      sale="";
      lfinal="";
      rtot="";
     }
    
    lista.clear();
     
   }
   
  }
 }
 

}