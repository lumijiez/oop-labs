package org.lumijiez.gui.util;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.enums.Subjects;

import javax.swing.*;
import java.awt.*;

public class ComboBoxRenderers {
    public static void setFacultyRenderer(JComboBox<Faculty> facultyCombo) {
        facultyCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Faculty)
                    setText(((Faculty) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    public static void setGroupRenderer(JComboBox<Group> groupCombo) {
        groupCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Group)
                    setText(((Group) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    public static void setStudentRenderer(JComboBox<Student> studentCombo) {
        studentCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Student)
                    setText(((Student) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    public static void setSubjectRenderer(JComboBox<Subjects> subjectCombo) {
        subjectCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Subjects)
                    setText(((Subjects) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }
}
