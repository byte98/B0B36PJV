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
package cz.cvut.fel.skodaj.b0b36pjv.cv06.app;

import cz.cvut.fel.skodaj.b0b36pjv.cv06.gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class Main
{
    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run()
             {
                    Window main_window = new Window("My app");
                    main_window.pack();
                    main_window.setVisible(true);
             }
        });
    }
}
