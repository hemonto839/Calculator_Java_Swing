// Calculatar- Swing


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
      
     JFrame frame;
     JPanel text_panel;
     JPanel button_panel;
     JTextField textField;
     JButton[] numberButton= new JButton[10];
     JButton[] functionButtons= new JButton[9];
     JButton addButton,subButton,mulButton,divButton;
     JButton decButton,clrButton,delButton,eqButton,miButton;
     Font myFont= new Font("MV Boli",Font.BOLD,20);

     double a,b,ans=0;
     char operator;

    public Calculator(){

        frame= new JFrame("Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setLayout(null);
       

        text_panel= new JPanel();
        text_panel.setLayout(null);
        text_panel.setBounds(0, 0, 400, 100);
    

        textField= new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setEditable(false);
        textField.setFont(myFont);
        textField.setText("WelCome to My Calculator");

        button_panel= new JPanel();
        button_panel.setLayout(new GridLayout(4, 4, 2, 2));
        button_panel.setBounds(50, 101, 300, 300);


        // For function button

        addButton= new JButton("+");
        subButton= new JButton("-");
        mulButton= new JButton("*");
        divButton= new JButton("/");
        decButton= new JButton(".");
        clrButton= new JButton("Clr");
        delButton= new JButton("Del");
        eqButton= new JButton("=");
        miButton= new JButton("(-)");



        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=clrButton;
        functionButtons[6]=delButton;
        functionButtons[7]=eqButton;
        functionButtons[8]=miButton;

        for(int i= 0;i<9 ;i++){

            functionButtons[i].setFocusable(false);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
        }     
        
        // for number button
        for(int i=0 ;i<10 ;i++){
           numberButton[i]= new JButton(String.valueOf(i));
           numberButton[i].setFocusable(false);
           numberButton[i].setFont(myFont);
           numberButton[i].addActionListener(this);
        }

        button_panel.add(numberButton[1]);
        button_panel.add(numberButton[2]);
        button_panel.add(numberButton[3]);
        button_panel.add(addButton);
        button_panel.add(numberButton[4]);
        button_panel.add(numberButton[5]);
        button_panel.add(numberButton[6]);
        button_panel.add(subButton);
        button_panel.add(numberButton[7]);
        button_panel.add(numberButton[8]);
        button_panel.add(numberButton[9]);
        button_panel.add(mulButton);
        button_panel.add(numberButton[0]);
        button_panel.add(decButton);
        button_panel.add(miButton);
        button_panel.add(divButton);

        clrButton.setBounds(50, 420, 80, 50);
        delButton.setBounds(160, 420, 80, 50);
        eqButton.setBounds(270, 420, 80, 50);
        
        text_panel.add(textField);
        frame.add(text_panel);
        frame.add(button_panel);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(eqButton);

        frame.setVisible(true);
    }
     public static void main(String[] args) {
        new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0 ;i<10 ;i++){
            if(e.getSource()==numberButton[i]){
                  textField.setText(textField.getText().concat(String.valueOf(i)));            
            }
        }

        if(e.getSource()==addButton){
             a=Double.parseDouble(textField.getText());
             operator='+';
             textField.setText("");
        }
        if(e.getSource()==subButton){
            a=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
       }
       if(e.getSource()==mulButton){
        a=Double.parseDouble(textField.getText());
        operator='*';
        textField.setText("");
      }
      if(e.getSource()==divButton){
        a=Double.parseDouble(textField.getText());
        operator='/';
        textField.setText("");
      }
      if(e.getSource()==decButton){
        textField.setText(textField.getText().concat("."));
      }  
      if(e.getSource()==miButton){
        String text= textField.getText();
        textField.setText("-"+text);
      }

      if(e.getSource()==clrButton){
        textField.setText("");
      }
      if(e.getSource()==delButton){
        String string= textField.getText();
        textField.setText("");

        for(int i=0; i<string.length()-1;i++){
            textField.setText(textField.getText()+string.charAt(i));
        }
      }

      if(e.getSource()==eqButton){

        b= Double.parseDouble(textField.getText());

        switch(operator){
              case '+':{
                 ans=a+b;
                  textField.setText(""+ans);
                  break;
              }
              case '-':{
                ans=a-b;
                 textField.setText(""+ans);
                 break;
             }
             case '*':{
                ans=a*b;
                 textField.setText(""+ans);
                 break;
             }
             case '/':{
                ans=a/b;
                 textField.setText(""+ans);
                 break;
             }
           
        }
      }
    


    }
   
}