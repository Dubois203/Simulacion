
package parcial1;


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class AlgoritmoCongruencialLineal extends JFrame
{ 
 private Container contenedor;
 private GridBagLayout esquema;
 private GridBagConstraints restricciones;
 JLabel l1, l2, l3, l4, l5, l6;
 JButton b1,b2;
 JTextField t1,t2, t3, t4, t5, t6;
 JTextArea a1, a2, a3;
 int numero=0, valor1=0, veces=0, cantidad;
 String valor, ccuadrado="", sale="", cua="", erre="";
 String err;
 double[] r;
 int[] v;
 int num=2, m=1;
 
 public AlgoritmoCongruencialLineal()
 {
  setSize(350,350);
  setTitle("Algoritmo Congruencial Lineal");
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
  ImageIcon img = new ImageIcon("10.jpg");
  JLabel fondo = new JLabel(img);
  fondo.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
  getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
  //----------------------------------------------------------
  
  restricciones=new GridBagConstraints();  
  restricciones.insets=new Insets(5,5,5,5);
  
  restricciones.fill=GridBagConstraints.BOTH;

   l1=new JLabel("Algoritmo Congruencial Lineal");
   l1.setFont (new Font ("Courant", Font.BOLD, 30));
         l1.setForeground (Color.BLACK);
         establecerValores(0,0,4,1);
         restricciones.fill=GridBagConstraints.BOTH;
         esquema.setConstraints(l1,restricciones);
         contenedor.add(l1);
   
   l2=new JLabel("Ingresa Valor de Semilla:");
   l2.setFont(new Font("Courant",Font.PLAIN,14));
   l2.setForeground(Color.BLACK);
   establecerValores(0,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l2,restricciones);
   contenedor.add(l2);
 
   t1=new JTextField(10);
   t1.setToolTipText("Escribe Numero");
   t1.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLUE));
   establecerValores(2,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t1,restricciones);
   contenedor.add(t1);

   l3=new JLabel("Valor de Constante multiplicativa 'K':");
   l3.setFont(new Font("Courant",Font.PLAIN,14));
   l3.setForeground(Color.BLACK);
   establecerValores(0,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l3,restricciones);
   contenedor.add(l3);
 
   t2=new JTextField(10);
   t2.setToolTipText("Escribe Numero");
   t2.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLUE));
   establecerValores(2,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t2,restricciones);
   contenedor.add(t2);

   l4=new JLabel("Valor de Constante aditiva 'C':");
   l4.setFont(new Font("Courant",Font.PLAIN,14));
   l4.setForeground(Color.BLACK);
   establecerValores(0,4,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);
 
   t3=new JTextField(10);
   t3.setToolTipText("Escribe Numero");
   t3.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLUE));
   establecerValores(2,4,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t3,restricciones);
   contenedor.add(t3);
   
   l5=new JLabel("Valor de G:");
   l5.setFont(new Font("Courant",Font.PLAIN,14));
   l5.setForeground(Color.BLACK);
   establecerValores(0,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l5,restricciones);
   contenedor.add(l5);
 
   t4=new JTextField(10);
   t4.setToolTipText("Escribe Numero");
   t4.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLUE));
   establecerValores(2,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t4,restricciones);
   contenedor.add(t4);

   l6=new JLabel("Cantidad de numeros a generar:");
   l6.setFont(new Font("Courant",Font.PLAIN,14));
   l6.setForeground(Color.BLACK);
   establecerValores(0,6,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l6,restricciones);
   contenedor.add(l6);
 
   t5=new JTextField(10);
   t5.setToolTipText("Escribe Numero");
   t5.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLUE));
   establecerValores(2,6,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t5,restricciones);
   contenedor.add(t5);
         
   b1=new JButton("HaCeR");
   b1.setToolTipText("Clic Para Realizar Calculo");
   b1.setBorder(new EmptyBorder(10,15,10,15));
   b1.setMnemonic(KeyEvent.VK_H);
   b1.setFont(new Font("Courant",Font.PLAIN,14));
   b1.setForeground(Color.BLUE);
   establecerValores(1,7,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b1,restricciones);
   contenedor.add(b1);

   b2=new JButton("LiMpIaR");
   b2.setToolTipText("Clic Para Limpiar Datos");
   b2.setBorder(new EmptyBorder(10,15,10,15));
   b2.setMnemonic(KeyEvent.VK_L);
   b2.setFont(new Font("Courant",Font.PLAIN,14));
   b2.setForeground(Color.BLUE);
   establecerValores(3,7,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b2,restricciones);
   contenedor.add(b2);  

   l4=new JLabel("Xi");
   l4.setFont(new Font("Courant",Font.PLAIN,14));
   l4.setForeground(Color.BLACK);
   establecerValores(1,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);

   a1=new JTextArea(10,6);
   a1.setEditable(false);
   a1.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.BLUE));
   establecerValores(1,9,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a1,restricciones);
   contenedor.add(a1);
   
   l5=new JLabel("Ri");
   l5.setFont(new Font("Courant",Font.PLAIN,14));
   l5.setForeground(Color.BLACK);
   establecerValores(2,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l5,restricciones);
   contenedor.add(l5);
         
   a2=new JTextArea(10,6);
   a2.setEditable(false);
   a2.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.BLUE));
   establecerValores(2,9,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a2,restricciones);
   contenedor.add(a2);
     
   ManejadorCamposTexto m=new ManejadorCamposTexto();
   b1.addActionListener(m);
   b2.addActionListener(m);
   
   // ----- Para que aparezcan todos los componentes sin la necesidad
   // ----- de mover la ventana.
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
  new AlgoritmoCongruencialLineal();
 }
 
  private class ManejadorCamposTexto implements ActionListener
 {
  public void actionPerformed(ActionEvent evento)
  {
   if (evento.getSource()==b1)
   {
    if(t1.getText().equals("")|| t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals(""))   //********** Permite verificar si la caja de texto esta vacia **********//
    {
     JOptionPane.showMessageDialog(null,"Ingresa dato faltante");
    }
    
    else
    {
         
    try
    {
    int x=Integer.parseInt(t1.getText());
    int k=Integer.parseInt(t2.getText());
    int c=Integer.parseInt(t3.getText());
    int g=Integer.parseInt(t4.getText());
    int cantidad=Integer.parseInt(t5.getText());
     
     if(x<=0)
     {
      JOptionPane.showMessageDialog(null,"Semilla X debe ser mayor a 0");
      t1.setText("");
     }
     
     else
     {

     if(k<=0)
     {
      JOptionPane.showMessageDialog(null,"Constante K debe ser mayor a 0");
      t2.setText("");
     }
     
     else
     {

     if(c<=0)
     {
      JOptionPane.showMessageDialog(null,"Constante C debe ser mayor a 0");
      t3.setText("");
     }

     else
     {
      
     if(g<=0)
     {
      JOptionPane.showMessageDialog(null,"Constante G debe ser mayor a 0");
      t4.setText("");
     }

     else
     {
      
     if(cantidad<=0)
     {
      JOptionPane.showMessageDialog(null,"Cantidad de numeros que deseas generar?");
      t5.setText("");
     }
                         
     else
     {
      for(int j=0; j<g; j++)
      {
       m*=num;
      }
      
      int a=1+(4*k);
         
     for(int i=0; i<cantidad; i++)
     {  
      numero=(a*x+c)%m;
      
      String n1=String.valueOf(numero);
      x=Integer.parseInt(n1);

      
   v=new int[cantidad];
   r=new double[cantidad];
   v[i]=x;
   r[i]=(v[i]*1.0)/(m-1);   
   sale+="y"+(i+1)+":  "+v[i]+"\n";
 
   String err=String.format("%.5f",r[i]);
   erre+="r"+i+":  "+err+"\n";     
            
  } 
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
     JOptionPane.showMessageDialog(null,"Dato invalido");
     t1.setText("");
     t2.setText("");
     t3.setText("");
     t4.setText("");
     t5.setText("");
    }
     
    }
    
    
   }
   
   if(evento.getSource()==b2)
   {
    t1.setText("");
    t2.setText("");
    t3.setText("");
    t4.setText("");
    t5.setText("");
    a1.setText("");
    a2.setText("");
    
    if(sale != null && erre != null)
     {
      sale="";
      err="";
      erre="";
     }
    
    
    if(v != null && r != null)
    for(int j=0; j<cantidad; j++)
    {
     v=null;
     r=null;     
    }    
    
   }
   
  }
 }
 
}

