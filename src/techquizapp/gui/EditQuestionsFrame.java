
package techquizapp.gui;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

public class EditQuestionsFrame extends javax.swing.JFrame {

    private Exam exam;
    private QuestionStore qStore;
    private int pos=0;
    private HashMap<String,String> options;
    int qno;
    private String question,option1, option2, option3, option4, correctOption;
    Color oldColour;
    
    public EditQuestionsFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUsername.setText("Hello " + UserProfile.getUserName());
        oldColour = lblLogout.getForeground();
        qStore = new QuestionStore();
        options = new HashMap<>();
        options.put("Option 1", "Answer1");
        options.put("Option 2", "Answer2");
        options.put("Option 3", "Answer3");
        options.put("Option 4", "Answer4");
        qno=1;
        lblQno.setText(lblQno.getText() + " " + qno);
    }
    public EditQuestionsFrame(Exam exam) {
        this();
        this.exam = exam;
        lblTitle.setText("EDITING " + exam.getLanguage().toUpperCase() + " PAPER");
        loadQuestions();
        showQuestion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOption2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOption3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOption4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbCorrectOption = new javax.swing.JComboBox<>();
        btnNext = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("TECH QUIZ APP");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUsername.setBackground(new java.awt.Color(0, 0, 0));
        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 204, 153));
        lblUsername.setText("Hello");

        lblLogout.setBackground(new java.awt.Color(0, 0, 0));
        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 204, 153));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 204, 153));
        lblTitle.setText("PAPER EDITING PANEL");

        lblQno.setBackground(new java.awt.Color(0, 0, 0));
        lblQno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 204, 153));
        lblQno.setText("Question ");

        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 153));
        jLabel3.setText("Option 1");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 153));
        jLabel4.setText("Option 2");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 153));
        jLabel5.setText("Option 3");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 153));
        jLabel6.setText("Option 4");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 153));
        jLabel7.setText("Correct Option");

        jcbCorrectOption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbCorrectOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4" }));

        btnNext.setBackground(new java.awt.Color(255, 204, 153));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 204, 153));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(255, 204, 153));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(255, 204, 153));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(49, 49, 49)
                            .addComponent(jcbCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 54, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(88, 88, 88))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(lblQno)
                                    .addGap(34, 34, 34)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogout)
                .addGap(32, 32, 32)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnCancel)
                    .addComponent(btnDone)
                    .addComponent(btnPrevious))
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(104, 104, 104)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblQno)
                            .addGap(109, 109, 109)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(195, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        lblLogout.setForeground(oldColour);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if(validateInput()==false){
            JOptionPane.showMessageDialog(null, "Please fill all the fields","Error!1",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String optionName = options.get(correctOption);
        Question obj = new Question(exam.getExamId(),qno,exam.getLanguage(),option1,option2,option3,option4,optionName,question);
        qStore.removeQuestion(pos);
        qStore.setQuestionAt(pos, obj);
        pos++;
        if(pos>=qStore.getCount()){
            JOptionPane.showMessageDialog(null, "Your questions are all edited successfully.\n Press on DONE button to add them to database","Questions edited",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(qStore);
            pos=0;
        }
        showQuestion();
        qno++;
        if(qno > qStore.getCount()){
            qno=1;
        }
         lblQno.setText("Question " + qno);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        try{
            QuestionDAO.updateQuestions(qStore);
            JOptionPane.showMessageDialog(null,"Your questions have been edited successfully to DB","Exam edited",JOptionPane.INFORMATION_MESSAGE);
            AdminOptionsFrame adminOptionsFrame = new AdminOptionsFrame();
            adminOptionsFrame.setVisible(true);
            this.dispose();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"DB error","Edit Questions Error!!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if(validateInput()==false){
            JOptionPane.showMessageDialog(null, "Please fill all the fields","Error!1",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String optionName = options.get(correctOption);
        Question obj = new Question(exam.getExamId(),qno,exam.getLanguage(),option1,option2,option3,option4,optionName,question);
        qStore.removeQuestion(pos);
        qStore.setQuestionAt(pos, obj);
        pos--;
        if(pos<0){
            JOptionPane.showMessageDialog(null, "Your questions are all edited successfully.\n Press on DONE button to add them to database","Questions edited",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(qStore);
            pos = qStore.getCount()-1;
        }
        showQuestion();
        qno--;
        if(qno <= 0){
            qno = qStore.getCount();
        }
         lblQno.setText("Question " + qno);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        EditPaperFrame editPaperFrame = new EditPaperFrame();
        editPaperFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void loadQuestions(){
        try{
            ArrayList<Question> quesList = QuestionDAO.getQuestionsByExamId(exam.getExamId());
            for(Question q: quesList)
                qStore.addQuestion(q); 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "DB Error","EditQuestionsFrame Error!!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private void showQuestion(){
        Question q = qStore.getQuestion(pos);
        txtQuestion.setText(q.getQuestion());
        txtOption1.setText(q.getAnswer1());
        txtOption2.setText(q.getAnswer2());
        txtOption3.setText(q.getAnswer3());
        txtOption4.setText(q.getAnswer4());
        String correctAnswer = q.getCorrectAnswer();
        String correctOpt = getKeyFromValue(correctAnswer);
        jcbCorrectOption.setSelectedItem(correctOpt);
    }
    private String getKeyFromValue(String value){
        Set<String> keys = options.keySet();
        for(String k: keys){
            String v = options.get(k);
            if(v.equals(value))
                return k;
        }
        return null;
    }
    private boolean validateInput(){
        question = txtQuestion.getText().trim();
        option1 = txtOption1.getText().trim();
        option2 = txtOption2.getText().trim();
        option3 = txtOption3.getText().trim();
        option4 = txtOption4.getText().trim();
        correctOption = jcbCorrectOption.getSelectedItem().toString();
        if(question.isEmpty()||option1.isEmpty()||option2.isEmpty()||option3.isEmpty()||option4.isEmpty()||correctOption.isEmpty())
            return false;
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestionsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCorrectOption;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}