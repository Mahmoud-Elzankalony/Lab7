import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class CourseWindow extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CourseWindow.class.getName());

    // Panel that will hold all dynamic checkboxes
    private JPanel lessonsPanel;
    ArrayList<String> lessons ;
    static Course course ;
    static Student student ;
    // Constructor now takes a list of lessons
    public CourseWindow( Course course , Student student ) {
        this.course = course ;
        this.student = student ;
        //this.lessons = course.getLessons();
        initComponents();
        addLessonCheckboxes(lessons); // add dynamic checkboxes
    }

    // Default constructor if needed
    public CourseWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        // Create lessons panel instead of a single checkbox
        lessonsPanel = new javax.swing.JPanel();
        lessonsPanel.setLayout(new javax.swing.BoxLayout(lessonsPanel, javax.swing.BoxLayout.Y_AXIS));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CourseTitle");
        jLabel2.setText("CourseId");
        jLabel3.setText("Description");
        jLabel4.setText("InstructorId");
        jLabel6.setText("Lessons Of Course");
        jLabel7.setText("Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lessonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(242, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lessonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(86, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(184, Short.MAX_VALUE)))
        );

        pack();
    }

    // Method to add dynamic checkboxes to lessonsPanel
    private void addLessonCheckboxes(ArrayList<String> lessons) {
        lessonsPanel.removeAll(); // Clear old checkboxes

        for (String lesson : lessons) {
            JCheckBox cb = new JCheckBox(lesson);
            lessonsPanel.add(cb);
        }

        lessonsPanel.revalidate();
        lessonsPanel.repaint();
    }
    private void jLabel5ComponentShown(java.awt.event.ComponentEvent evt) {
        // enrolled or enroll
        if (student.enrolledCourses.contains(course))
        {
            JLabel label = new JLabel("ENROLLED");
            Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
            label.setFont(cambriaBold20);
            jLabel5.setText("");
            jLabel5.setLayout(new java.awt.BorderLayout());
            jLabel5.add(label, BorderLayout.CENTER);
        }
        else
        {
            JButton button = new JButton("ENROLLED");
            button.setFont(new Font("Cambria", Font.BOLD, 20));

            button.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                    if (evt.getClickCount() == 2)
                    {
                        student.enroll(course);
                        JLabel label = new JLabel("ENROLLED");
                        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
                        label.setFont(cambriaBold20);
                        jLabel5.setText("");
                        jLabel5.setLayout(new java.awt.BorderLayout());
                        jLabel5.add(label, BorderLayout.CENTER);
                    }
                }
            });

        }
    }

    private void jLabel1ComponentShown(java.awt.event.ComponentEvent evt) {
        // course title
        JLabel label = new JLabel(course.getTitle().toUpperCase());
        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
        label.setFont(cambriaBold20);
    }

    private void jLabel7ComponentShown(java.awt.event.ComponentEvent evt) {
        // INFO
        JLabel label = new JLabel("INFO");
        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
        label.setFont(cambriaBold20);
    }

    private void jLabel2ComponentShown(java.awt.event.ComponentEvent evt) {
        // course id
        JLabel label = new JLabel(String.valueOf(course.getCourseId()));
        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
        label.setFont(cambriaBold20);
    }

    private void jLabel3ComponentShown(java.awt.event.ComponentEvent evt) {
        // description
        JLabel label = new JLabel(course.getDescription());
        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
        label.setFont(cambriaBold20);
    }

    private void jLabel4ComponentShown(java.awt.event.ComponentEvent evt) {
        // instructor id
        JLabel label = new JLabel(String.valueOf(course.getInstructorId()));
        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
        label.setFont(cambriaBold20);
    }

    private void jLabel6ComponentShown(java.awt.event.ComponentEvent evt) {
        // LESSONS OF COURSE
        JLabel label = new JLabel("LESSONS OF COURSE");
        Font cambriaBold20 = new Font("Cambria", Font.BOLD, 20);
        label.setFont(cambriaBold20);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            //ArrayList<String> lessons = new ArrayList<>();
            //Course course = new Course() ;
            //new CourseWindow(lessons).setVisible(true);
            new CourseWindow(course,student).setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
}

