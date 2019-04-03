/*
 * Copyright 2019 Jiří Škoda <skodaji4@fel.cvut.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.cvut.fel.skodaj.b0b36pjv.cv06.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;


/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class Window extends JFrame implements ActionListener
{
    private JButton plus;
    private JButton minus;
    private JButton reset;
    private JLabel label;
    private JTextField textbox;
    private JButton setVal;
    private JButton close;
    
    private SetValue setvalue_handler;
    
    private int value = 0;
    
    
    public Window(String title)
    {
        this.setTitle(title);
        

        
        this.label = new JLabel(Integer.toString(this.value));
        this.getContentPane().add(this.label);
        
        this.plus = new JButton("+");
        this.getContentPane().add(this.plus);
        this.plus.addActionListener(this);
        
        this.minus = new JButton("-");
        this.getContentPane().add(this.minus);
        this.minus.addActionListener(this);
        
        this.reset = new JButton("RESET");
        this.getContentPane().add(this.reset);
        this.reset.addActionListener(this);
        
        this.getContentPane().add(new JLabel("Set value:"));
        
        this.textbox = new JTextField();
        this.getContentPane().add(this.textbox);
        
        this.setvalue_handler = new SetValue(this.textbox, this.label);
        
        this.setVal = new JButton("SET");
        this.getContentPane().add(this.setVal);
        this.setVal.addActionListener(this.setvalue_handler);
        
        this.close = new JButton("EXIT");
        this.getContentPane().add(this.close);
        this.close.addActionListener(this);
        
        
        
        this.setLayout(new GridLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.value = Integer.parseInt(this.label.getText());
        if (e.getActionCommand() == "+")
        {
            this.value++;
        }
        else if (e.getActionCommand() == "-")
        {
            this.value--;
        }
        else if (e.getActionCommand() == "RESET")
        {
            this.value = 0;
        }
        this.setValue();
        if (e.getActionCommand() == "EXIT")
        {
            System.exit(0);
        }
    }
    
    private void setValue()
    {
        this.label.setText(Integer.toString(this.value));
    }
}
