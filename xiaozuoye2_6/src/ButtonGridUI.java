import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGridUI extends JFrame {

    // 所有按钮的数组形式管理
    private final JButton[] buttons = new JButton[20];
    private final int btnW = 150, btnH = 40;

    public ButtonGridUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 480));
        setLocationRelativeTo(null);

        JPanel content = new JPanel(null); // 绝对布局
        content.setBackground(Color.BLACK);
        getContentPane().setBackground(Color.BLACK);
        setContentPane(content);

        initButtons(content);      // 创建和布局按钮
        initListeners();          // 添加监听器
    }

    private void initButtons(JPanel panel) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
        }

        // 按钮位置设置
        buttons[0].setBounds(5 * btnW, 0, btnW, btnH); panel.add(buttons[0]);

        buttons[1].setBounds(5 * btnW, btnH, btnW / 3, btnH); panel.add(buttons[1]);
        buttons[2].setBounds(5 * btnW + btnW / 3, btnH, btnW / 3, btnH); panel.add(buttons[2]);
        buttons[3].setBounds(5 * btnW + 2 * btnW / 3, btnH, btnW / 3, btnH); panel.add(buttons[3]);

        buttons[4].setBounds(5 * btnW, 2 * btnH, btnW, btnH); panel.add(buttons[4]);
        buttons[5].setBounds(5 * btnW, 3 * btnH, btnW, btnH); panel.add(buttons[5]);

        buttons[6].setBounds(5 * btnW, 4 * btnH, btnW / 3, btnH); panel.add(buttons[6]);
        buttons[7].setBounds(5 * btnW + btnW / 3, 4 * btnH, btnW / 3, btnH); panel.add(buttons[7]);
        buttons[8].setBounds(5 * btnW + 2 * btnW / 3, 4 * btnH, btnW / 3, btnH); panel.add(buttons[8]);

        buttons[9].setBounds(5 * btnW, 5 * btnH, btnW, btnH); panel.add(buttons[9]);
        buttons[10].setBounds(5 * btnW, 6 * btnH, btnW, btnH); panel.add(buttons[10]);
        buttons[11].setBounds(5 * btnW, 7 * btnH, btnW, btnH); panel.add(buttons[11]);

        buttons[12].setBounds(0, 8 * btnH, btnW, 2 * btnH); panel.add(buttons[12]);
        buttons[13].setBounds(btnW, 8 * btnH, btnW, 2 * btnH); panel.add(buttons[13]);
        buttons[14].setBounds(2 * btnW, 8 * btnH, btnW, 2 * btnH); panel.add(buttons[14]);
        buttons[15].setBounds(3 * btnW, 8 * btnH, btnW, 2 * btnH); panel.add(buttons[15]);
        buttons[16].setBounds(4 * btnW, 8 * btnH, btnW, 2 * btnH); panel.add(buttons[16]);

        buttons[17].setBounds(5 * btnW, 8 * btnH, btnW, btnH); panel.add(buttons[17]);
        buttons[18].setBounds(5 * btnW, 9 * btnH, btnW, btnH); panel.add(buttons[18]);
    }

    private void initListeners() {
        // 清空按钮6文本
        buttons[4].addActionListener(e -> buttons[5].setText(""));

        // 清空按钮8文本
        buttons[6].addActionListener(e -> buttons[7].setText(""));

        // 切换按钮10可用状态
        buttons[8].addActionListener(e -> buttons[9].setEnabled(!buttons[9].isEnabled()));

        ActionListener sharedListenerForBtn15 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttons[9]) {
                    // 点击按钮10时,将按钮15的颜色变成红色,文字变成绿色
                    buttons[14].setBackground(Color.RED);
                    buttons[14].setForeground(Color.GREEN);
                    buttons[14].setOpaque(true);
                    buttons[14].setBorderPainted(false);
                } else if (e.getSource() == buttons[10]) {
                    // 点击按钮11时,将按钮15的颜色变成蓝色,文字变成红色
                    buttons[14].setBackground(Color.BLUE);
                    buttons[14].setForeground(Color.RED);
                    buttons[14].setOpaque(true);
                    buttons[14].setBorderPainted(false);
                }
            }
        };

        // 为按钮10和按钮11添加共享监听器
        buttons[9].addActionListener(sharedListenerForBtn15);
        buttons[10].addActionListener(sharedListenerForBtn15);
    }

    public static void main(String[] args) {
            ButtonGridUI app = new ButtonGridUI();
            app.setVisible(true);
    }
}