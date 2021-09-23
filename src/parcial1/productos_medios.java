
package parcial1;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class AlgoritmoProductoMedios extends JFrame
{ 
 private Container contenedor;
 private GridBagLayout esquema;
 private GridBagConstraints restricciones;
 JLabel l1, l2, l3, l4, l5, l6;
 JButton b1,b2,b3;
 JTextField t1,t2, t3;
 JTextArea a1, a2, a3;
 int n1=0, n2=0, ntamano=0, ctamano=0, multiplicacion=0;
 String dato1="", dato2="", dato3="", nn="", sub="", newcua="";
 String[] da1;
 String[] da2;
 String[] da3;
 int veces;
 

 public AlgoritmoProductoMedios()
 {
  setSize(350,350);
  setTitle("Algoritmo Producto de Medios");
  setVisible(true);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  
  contenedor=getContentPane();
  esquema=new GridBagLayout();
  contenedor.setLayout(esquema);
  
/*
  ((JPanel)getContentPane()).setOpaque(false);
  ImageIcon img = new ImageIcon("11.jpg");
  JLabel fondo = new JLabel(img);
  fondo.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
  getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
  */
  
  restricciones=new GridBagConstraints();  
  restricciones.insets=new Insets(10,10,10,10);
  
  restricciones.fill=GridBagConstraints.BOTH;
  // color fondo
  this.getContentPane().setBackground(new Color(230,150,30));

   l1=new JLabel("Algoritmo Producto de Medios");
   l1.setFont (new Font ("Constantia", Font.ITALIC, 30));
         l1.setForeground (Color.BLACK);
         establecerValores(0,0,4,1);
         restricciones.fill=GridBagConstraints.BOTH;
         esquema.setConstraints(l1,restricciones);
         contenedor.add(l1);
 
 //----- Valor de X0 -----  
   l2=new JLabel("Ingresa Valor de X0:");
   l2.setFont(new Font("Constantia",Font.BOLD,14));
   l2.setForeground(Color.BLACK);
   establecerValores(0,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l2,restricciones);
   contenedor.add(l2);
 
   t1=new JTextField(10);
   t1.setToolTipText("Escribe Numero");
   t1.setBorder(BorderFactory.createRaisedBevelBorder());
   establecerValores(2,2,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t1,restricciones);
   contenedor.add(t1);

 //----- Valor de Xi -----  
   l3=new JLabel("Ingresa Valor de Xi:");
   l3.setFont(new Font("Constantia",Font.BOLD,14));
   l3.setForeground(Color.BLACK);
   establecerValores(0,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l3,restricciones);
   contenedor.add(l3);
 
   t2=new JTextField(10);
   t2.setToolTipText("Escribe Numero");
   t2.setBorder(BorderFactory.createRaisedBevelBorder());
   establecerValores(2,3,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t2,restricciones);
   contenedor.add(t2);
         
 //----- Cantidad de numeros a generar -----
   l4=new JLabel("Cantidad de numeros a generar:");
   l4.setFont(new Font("Constantia",Font.BOLD,14));
   l4.setForeground(Color.BLACK);
   establecerValores(0,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);
 
   t3=new JTextField(10);
   t3.setToolTipText("Escribe Numero");
   t3.setBorder(BorderFactory.createRaisedBevelBorder());
   establecerValores(2,5,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(t3,restricciones);
   contenedor.add(t3);
      
   b1=new JButton("Calcular");
   b1.setBorder(new EmptyBorder(10,15,10,15));
   b1.setMnemonic(KeyEvent.VK_H);
   b1.setFont(new Font("Constantia",Font.BOLD,14));
   b1.setForeground(Color.BLACK);
   establecerValores(1,6,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b1,restricciones);
   contenedor.add(b1);

   b2=new JButton("Borrar");
   b2.setBorder(new EmptyBorder(10,15,10,15));
   b2.setMnemonic(KeyEvent.VK_L);
   b2.setFont(new Font("Constantia",Font.BOLD,14));
   b2.setForeground(Color.BLACK);
   establecerValores(3,6,2,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b2,restricciones);
   contenedor.add(b2);  
   
   //salida
   b3= new JButton("cerrar");
    b3.setBorder(new EmptyBorder(10,15,10,15));
    b3.setMnemonic(KeyEvent.VK_L);
   b3.setFont(new Font("Constantia",Font.BOLD,14));
   b3.setForeground(Color.BLACK);
   establecerValores(5,6,4,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(b3,restricciones);
   contenedor.add(b3);  
   
   l4=new JLabel("Yi");
   l4.setFont(new Font("Constantia",Font.BOLD,14));
   l4.setForeground(Color.BLACK);
   establecerValores(1,7,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l4,restricciones);
   contenedor.add(l4);

   a1=new JTextArea(10,8);
   a1.setEditable(false);
   a1.setBorder(BorderFactory.createRaisedBevelBorder());
   establecerValores(1,8,1,1);
   restricciones.fill=GridBagConstraints.EAST;
   esquema.setConstraints(a1,restricciones);
   contenedor.add(a1);
   
   l5=new JLabel("Xi");
   l5.setFont(new Font("Constantia",Font.BOLD,14));
   l5.setForeground(Color.BLACK);
   establecerValores(2,7,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l5,restricciones);
   contenedor.add(l5);
         
   a2=new JTextArea(10,6);
   a2.setEditable(false);
   a2.setBorder(BorderFactory.createRaisedBevelBorder());
   establecerValores(2,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a2,restricciones);
   contenedor.add(a2);

   l6=new JLabel("Ri");
   l6.setFont(new Font("Constantia",Font.BOLD,14));
   l6.setForeground(Color.BLACK);
   establecerValores(3,7,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(l6,restricciones);
   contenedor.add(l6);
         
   a3=new JTextArea(10,6);
   a3.setEditable(false);
   a3.setBorder(BorderFactory.createRaisedBevelBorder());
   establecerValores(3,8,1,1);
   restricciones.fill=GridBagConstraints.CENTER;
   esquema.setConstraints(a3,restricciones);
   contenedor.add(a3);
      
   ManejadorCamposTexto m=new ManejadorCamposTexto();
   b1.addActionListener(m);
   b2.addActionListener(m);
   
   pack();
   
 }
 
//**********************************************************************************
   public void establecerValores(int columna,int fila, int anchura, int altura)
   {
    restricciones.gridx=columna;
    restricciones.gridy=fila;
    
    restricciones.gridwidth=anchura;
    restricciones.gridheight=altura;
   }
//**********************************************************************************
      
 public static void main(String args[])
 {
  new AlgoritmoProductoMedios();
 }
 
  private class ManejadorCamposTexto implements ActionListener
 {
  public void actionPerformed(ActionEvent evento)
  {
   if (evento.getSource()==b1)
   {
    if(t1.getText().equals(""))   //********** Permite verificar si la caja de texto esta vacia **********//
    {
     JOptionPane.showMessageDialog(null,"Ingresa valor de semilla");
    }
    
    if(t2.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null,"Ingresa valor de semilla");
    }
    
    if(t3.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null,"Ingresa cantidad de datos");
    }     
    
    else
    {
     try
     {
         
    n1=Integer.parseInt(t1.getText());
    String nt1=String.valueOf(n1);
    
    n2=Integer.parseInt(t2.getText());
    String nt2=String.valueOf(n2);
    
    veces=Integer.parseInt(t3.getText());
    
     String nt=String.valueOf(n1);
     ntamano=nt.length();
    
     //----------------------------------
     // Esto Valida la cantidad de digitos que utilizaremos
    
    if(nt1.length()!=nt2.length())
    {
     JOptionPane.showMessageDialog(null,"Logitud de Xi debe ser igual a X1");
      t1.setText("");
      t2.setText("");
    }
    
    else
    {
     if(n1<=999 && n2<=999)
     {
      JOptionPane.showMessageDialog(null,"Valor de Xo y Xi debe ser mayor a tres digitos");
      t1.setText("");
      t2.setText("");
     }
     
     else
     {
      if(veces<=0)
      {
       JOptionPane.showMessageDialog(null,"El numero de datos a generar \nno puede ser igual o menor a 0","error",JOptionPane.ERROR_MESSAGE);
       t3.setText("");
      }
      
      else
      {
      
      for(int i=0;i<veces;i++)
      { 
       // cuadrado = multiplicacion    
       multiplicacion=n1*n2;
       String nn2=String.valueOf(n2);
       String cua=String.valueOf(multiplicacion);
       ctamano=cua.length();
       
        if(ctamano%2==0)
        {
         int d1=(ctamano-ntamano)/2;
         int d2=d1+ntamano;
         
         nn=String.valueOf(multiplicacion);
         sub=nn.substring(d1,d2);
         
         n1=Integer.parseInt(nn2);
         n2=Integer.parseInt(sub);
        }
        
        else
        {
         newcua="0"+cua;
         ctamano=newcua.length();
         
         //----- cheka
         int d1=(ctamano-ntamano)/2;
         int d2=d1+ntamano;
         
         nn=newcua;
         sub=nn.substring(d1,d2);
         
         n1=Integer.parseInt(nn2);
         n2=Integer.parseInt(sub);
                
        }
        
        da1=new String[veces];
        da1[i]=nn;
        dato1+="y"+i+":  "+da1[i]+"\n";
        
        da2=new String[veces];
        da2[i]=sub;
        dato2+="x"+(i+2)+":  "+da2[i]+"\n";
        
        da3=new String[veces];
        da3[i]="r"+i+":  0."+sub;
        dato3+=da3[i]+"\n";
        
       

      }
      
      }
      
       a1.setText(dato1);
       a2.setText(dato2);
       a3.setText(dato3);

    
     }
   }
     }
     
     catch(java.lang.NumberFormatException e)
     {
      JOptionPane.showMessageDialog(null,"Dato invalido");
      t1.setText("");
      t2.setText("");
      t3.setText("");
      a1.setText("");
      a2.setText("");
      a3.setText("");
     }
   
   }  // else

  }  // get source b1
  
   if(evento.getSource()==b2)
   {
    t1.setText("");
    t2.setText("");
    t3.setText("");
    a1.setText("");
    a2.setText("");
    a3.setText("");
     
     //----- Permite vaciar el arreglo -----
     
     if(dato1 != null && dato2 != null && dato3 != null)
     {
      dato1="";
      dato2="";
      dato3="";
     }
     
     if(da1 != null && da2 != null && da3 != null)
     {
      for(int x=0; x<veces; x++)
      {
       da1=null;
       da2=null;
       da3=null;
      }
     }
      
   
   }
 if(evento.getSource() == b3){
             System.exit(0);
        }
 
 }
   
  }
}

