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
}
