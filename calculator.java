import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
public class calculator extends JFrame {
      public static void main(String[] args) {
            new calculator();
      }
      private Font mFont = new Font("Tahoma", Font.PLAIN, 18);
      private JTextField mTextValue = new JTextField("0", 15);
      private NumberFormat mFormat = NumberFormat.getNumberInstance();
      private boolean num1First = false;
      private boolean num2First = false;
      private double num1 = 0;
      private double num2 = 0;
      public calculator() {
            setTitle("Calculator");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            mFormat.setMaximumFractionDigits(10);

            mTextValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
            mTextValue.setEnabled(false);
            mTextValue.setDisabledTextColor(Color.BLUE);
            mTextValue.setBackground(new Color(230, 230, 230));
            mTextValue.setHorizontalAlignment(JTextField.RIGHT);
            mTextValue.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            add(mTextValue, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(5, 4));
            String[] captions = {
                    "+/-", "DEL", "C", "MOD",
                    "7", "8", "9", "/",
                    "4", "5", "6", "x",
                    "1", "2", "3", "-",
                    "0", ".", "=", "+"
            };

            JButton[] buttons = new JButton[captions.length];
            for(int i = 0; i < captions.length; i++) {
                  buttons[i] = new JButton(captions[i]);
                  buttons[i].setBackground(Color.BLACK);
                  buttons[i].setForeground(Color.white);
                  String caption = captions[i];
                  buttonPanel.add(buttons[i]);
		  buttons[i].addActionListener(e -> onButtonClick(caption));

            }

            btFont(buttonPanel);
            add(buttonPanel, BorderLayout.CENTER);
            pack();
            setVisible(true);
            mTextValue.grabFocus();
            mTextValue.requestFocus();
      }



      private void btFont(JPanel panel) {
            int count = panel.getComponentCount();
            for(int i = 0; i < count; i++) {
                  panel.getComponent(i).setFont(mFont);
            }
      }
     private double parseStringNumber(String value) {
            try {
                  return mFormat.parse(value).doubleValue();
            } catch(Exception ex) {
                  return 0;
            }
      }
      private void onButtonClick(String caption) {
            switch(caption) {
                  case "C":
			clear();
                        break;
                  case "DEL":

                  case "0":
                  case "1":
                  case "2":
                  case "3":
                  case "4":
                  case "5":
                  case "6":
                  case "7":
                  case "8":
                  case "9":
                        Clicknum(caption);
                        break;
                  case ".":

                  case "+/-":

                  case "+":
                  case "-":
                  case "x":
                  case "/":
                  case "MOD":

                  case "=":

            }
      }
      private void Clicknum(String value) {
            //ถ้าต้องใส่เพื่อเป็นเลขตัวแรก ให้ใส่แทนที่เลขเดิมลงไปเลย
            String text = mTextValue.getText();
            if(num1First || num2First) {
                  mTextValue.setText(value);
                  num1First = false;
                  num2First = false;
                  //เขียนแทนที่เลข 0 นั้น
            } else if(text.equals("0")) {
                  mTextValue.setText(value);
            } else if(text.equals("-0")) {
                  mTextValue.setText("-" + value);
            }
            //นำเลขนั้นไปต่อท้าย
            else {
                  String t = mTextValue.getText() + value;
                  double v = parseStringNumber(t);
                  t = mFormat.format(v);
                  mTextValue.setText(t);
            }
      }
            private void reset() {
            num1 = 0;
            num2 = 0;
            num1First= false;
            num2First = false;

      }
      private void clear() {
            reset();
            mTextValue.setText("0");
      }
}
