package org.lumijiez.gui.util;

import javax.swing.*;
import java.awt.*;

public class ComboBoxRenderer {
    public static <T> void setRenderer(JComboBox<T> comboBox, T[] items) {
        comboBox.setModel(new DefaultComboBoxModel<>(items));
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    setText(value.toString());
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }
}

